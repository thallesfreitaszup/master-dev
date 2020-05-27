package masterdev.br.com.zup.service;

import masterdev.br.com.zup.dto.CardDto;
import masterdev.br.com.zup.factory.Factory;
import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;
import masterdev.br.com.zup.model.game.Game;
import masterdev.br.com.zup.model.players.PlayerTypeEnum;
import masterdev.br.com.zup.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoundService {

    private Factory factory;

    private GameRepository gameRepository;

    @Autowired
    RoundService(Factory factory, GameRepository gameRepository) {

        this.factory = factory;
        this.gameRepository = gameRepository;
    }

    public Game roundJuniorEffect(CardDto cardDto, Game game) throws Exception {

        Card card = factory.getCard(CardNameEnum.valueOf(cardDto.getName()));

        game.getBug().damageEffect(card);
        if (game.getBug().isDead())
            game.setWinner(PlayerTypeEnum.JUNIOR.toString());
        game.getJunior().manaEffect(card);
        game.setMove(game.getMove() + 1);

        gameRepository.save(game);

        return game;
    }

    public Game roundBugEffect(CardDto cardDto, Game game) throws Exception {

        Card card = factory.getCard(CardNameEnum.valueOf(cardDto.getName()));

        game.getJunior().damageEffect(card);
        if (game.getJunior().isDead())
            game.setWinner(PlayerTypeEnum.BUG.toString());
        game.getBug().manaEffect(card);
        game.setMove(game.getMove() + 1);

        gameRepository.save(game);

        return game;
    }

    public Game skipEffect(Game game) {

        game.setMove(game.getMove() + 1);

        gameRepository.save(game);

        return game;
    }

    public Game finishRoundEffect(Game game, List<Card> bugHand, List<Card> juniorHand) {

        game.getBug().shuffleUsedCard(bugHand);
        game.getBug().setMana(game.getBug().getMana() + 2);
        game.getJunior().shuffleUsedCard(juniorHand);
        game.getJunior().setMana(game.getJunior().getMana() + 2);

        gameRepository.save(game);

        return game;
    }

}
