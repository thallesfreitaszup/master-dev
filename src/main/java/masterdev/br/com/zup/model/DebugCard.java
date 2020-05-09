package masterdev.br.com.zup.model;

public class DebugCard extends Card {
    public DebugCard(){
        super();
        this.mana = -6;
        this.damage = 8;
        this.name = CardNameEnum.DEBUG;
    }

}
