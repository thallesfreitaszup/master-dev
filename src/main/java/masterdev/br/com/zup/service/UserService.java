package masterdev.br.com.zup.service;

import javassist.NotFoundException;
import masterdev.br.com.zup.dto.UserData;
import masterdev.br.com.zup.model.user.User;
import masterdev.br.com.zup.model.user.UserRequest;
import masterdev.br.com.zup.model.user.UserResponse;
import masterdev.br.com.zup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public UserResponse saveUser(User user) {

        try {
            return this.userRepository.save(user).toResponse();
        } catch(Exception e ) {
            throw e;
        }
    }

    public Optional<User> findUser(User user) {

        try {
            return this.userRepository.findByNickName(user.getNickName());
        } catch(Exception e ) {
            throw e;
        }
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

    public UserData userProfile(long id) throws NotFoundException {

        Optional<User> user = this.userRepository.findById(id);

        if(user.isPresent()) {
             return new UserData(user.get().getId(), user.get().getNickName(), user.get().getWins(), user.get().getLoss());
        }else {
            throw new NotFoundException("Player não encontrado");
        }

    }

    public void updateWinScore(String nickName) {
        this.userRepository.findByNickName(nickName).map(
          user -> user.updateWins()
        ).map(user -> userRepository.save(user));
    }

    public void updateLossScore(String nickName) {
        this.userRepository.findByNickName(nickName).map(
                user -> user.updateLoss()
        ).map(user -> userRepository.save(user));
    }
  
}
