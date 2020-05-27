package masterdev.br.com.zup.service;

import javassist.NotFoundException;
import masterdev.br.com.zup.dto.UserData;
import masterdev.br.com.zup.model.game.Game;
import masterdev.br.com.zup.model.user.User;
import masterdev.br.com.zup.model.user.UserRequest;
import masterdev.br.com.zup.model.user.UserResponse;
import masterdev.br.com.zup.repository.UserRepository;
import masterdev.br.com.zup.security.BcryptUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.BadCredentialsException;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;


    @Test
    public void it_should_find_user(){

        User user = new User();
        user.setNickName("nickname");
        user.setPassword("password");
        Game gameRequest = new Game("nickname");
        when(this.userRepository.findByNickName(user.getNickName())).thenReturn(Optional.of(user));
        Optional<User> userResponse =userService.findUser(user);
        Assertions.assertEquals(user.getNickName(),userResponse.get().getNickName());
    }
    @Test
    public void it_should_create_user(){
        //todo
        User user = new User();
        user.setNickName("nickname");
        user.setPassword("password");
        Game gameRequest = new Game("nickname");
        when(this.userRepository.save(user)).thenReturn(user);
        UserResponse userResponse =userService.saveUser(user);
        Assertions.assertEquals(user.getNickName(),userResponse.getNickName());
    }

    @Test
    public void it_should_authenticate_user() throws NotFoundException {
        User user = new User();
        user.setNickName("nickname");
        user.setPassword(BcryptUtils.getInstance().hash("password"));
        UserRequest userRequest = new UserRequest();
        userRequest.setNickName("nickname");
        userRequest.setPassword("password");
        when(this.userRepository.findByNickName(user.getNickName())).thenReturn(Optional.of(user));
        User userResponse =userService.loginUser(userRequest);
        Assertions.assertEquals(user.getNickName(),userResponse.getNickName());
    }
    @Test
    public void it_should_fail_authentication() throws NotFoundException {
        User user = new User();
        user.setNickName("nickname");
        user.setPassword(BcryptUtils.getInstance().hash("password"));
        UserRequest userRequest = new UserRequest();
        userRequest.setNickName("nickname");
        userRequest.setPassword("password123");
        when(this.userRepository.findByNickName(user.getNickName())).thenReturn(Optional.of(user));
        Assertions.assertThrows(BadCredentialsException.class,()-> userService.loginUser(userRequest));
    }
    @Test
    public void it_should_throws_not_found() throws NotFoundException {
        User user = new User();
        user.setNickName("nickname");
        user.setPassword(BcryptUtils.getInstance().hash("password"));
        UserRequest userRequest = new UserRequest();
        userRequest.setNickName("nickname");
        userRequest.setPassword("password123");
        when(this.userRepository.findByNickName(user.getNickName())).thenReturn(Optional.empty());
        Assertions.assertThrows(NotFoundException.class,()-> userService.loginUser(userRequest));
    }

    @Test
    public void it_should_get_User_data_information() throws NotFoundException {
        User user = new User();
        user.setId(1L);
        user.setNickName("nickName");
        when(this.userRepository.findByNickName(user.getNickName())).thenReturn(Optional.of(user));
        UserData userdata = this.userService.userProfile(user.getNickName());
        Assertions.assertEquals(user.getId(),userdata.getId());
    }

    @Test
    public void it_should_get_User_data_information_notFound(){
        User user = new User();
        user.setId(1L);
        user.setNickName("nickName");
        when(this.userRepository.findByNickName(user.getNickName())).thenReturn(Optional.empty());
        Assertions.assertThrows(NotFoundException.class,()->this.userService.userProfile(user.getNickName()));
    }
}
