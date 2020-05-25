package masterdev.br.com.zup.model.card;

public abstract class Card {

    protected int manaPoints;

    protected int damage;

    protected CardNameEnum name;

    protected String description;

    protected String imgUrl;

    public int getManaPoints() {
        return manaPoints;
    }

    public void setManaPoints(int manaPoints) {
        this.manaPoints = manaPoints;
    }

    public int getDamage(){
        return this.damage;
    }

    public void setDamage(int damage){
        this.damage+=damage;
    }

    public CardNameEnum getName() {
        return name;
    }

    public void setName(CardNameEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

}
