package masterdev.br.com.zup.model.user;

import masterdev.br.com.zup.security.BcryptUtils;

import javax.persistence.*;

@Entity
@Table(name="user_game")
public class User {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String nickName;

    private String password;

    private int wins;

    private int loss;

    public User() {

    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoss() {
        return loss;
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }

    public User(String nickName, String password) {

        this.password = BcryptUtils.getInstance().hash(password);
        this.nickName = nickName;
    }

    public UserResponse toResponse() {

        return new UserResponse(this.id,this.nickName);
    }

    public boolean matchPassword(String password) {

        return BcryptUtils.getInstance().matches(password,this.password);
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User updateWins(){
        this.wins++;
        return this;
    }

    public User updateLoss(){
        this.loss++;
        return this;
    }

}
