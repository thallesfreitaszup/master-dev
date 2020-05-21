package masterdev.br.com.zup.model.game;

import masterdev.br.com.zup.model.players.Bug;
import masterdev.br.com.zup.model.players.Junior;
import masterdev.br.com.zup.model.players.Player;

import java.util.Arrays;
import java.util.List;

public class Game {
    private static Game game;
    private List<Player> players;

    private Game() {
        players = Arrays.asList(new Junior(),new Bug());
    }
    public static Game getInstance(){
      return  game == null ? (game = new Game()) : game;
    }
    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
