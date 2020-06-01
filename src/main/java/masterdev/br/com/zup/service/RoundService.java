package masterdev.br.com.zup.service;

import javassist.NotFoundException;
import masterdev.br.com.zup.dto.CardHandDto;
import masterdev.br.com.zup.dto.RoundDto;
import masterdev.br.com.zup.exception.BadRequestException;
import masterdev.br.com.zup.factory.Factory;
import masterdev.br.com.zup.log.LogGame;
import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;
import masterdev.br.com.zup.model.game.Game;

import masterdev.br.com.zup.model.players.PlayerTypeEnum;
import masterdev.br.com.zup.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoundService {

    private Factory factory;

    private GameService gameService;

    private UserService userService;

    @Autowired
    RoundService(Factory factory, GameRepository gameRepository, UserService userService, GameService gameService) {

        this.factory = factory;
        this.gameService = gameService;
        this.userService = userService;
    }

    public Game roundJuniorEffect(RoundDto roundDto, Game game) {
        new LogGame().log("INIT EFFECT JUNIOR" + game);
        Card card = factory.getCard(CardNameEnum.valueOf(roundDto.getName()));

        game.makeCardEffectJunior(card);
        if (game.isFinished()) {
            userService.updateWinScore(game.getJunior().getNickName());
        }

        gameService.save(game);
        new LogGame().log("FINISH EFFECT JUNIOR" + game);

        return game;
    }


    public Game roundBugEffect(RoundDto roundDto, Game game) {
        new LogGame().log("INIT EFFECT BUG" + game);
        Card card = factory.getCard(CardNameEnum.valueOf(roundDto.getName()));
        game.makeCardEffectBug(card);
        if (game.isFinished()) {
            userService.updateLossScore(game.getJunior().getNickName());
        }

        gameService.save(game);
        new LogGame().log("FINISH EFFECT BUG" + game);
        return game;
    }

    public Game skipRoundEffect(long idGame) throws NotFoundException {
        new LogGame().log("INIT SKIP ROUND EFFECT" + idGame);
        Game game = gameService.findGame(idGame);

        game.updateMove();
        gameService.save(game);

        new LogGame().log("FINISH SKIP ROUND EFFECT" + game.getMove());
        return game;
    }

    public Game finishRoundEffect(long idGame, CardHandDto cardHandDto) throws NotFoundException {
        new LogGame().log("INIT FINISH ROUND" + idGame);
        Game game = gameService.findGame(idGame);

        game.finishRound(cardHandDto.getBugHand(), cardHandDto.getJuniorHand());
        gameService.save(game);

        new LogGame().log("INIT FINISH ROUND" + game.getPlayers());
        return game;
    }

    public Game roundEffect(RoundDto roundDto, long idGame) throws NotFoundException {
        new LogGame().log("INIT ROUND EFFECT" + idGame);
        Game game = gameService.findGame(idGame);

        if (game.isFinished()) {
            game.restart();
        }
        if (roundDto.getPlayerType().equalsIgnoreCase(PlayerTypeEnum.JUNIOR.getName())) {
            game = this.roundJuniorEffect(roundDto, game);
        } else if (roundDto.getPlayerType().equalsIgnoreCase(PlayerTypeEnum.BUG.getName())) {
            game = this.roundBugEffect(roundDto, game);
        } else {
            throw new BadRequestException("player invalido");
        }

        new LogGame().log("FINISH ROUND EFFECT" + idGame);
        return game;
    }
}