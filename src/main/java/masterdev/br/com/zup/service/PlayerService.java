package masterdev.br.com.zup.service;

import javassist.NotFoundException;
import masterdev.br.com.zup.model.User;
import masterdev.br.com.zup.model.UserRequest;
import masterdev.br.com.zup.model.players.Player;
import masterdev.br.com.zup.repository.PlayerRepository;
import masterdev.br.com.zup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    PlayerRepository playerRepository;

    UserRepository userRepository;

    @Autowired
    PlayerService(PlayerRepository playerRepository, UserRepository userRepository) {

        this.playerRepository = playerRepository;
        this.userRepository = userRepository;
    }

    public User loginUser(UserRequest userRequest) throws NotFoundException {

       final User userDB = this.userRepository.findByNickName(userRequest.getNickName())
           .orElseThrow(()-> new NotFoundException("Player não encontrado"));
        if(userDB.matchPassword(userRequest.getPassword())) {
            return userDB;
        } else {
            throw new BadCredentialsException("Nick ou senha inválido");
        }
    }

    public Player findPlayerById(long id) throws NotFoundException {

        return this.playerRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Player não encontrado"));
    }

}
