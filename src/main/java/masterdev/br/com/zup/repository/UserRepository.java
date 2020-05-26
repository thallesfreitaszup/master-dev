package masterdev.br.com.zup.repository;

import masterdev.br.com.zup.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByNickName(String nickName);

}
