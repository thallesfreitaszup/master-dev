package masterdev.br.com.zup.controller;

import masterdev.br.com.zup.log.LogGame;
import masterdev.br.com.zup.model.game.Game;
import masterdev.br.com.zup.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
@CrossOrigin
public class GameController {

    GameService gameService;

    @Autowired
    public GameController(GameService gameService) {

        this.gameService = gameService;
    }

    @GetMapping()
    public ResponseEntity<Game> getGame(@RequestAttribute long idGame) {
        return gameService.findGameById(idGame)
            .map(game -> ResponseEntity.ok().body(game))
            .orElseGet(() -> ResponseEntity.badRequest().build());

    }

}
