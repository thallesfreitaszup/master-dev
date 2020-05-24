package masterdev.br.com.zup.model.card;



public abstract class Card {
    protected int manaPoints;
    protected int damage;
    protected CardNameEnum name;
    protected String imgUrl;

    public CardNameEnum getName() {
        return name;
    }

    public void setName(CardNameEnum name) {
        this.name = name;
    }

    public int getManaPoints() {
        return manaPoints;
    }

    public void setManaPoints(int manaPoints) {
        this.manaPoints = manaPoints;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getDamage(){
        return this.damage;
    }

    public void setDamage(int damage){
        this.damage+=damage;
    }
}
