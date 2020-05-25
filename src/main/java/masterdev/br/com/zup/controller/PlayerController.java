package masterdev.br.com.zup.controller;

import masterdev.br.com.zup.service.GameService;
import masterdev.br.com.zup.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("player")
public class PlayerController {

    PlayerService playerService;

    GameService gameService;

    @Autowired
    PlayerController(PlayerService playerService,GameService gameService) {

        this.playerService = playerService;
        this.gameService = gameService;
    }

}
