package masterdev.br.com.zup.controller;

import masterdev.br.com.zup.dto.CardHandDto;
import masterdev.br.com.zup.dto.RoundDto;
import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.game.Game;
import masterdev.br.com.zup.model.players.PlayerTypeEnum;
import masterdev.br.com.zup.service.GameService;
import masterdev.br.com.zup.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin
public class RoundController {

    private GameService gameService;

    private RoundService roundService;

    @Autowired
    RoundController(GameService gameService, RoundService roundService){

        this.gameService = gameService;
        this.roundService = roundService;
    }

    @PostMapping (path = "/move")
    public Game moveUpdate(@RequestAttribute long idGame, @RequestBody RoundDto roundDto) {
        Game game = null;
        if (gameService.findGameById(idGame).isPresent()) {
            game = gameService.findGameById(idGame).get();
            if (roundDto.getPlayerType().equalsIgnoreCase(PlayerTypeEnum.JUNIOR.getName())) {
                try {
                    return roundService.roundJuniorEffect(roundDto, game);
                } catch (Exception exception) {
                    // TODO ResponseEntity com HttpStatus
                    return null;
                }
            } else if (roundDto.getPlayerType().equalsIgnoreCase(PlayerTypeEnum.BUG.getName())) {
                try {
                    return roundService.roundBugEffect(roundDto, game);
                } catch (Exception exception) {
                    // TODO ResponseEntity com HttpStatus
                    return null;
                }
            }
        }
        // TODO ResponseEntity com HttpStatus
        return null;
    }

    @PostMapping (path = "/skipround")
    public Game skipUpdate(@RequestAttribute long idGame) {
        Game game = null;
        if (gameService.findGameById(idGame).isPresent()) {
            game = gameService.findGameById(idGame).get();
            try {
                return roundService.skipEffect(game);
            } catch (Exception exception) {
                // TODO ResponseEntity com HttpStatus
                return null;
            }
        }
        // TODO ResponseEntity com HttpStatus
        return null;
    }

    @PostMapping (path = "/finishround")
    public Game finishRoundUpdate(@RequestAttribute long idGame, @RequestBody CardHandDto cardHandDto) {
        Game game = null;
        if (gameService.findGameById(idGame).isPresent()) {
            game = gameService.findGameById(idGame).get();
            try {
                return roundService.finishRoundEffect(game, cardHandDto.getBugHand(), cardHandDto.getJuniorHand());
            } catch (Exception exception) {
                // TODO ResponseEntity com HttpStatus
                return null;
            }
        }
        // TODO ResponseEntity com HttpStatus
        return null;
    }

}
