package masterdev.br.com.zup.controller;

import javassist.NotFoundException;
import masterdev.br.com.zup.dto.UserData;
import masterdev.br.com.zup.log.LogGame;
import masterdev.br.com.zup.model.game.LoginResponse;
import masterdev.br.com.zup.model.user.User;
import masterdev.br.com.zup.model.user.UserRequest;
import masterdev.br.com.zup.model.game.Game;
import masterdev.br.com.zup.security.JwtUtils;
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

          return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userRequest.toEntity()));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody @Valid UserRequest userRequest) throws NotFoundException {

            final User user = userService.loginUser(userRequest);
            Game game = this.gameService.findOrCreateGame(user);
            return ResponseEntity.ok().body( new LoginResponse(user.getId(), JwtUtils.createJWT(game.getId())));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserData> userData(@PathVariable long id) throws NotFoundException {

            return ResponseEntity.ok().body(userService.userProfile(id));
    }

}
