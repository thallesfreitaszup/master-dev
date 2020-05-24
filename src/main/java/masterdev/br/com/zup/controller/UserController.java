package masterdev.br.com.zup.controller;

import masterdev.br.com.zup.dto.GameResponse;
import masterdev.br.com.zup.model.User;
import masterdev.br.com.zup.model.UserRequest;
import masterdev.br.com.zup.model.UserResponse;
import masterdev.br.com.zup.model.game.Game;
import masterdev.br.com.zup.service.GameService;
import masterdev.br.com.zup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@RequestMapping("/user")
@RestController
public class UserController {
    UserService userService;
    GameService gameService;
    @Autowired
    UserController(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }
    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody @Valid UserRequest userRequest){
        try{
              return userService.findUser(userRequest.toEntity())
              .map(user -> ResponseEntity.status(400).build())
              .orElseGet(() -> ResponseEntity.status(201).body(userService.saveUser(userRequest.toEntity())) );
        }catch(Exception e ){
            System.out.println(e);
            return ResponseEntity.status(500).build();
        }
    }


    @PostMapping("/login")
    public ResponseEntity<GameResponse> loginUser(@RequestBody @Valid UserRequest userRequest){
        try{
            final User user = userService.loginUser(userRequest);
            Game game = this.gameService.findOrCreateGame(user);
            return ResponseEntity.status(200).body(game.toResponse());
        }catch(Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(400).build();
        }
    }
}
