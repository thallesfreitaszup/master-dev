package masterdev.br.com.zup.controller;

import javassist.NotFoundException;
import masterdev.br.com.zup.dto.CardHandDto;
import masterdev.br.com.zup.dto.RoundDto;
import masterdev.br.com.zup.log.LogGame;
import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.game.Game;
import masterdev.br.com.zup.model.players.PlayerTypeEnum;
import masterdev.br.com.zup.service.GameService;
import masterdev.br.com.zup.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin
public class RoundController {

    private GameService gameService;

    private RoundService roundService;

    @Autowired
    RoundController(GameService gameService, RoundService roundService) {

        this.gameService = gameService;
        this.roundService = roundService;
    }

    @PostMapping(path = "/move")
    public ResponseEntity<Game> moveUpdate(@RequestAttribute long idGame, @RequestBody RoundDto roundDto) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(roundService.roundEffect(roundDto, idGame));
    }

    @PostMapping(path = "/skipround")
    public ResponseEntity<Game> skipUpdate(@RequestAttribute long idGame) throws NotFoundException {
            return ResponseEntity.status(HttpStatus.OK).body(roundService.skipRoundEffect(idGame));
    }

    @PostMapping(path = "/finishround")
    public ResponseEntity<Game> finishRoundUpdate(@RequestAttribute long idGame, @RequestBody CardHandDto cardHandDto) throws NotFoundException {
            return ResponseEntity.status(HttpStatus.OK).body(roundService.finishRoundEffect(idGame,cardHandDto));
    }

}
