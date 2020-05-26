package masterdev.br.com.zup.controller;

import masterdev.br.com.zup.model.game.GameResponse;
import masterdev.br.com.zup.model.user.User;
import masterdev.br.com.zup.model.user.UserRequest;
import masterdev.br.com.zup.model.game.Game;
import masterdev.br.com.zup.service.GameService;
import masterdev.br.com.zup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
              .orElseGet(() -> ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(userRequest.toEntity())));
        } catch(Exception e ) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
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
