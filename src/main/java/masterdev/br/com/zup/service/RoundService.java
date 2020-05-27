package masterdev.br.com.zup.service;

import masterdev.br.com.zup.dto.CardDto;
import masterdev.br.com.zup.factory.Factory;
import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;
import masterdev.br.com.zup.model.game.Game;
import masterdev.br.com.zup.model.players.Player;
import masterdev.br.com.zup.model.players.PlayerTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoundService {

    private Factory factory;

    @Autowired
    RoundService(Factory factory) {

        this.factory = factory;
    }

    public Game roundPlayerEffect(CardDto cardDto, Game game) throws Exception {

        Card card = factory.getCard(CardNameEnum.valueOf(cardDto.getName()));

        int lifeBug = game.getPlayers().get(0).getLife() - card.getDamage();
        Player bug = game.getPlayers().get(0);
        bug.setLife(lifeBug);
        if (lifeBug <= 0)
            game.setWinner(PlayerTypeEnum.JUNIOR.toString());

        int manaJunior = game.getPlayers().get(1).getMana() + card.getManaPoints();
        Player junior = game.getPlayers().get(1);
        junior.setMana(manaJunior);

        List<Player> players = new ArrayList<>();
        players.add(bug);
        players.add(junior);
        game.setPlayers(players);

        int move = game.getMove();
        move ++;
        game.setMove(move);

        return game;
    }

    public Game roundBugEffect(CardDto cardDto, Game game) throws Exception {

        Card card = factory.getCard(CardNameEnum.valueOf(cardDto.getName()));

        int lifeJunior = game.getPlayers().get(1).getLife() - card.getDamage();
        Player junior = game.getPlayers().get(1);
        junior.setLife(lifeJunior);

        int manaBug = game.getPlayers().get(0).getMana() + card.getManaPoints();
        Player bug = game.getPlayers().get(0);
        bug.setMana(manaBug);

        List<Player> players = new ArrayList<>();
        players.add(junior);
        players.add(bug);
        game.setPlayers(players);

        int move = game.getMove();
        move ++;
        game.setMove(move);

        return game;
    }

    public Game skipEffect(Game game) {

        int move = game.getMove();
        move ++;
        game.setMove(move);

        return game;
    }

    public Game finishRoundEffect(Game game, List<Card> bugHand, List<Card> juniorHand) {

        List bugCards = game.getPlayers().get(0).getCards();

        for (Card pos : bugHand) ;

        List juniorCards = game.getPlayers().get(1).getCards();

        return game;
    }

}
