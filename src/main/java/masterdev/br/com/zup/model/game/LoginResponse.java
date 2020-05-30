package masterdev.br.com.zup.model.game;

import masterdev.br.com.zup.security.JwtUtils;

public class LoginResponse {

    private long id;

    private String token;

    public LoginResponse(long id,String token) {

        this.id = id;
        this.token = token;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
