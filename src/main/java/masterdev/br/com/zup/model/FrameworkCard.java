package masterdev.br.com.zup.model;

public class FrameworkCard extends Card {
    public FrameworkCard(){
        super();
        this.mana = -3;
        this.damage = 3;
        this.name = CardNameEnum.FRAMEWORK;
    }

}