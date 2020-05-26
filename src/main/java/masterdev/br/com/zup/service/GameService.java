package masterdev.br.com.zup.service;

import masterdev.br.com.zup.model.user.User;
import masterdev.br.com.zup.model.game.Game;
import masterdev.br.com.zup.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class GameService {

    final private GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {

        this.gameRepository = gameRepository;
    }

    @Transactional
    public Game findOrCreateGame(User user) {

         return findGame(user).orElseGet(() -> gameRepository.save(new Game(user.getNickName())));
    }

    public Optional<Game> findGame(User user) {

        return gameRepository.findByPlayersNickName(user.getNickName());
    }

    public Optional<Game> findGameById(long id) {

        return gameRepository.findById(id);
    }

}
