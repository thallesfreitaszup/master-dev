package masterdev.br.com.zup.model;

public class DebugCard extends Card {
    public DebugCard(){
        super();
        this.damage = 8;
        this.mana = -6;
        this.name = CardNameEnum.DEBUG;
    }

}
