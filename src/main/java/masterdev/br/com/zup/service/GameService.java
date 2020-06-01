package masterdev.br.com.zup.service;

import javassist.NotFoundException;
import masterdev.br.com.zup.exception.InternalServerErrorException;
import masterdev.br.com.zup.model.user.User;
import masterdev.br.com.zup.model.game.Game;
import masterdev.br.com.zup.repository.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class GameService {

    final private GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {

        this.gameRepository = gameRepository;
    }

    public Game findOrCreateGame(User user) {
        try{
            return findGameByUser(user).orElseGet(() -> gameRepository.save(new Game(user.getNickName())));
        }catch(Exception exception){
            throw new InternalServerErrorException("Erro ao salvar game");
        }

    }
    public Game save(Game game) {
        try{
            return gameRepository.save(game);
        }catch(Exception exception){
            throw new InternalServerErrorException("Erro ao salvar game");
        }

    }

    public Optional<Game> findGameByUser(User user) {

        return gameRepository.findByPlayersNickName(user.getNickName());
    }
    public Game findGame(long id) throws NotFoundException {

        return gameRepository.findById(id).orElseThrow(()-> new NotFoundException("Game não encontrado"));
    }
    public Optional<Game> findGameById(long id)  {
            return gameRepository.findById(id).map(game ->game.verifyGameFinished());
    }

}
