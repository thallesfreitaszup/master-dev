package masterdev.br.com.zup.service;

import javassist.NotFoundException;
import masterdev.br.com.zup.model.User;
import masterdev.br.com.zup.model.UserRequest;
import masterdev.br.com.zup.model.UserResponse;
import masterdev.br.com.zup.model.players.Player;
import masterdev.br.com.zup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {
    UserRepository userRepository;
    @Autowired
    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserResponse saveUser(User user){
        try{
            return this.userRepository.save(user).toResponse();
        }catch(Exception e ){
            throw e;
        }
    }
    public Optional<User> findUser(User user){
        try{
            return this.userRepository.findByNickName(user.getNickName());
        }catch(Exception e ){
            throw e;
        }
    }
    public User loginUser(UserRequest userRequest) throws NotFoundException {
        final User userDB = this.userRepository.findByNickName(userRequest.getNickName())
                .orElseThrow(()-> new NotFoundException("Player não encontrado"));
        if(userDB.matchPassword(userRequest.getPassword())){
            return userDB;
        }else{
            throw new BadCredentialsException("Nick ou senha inválido");
        }
    }
}
