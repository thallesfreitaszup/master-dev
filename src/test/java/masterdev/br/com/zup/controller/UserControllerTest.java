package masterdev.br.com.zup.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import masterdev.br.com.zup.model.user.User;
import masterdev.br.com.zup.model.user.UserRequest;
import masterdev.br.com.zup.service.GameService;
import masterdev.br.com.zup.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
@ContextConfiguration
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    MockMvc mockMvc;
    @BeforeEach
    public void setUp() {
//        mvc = MockMvcBuilders.standaloneSetup(new HandlerController()).build();
         mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @MockBean
    UserService userService;
    @MockBean
    GameService gameService;
    ObjectMapper mapper = new ObjectMapper();
    @Test
    public void when_user_already_exists_should_return_bad_request() throws Exception {
        long id = 1;
        User user = new User();
        user.setNickName("nickname");
        user.setPassword("password");

        UserRequest userRequest = new UserRequest();
        userRequest.setNickName("nickname");
        userRequest.setPassword("password");

        when(userService.findUser(any())).thenReturn(Optional.of(user));
        mockMvc.perform(post("/user")
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(userRequest)))
            .andExpect((status()).isBadRequest());

    }
    @Test
    public void when_user_dont_exist_should_create() throws Exception {
        long id = 1;
        User user = new User();
        user.setNickName("nickname");
        user.setPassword("password");

        UserRequest userRequest = new UserRequest();
        userRequest.setNickName("nickname");
        userRequest.setPassword("password");

        when(userService.findUser(any())).thenReturn(Optional.empty());
        mockMvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(userRequest)))
                .andExpect((status()).isCreated());


    }
}
