package masterdev.br.com.zup.repository;

import masterdev.br.com.zup.model.game.Game;
import masterdev.br.com.zup.model.players.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game,Long> {
    public Optional<Game> findByPlayersNickName(String name);

}
