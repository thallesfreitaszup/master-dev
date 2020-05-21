package masterdev.br.com.zup.controller;

import masterdev.br.com.zup.model.game.Game;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/game")
public class GameController {

    @GetMapping
    public Game createGame() {
        return Game.getInstance();
    }
}
