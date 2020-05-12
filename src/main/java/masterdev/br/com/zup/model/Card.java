package masterdev.br.com.zup.model;

public abstract class Card {
    protected int mana;
    protected int damage;
    protected CardNameEnum name;

    public CardNameEnum getName() {
        return name;
    }

    public void setName(CardNameEnum name) {
        this.name = name;
    }

    public int getMana(){
        return this.mana;
    }

    public void setMana(int mana){
        this.mana+=mana;
    }

    public int getDamage(){
        return this.damage;
    }

    public void setDamage(int damage){
        this.damage+=damage;
    }
}
