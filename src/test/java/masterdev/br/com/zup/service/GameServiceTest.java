package masterdev.br.com.zup.service;

import masterdev.br.com.zup.model.user.User;
import masterdev.br.com.zup.model.game.Game;
import masterdev.br.com.zup.repository.GameRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GameServiceTest {
    @Mock
    GameRepository gameRepository;
    @InjectMocks
    GameService gameService;

    @Test
    public void when_no_game_it_should_create_game() {

        User user = new User();
        user.setNickName("nickname");
        user.setPassword("password");
        Game gameRequest = new Game("nickname");
        gameRequest.setId(0);

        when(gameRepository.findByPlayersNickName(user.getNickName())).thenReturn(Optional.empty());
        when(gameRepository.save(any())).thenReturn(gameRequest);
        Game game = gameService.findOrCreateGame(user);
        verify(gameRepository,times(1)).save(any());
        Assertions.assertEquals(gameRequest.getId(),game.getId());
    }

    @Test
    public void when_findorcreategame_it_should_not_create_game() {

        User user = new User();
        user.setNickName("nickname");
        user.setPassword("password");
        Game gameRequest = new Game("nickname");
        gameRequest.setId(0);

        when(gameRepository.findByPlayersNickName(user.getNickName())).thenReturn(Optional.of(gameRequest));

        Game game = gameService.findOrCreateGame(user);

        verify(gameRepository,times(0)).save(any());
        Assertions.assertEquals(gameRequest.getId(),game.getId());
    }
    @Test
    public void when_find_game_it_should_return_a_game() {

        User user = new User();
        user.setNickName("nickname");
        user.setPassword("password");
        Game gameRequest = new Game("nickname");
        gameRequest.setId(0);

        when(gameRepository.findByPlayersNickName(user.getNickName())).thenReturn(Optional.of(gameRequest));

        Optional<Game> game = gameService.findGameByUser(user);

        Assertions.assertEquals(gameRequest.getId(),game.get().getId());
    }
    @Test
    public void when_find_game_by_id_it_should_return_a_game() {

        User user = new User();
        user.setNickName("nickname");
        user.setPassword("password");
        Game gameRequest = new Game("nickname");
        gameRequest.setId(0);

        when(gameRepository.findById(gameRequest.getId())).thenReturn(Optional.of(gameRequest));

        Optional<Game> game = gameService.findGameById(gameRequest.getId());

        Assertions.assertEquals(gameRequest.getId(),game.get().getId());
    }
}
