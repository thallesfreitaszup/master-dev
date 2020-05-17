package masterdev.br.com.zup.model.players;

import masterdev.br.com.zup.model.Card;

import java.util.List;

public class Bug {
    private int mana;
    private int life;
    private List<Card> cards;

    public Bug() {
        this.mana = 20;
        this.life = 20;
    }

    public int getMana() { return mana; }

    public void setMana(int mana) { this.mana = mana; }

    public int getLife() { return life; }

    public void setLife(int life) { this.life = life; }

    public List<Card> getCards() { return cards; }

    public void setCards(List<Card> cards) { this.cards = cards; }
}
