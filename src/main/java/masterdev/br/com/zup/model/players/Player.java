package masterdev.br.com.zup.model.players;

import masterdev.br.com.zup.model.card.Card;

import javax.persistence.*;
import java.util.List;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    protected int manaPoints;
    protected int life;
    @Enumerated
    protected PlayerTypeEnum type;
    @Transient
    protected List<Card> cards;

    protected String nickName;

    public Player(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PlayerTypeEnum getType() {
        return type;
    }

    public void setType(PlayerTypeEnum type) {
        this.type = type;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getManaPoints() {
        return manaPoints;
    }

    public void setManaPoints(int manaPoints) {
        this.manaPoints = manaPoints;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

}
