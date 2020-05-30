package masterdev.br.com.zup.service;

import masterdev.br.com.zup.dto.RoundDto;
import masterdev.br.com.zup.factory.Factory;
import masterdev.br.com.zup.log.LogGame;
import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;
import masterdev.br.com.zup.model.game.Game;
import masterdev.br.com.zup.model.game.GameStatusEnum;
import masterdev.br.com.zup.model.players.PlayerTypeEnum;
import masterdev.br.com.zup.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoundService {

    private Factory factory;

    private GameRepository gameRepository;

    private UserService userService;

    @Autowired
    RoundService(Factory factory, GameRepository gameRepository,UserService userService) {

        this.factory = factory;
        this.gameRepository = gameRepository;
        this.userService = userService;
    }

    public Game roundJuniorEffect(RoundDto cardDto, Game game) throws Exception {
        new LogGame().log("INIT EFFECT JUNIOR"+game.getPlayers()    );
        Card card = factory.getCard(CardNameEnum.valueOf(cardDto.getName()));
        new LogGame().log("INIT EFFECT JUNIOR"+card);
        game.getBug().damageEffect(card);
        if (game.getBug().isDead()) {
            game.setWinner(PlayerTypeEnum.JUNIOR.toString());
            game.setStatus(GameStatusEnum.FINISHED);
            userService.updateWinScore(game.getJunior().getNickName());
        }
        game.getJunior().manaEffect(card);
        game.setMove(game.getMove() + 1);
        game.getJunior().setUsedCard(card);
        new LogGame().log("FINISH EFFECT JUNIOR"+game.getPlayers());
        gameRepository.save(game);

        return game;
    }

    public Game roundBugEffect(RoundDto cardDto, Game game) throws Exception {
        new LogGame().log("INIT EFFECT BUG"+game.getPlayers());
        Card card = factory.getCard(CardNameEnum.valueOf(cardDto.getName()));
        if(card.getName().equals(CardNameEnum.GOLPENAOCONSIGO) || card.getName().equals(CardNameEnum.CODIGOMALESCRITO)){
            game.getJunior().manaJuniorEffect(card);
        }
        game.getJunior().damageEffect(card);
        if (game.getJunior().isDead()){
            game.setWinner(PlayerTypeEnum.BUG.toString());
            game.setStatus(GameStatusEnum.FINISHED);
            userService.updateLossScore(game.getJunior().getNickName());
        }
        game.getBug().manaEffect(card);
        game.setMove(game.getMove() + 1);
        game.getBug().setUsedCard(card);
        new LogGame().log("FINISH EFFECT BUG"+game.getPlayers());
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
