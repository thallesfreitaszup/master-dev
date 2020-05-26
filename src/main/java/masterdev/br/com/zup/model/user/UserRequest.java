package masterdev.br.com.zup.model.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRequest {

    @NotNull
    private String nickName;

    @NotNull
    @Size(min= 6,message = "Senha com no minimo seis letras")
    private String password;

    public User toEntity() {

        return new User(this.nickName,this.password);
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
