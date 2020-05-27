package masterdev.br.com.zup.controller;

import masterdev.br.com.zup.dto.CardDto;
import masterdev.br.com.zup.model.game.Game;
import masterdev.br.com.zup.model.players.PlayerTypeEnum;
import masterdev.br.com.zup.service.GameService;
import masterdev.br.com.zup.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Game updateMove(@RequestAttribute long idGame, CardDto cardDto, String playerType) {
        Game game = gameService.findGameById(idGame).get();
        if (playerType.equalsIgnoreCase(PlayerTypeEnum.JUNIOR.getName())) {
            try {
                return roundService.roundPlayerEffect(cardDto, game);
            } catch (Exception exception) {
                // TODO ResponseEntity com HttpStatus
                return null;
            }
        } else if (playerType.equalsIgnoreCase(PlayerTypeEnum.JUNIOR.getName())) {
            try {
                return roundService.roundBugEffect(cardDto, game);
            } catch (Exception exception) {
                // TODO ResponseEntity com HttpStatus
                return null;
            }
        }
        // TODO ResponseEntity com HttpStatus
        return null;
    }

    @PostMapping (path = "/skipround")
    public Game updateSkip(@RequestAttribute long idGame) {
        Game game = gameService.findGameById(idGame).get();
        try {
            return roundService.skipEffect(game);
        } catch (Exception exception) {
            // TODO ResponseEntity com HttpStatus
            return null;
        }
    }

}
