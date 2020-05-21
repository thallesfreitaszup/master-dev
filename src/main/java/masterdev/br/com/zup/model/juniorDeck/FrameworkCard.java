package masterdev.br.com.zup.model.juniorDeck;

import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;


public class FrameworkCard extends Card {
    public FrameworkCard(){
        super();
        this.mana = -3;
        this.damage = 3;
        this.name = CardNameEnum.FRAMEWORK;
    }

}
