package masterdev.br.com.zup.model.game;

import masterdev.br.com.zup.security.JwtUtils;

public class GameResponse {

    private long id;

    private String token;

    public GameResponse(long id) {

        this.id = id;
        this.token = JwtUtils.createJWT(this.id);
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
