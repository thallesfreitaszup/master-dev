package masterdev.br.com.zup.model;

import masterdev.br.com.zup.model.players.Player;
import masterdev.br.com.zup.security.BcryptUtils;
import masterdev.br.com.zup.security.JwtUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_game")
public class User {
    @Id
    private long id;
    private String nickName;
    private String password;
    public User() {

    }
    public User(String nickName, String password) {
        this.password = BcryptUtils.getInstance().hash(password);
        this.nickName = nickName;

    }

    public boolean matchPassword(String password) {

        return BcryptUtils.getInstance().matches(password,this.password);
    }
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
