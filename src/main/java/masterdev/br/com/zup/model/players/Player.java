package masterdev.br.com.zup.model.players;

import masterdev.br.com.zup.model.card.Card;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    protected int mana;

    protected int life;

    protected List<Card> hand;

    @Enumerated
    protected PlayerTypeEnum type;

    @Transient
    protected List<Card> cards;

    protected String imageUrl;

    protected String nickName;

    public Player() {

    }

    public List<Card> shuffleInitialHand() {

        Collections.shuffle(this.cards);
        return this.hand = this.cards.subList(0,4);
    }

    public void shuffleUsedCard(List<Card> cardHand) {

        List<Card> filtered = this.cards.stream().filter(card -> !cardHand.contains(card)).collect(Collectors.toList());
        Collections.shuffle(filtered);
        cardHand.add(filtered.get(0));
        this.hand = cardHand;
    }

    public void damageEffect(Card card) {

        this.life -= card.getDamage();
    }

    public void manaEffect(Card card) {

        this.mana += card.getManaPoints();
    }

    public boolean isDead() {

        return (this.life <=0);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public PlayerTypeEnum getType() {
        return type;
    }

    public void setType(PlayerTypeEnum type) {
        this.type = type;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

}
