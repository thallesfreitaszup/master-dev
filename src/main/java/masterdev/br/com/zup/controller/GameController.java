package masterdev.br.com.zup.controller;

import masterdev.br.com.zup.model.game.Game;
import masterdev.br.com.zup.service.GameService;
import masterdev.br.com.zup.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class GameController {

    GameService gameService;

    PlayerService playerService;

    @Autowired
    public GameController(GameService gameService) {

        this.gameService = gameService;
    }

    @GetMapping()
    public ResponseEntity<Game> getGame(@RequestAttribute long idGame) {

        try {
            return gameService.findGameById(idGame)
                .map(game -> ResponseEntity.ok().body(game))
                .orElseGet(() -> ResponseEntity.badRequest().build());
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

}
