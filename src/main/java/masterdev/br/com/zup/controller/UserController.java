package masterdev.br.com.zup.controller;

import masterdev.br.com.zup.dto.GameResponse;
import masterdev.br.com.zup.model.User;
import masterdev.br.com.zup.model.UserRequest;
import masterdev.br.com.zup.model.game.Game;
import masterdev.br.com.zup.service.GameService;
import masterdev.br.com.zup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RequestMapping("/user")
@RestController
@CrossOrigin
public class UserController {

    UserService userService;

    GameService gameService;

    @Autowired
    UserController(UserService userService, GameService gameService) {

        this.userService = userService;
        this.gameService = gameService;
    }

    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody @Valid UserRequest userRequest) {

        try {
              return userService.findUser(userRequest.toEntity())
              .map(user -> ResponseEntity.badRequest().build())
              .orElseGet(() -> ResponseEntity.created(URI.create("/user/" + userRequest.getNickName())).body(userService.saveUser(userRequest.toEntity())) );
        } catch(Exception e ) {
            System.out.println(e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<GameResponse> loginUser(@RequestBody @Valid UserRequest userRequest) {

        try {
            final User user = userService.loginUser(userRequest);
            Game game = this.gameService.findOrCreateGame(user);
            return ResponseEntity.ok().body(game.toResponse());
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

}
