package masterdev.br.com.zup.sort;

import masterdev.br.com.zup.model.players.Player;

import java.util.Comparator;

public class PlayerCompare  implements Comparator<Player> {

    @Override
    public int compare(Player player, Player player1) {
        return player.getType().getName().compareTo(player1.getType().getName());
    }
}
