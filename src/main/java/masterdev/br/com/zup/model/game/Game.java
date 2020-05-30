package masterdev.br.com.zup.model.game;

import com.fasterxml.jackson.annotation.JsonIgnore;
import masterdev.br.com.zup.model.players.Bug;
import masterdev.br.com.zup.model.players.Junior;
import masterdev.br.com.zup.model.players.Player;
import masterdev.br.com.zup.sort.PlayerCompare;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(cascade=CascadeType.ALL)
    private List<Player> players;

    private GameStatusEnum status;

    private String winner;

    private int move;

    public Game() {

    }

    public Game(String nickName) {
        this();
        players = Arrays.asList(new Bug(), new Junior(nickName,move));
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

}
