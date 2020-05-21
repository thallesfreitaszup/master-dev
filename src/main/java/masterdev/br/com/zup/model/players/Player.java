package masterdev.br.com.zup.model.players;

import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.PlayerTypeEnum;

import java.util.List;

public class Player {
    protected int mana;
    protected int life;
    protected PlayerTypeEnum name;
    protected List<Card> cards;

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public PlayerTypeEnum getName() {
        return name;
    }

    public void setName(PlayerTypeEnum name) {
        this.name = name;
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
