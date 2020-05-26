package masterdev.br.com.zup.model.user;

public class UserResponse {

    private  long id;

    private  String nickName;

    public UserResponse(long id, String nickName) {

        this.id = id;
        this.nickName = nickName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

}
