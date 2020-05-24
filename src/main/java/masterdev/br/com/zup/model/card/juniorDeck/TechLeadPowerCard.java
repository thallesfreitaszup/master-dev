package masterdev.br.com.zup.model.card.juniorDeck;

import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;


public class TechLeadPowerCard extends Card {
    public TechLeadPowerCard(){
        super();
        this.mana = -6;
        this.damage = 8;
        this.name = CardNameEnum.TECHLEADPOWER;
    }

}
