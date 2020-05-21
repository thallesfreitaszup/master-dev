package masterdev.br.com.zup.model.card;

import java.awt.*;

public abstract class Card {
    protected int mana;
    protected int damage;
    protected CardNameEnum name;
    protected Image image;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    protected String url;

//    public abstract  Image uploadImage() throws MalformedURLException;
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
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
