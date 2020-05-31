package masterdev.br.com.zup.model.game;

import com.fasterxml.jackson.annotation.JsonIgnore;
import masterdev.br.com.zup.exception.InternalServerErrorException;
import masterdev.br.com.zup.log.LogGame;
import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;
import masterdev.br.com.zup.model.players.Bug;
import masterdev.br.com.zup.model.players.Junior;
import masterdev.br.com.zup.model.players.Player;
import masterdev.br.com.zup.model.players.PlayerTypeEnum;
import masterdev.br.com.zup.sort.PlayerCompare;
import org.springframework.web.client.HttpServerErrorException;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static masterdev.br.com.zup.model.players.PlayerTypeEnum.BUG;
import static masterdev.br.com.zup.model.players.PlayerTypeEnum.JUNIOR;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Player> players;

    private GameStatusEnum status;

    private String winner;

    private int move;

    public Game() {

    }

    public Game(String nickName) {
        this();
        players = Arrays.asList(new Bug(), new Junior(nickName));
        this.status = GameStatusEnum.RUNNING;
        this.move = 1;
    }

    @JsonIgnore
    public Player getBug() {

        return this.players.get(0);
    }

    @JsonIgnore
    public Player getJunior() {

        return this.players.get(1);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Player> getPlayers() {
        players.sort(new PlayerCompare());
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public GameStatusEnum getStatus() {
        return status;
    }

    public void setStatus(GameStatusEnum status) {
        this.status = status;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", players=" + players +
                ", status=" + status +
                ", winner='" + winner + '\'' +
                ", move=" + move +
                '}';
    }

    public void finishGame(String winner) {
        this.winner = winner;
        this.status = GameStatusEnum.FINISHED;
    }

    public void makeCardEffectJunior(Card card) {
        try {
            this.getBug().damageEffect(card);
            this.getJunior().manaEffect(card);
            if (this.getBug().isDead()) {
                this.finishGame(JUNIOR.getName());
            }
            this.updateMove();
            this.getJunior().setUsedCard(card);
        } catch (Exception exception) {
            new LogGame().error(exception.getMessage());
            throw new InternalServerErrorException("Erro na jogada do junior");
        }
    }

    public void updateMove() {
        this.move++;
    }
    @JsonIgnore
    public boolean isFinished() {
        return this.status == GameStatusEnum.FINISHED;
    }

    public void makeCardEffectBug(Card card) {
        try {
            if (card.getName().equals(CardNameEnum.GOLPENAOCONSIGO) || card.getName().equals(CardNameEnum.CODIGOMALESCRITO)) {
                this.getJunior().manaJuniorEffect(card);
            }
            this.getJunior().damageEffect(card);
            this.getBug().manaEffect(card);
            if (this.getJunior().isDead()) {
                this.finishGame(BUG.getName());
            }
            this.updateMove();
            this.getBug().setUsedCard(card);
        } catch (Exception exception) {
            new LogGame().error(exception.getMessage());
            throw new InternalServerErrorException("Erro na jogada do bug");
        }
    }

    public void finishRound(List<Card> bugHand, List<Card> juniorHand) {
        try {
            this.getBug().shuffleUsedCard(bugHand);
            this.getBug().updateManaRound();
            this.getJunior().updateManaRound();
            this.getJunior().shuffleUsedCard(juniorHand);
        } catch (Exception exception) {
            new LogGame().error(exception.getMessage());
            throw new InternalServerErrorException("Erro atualizando rodada");
        }
    }

    public void restart() {
        this.status = GameStatusEnum.RUNNING;
        this.players = this.getPlayers().stream().map(Player::restoreLifeAndMana).collect(Collectors.toList());
        this.move = 1;
        this.winner = null;
    }

    public Game verifyGameFinished() {
        if (this.isFinished()) {
            this.restart();
        }
        return this;
    }
}
