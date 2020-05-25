package masterdev.br.com.zup.model.game;

import masterdev.br.com.zup.dto.GameResponse;
import masterdev.br.com.zup.model.players.Bug;
import masterdev.br.com.zup.model.players.Junior;
import masterdev.br.com.zup.model.players.Player;

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

    private String status;

    private String winner;

    public Game() {

    }

    public Game(String nickName) {

        players = Arrays.asList(new Junior(nickName),new Bug());
    }

    public GameResponse toResponse() {

        return new GameResponse(this.id);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

}
