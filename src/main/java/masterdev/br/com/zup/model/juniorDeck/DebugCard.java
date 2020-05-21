package masterdev.br.com.zup.model.juniorDeck;

import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;


public class DebugCard extends Card {
    public DebugCard(){
        super();
        this.mana = -6;
        this.damage = 8;
        this.name = CardNameEnum.DEBUG;
    }

}
