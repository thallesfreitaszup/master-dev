package masterdev.br.com.zup.repository;

import masterdev.br.com.zup.model.players.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    public Optional<Player> findByNickName(String nickName);
}
