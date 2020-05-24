package masterdev.br.com.zup.model.card.juniorDeck;

import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;


public class FrameworkCard extends Card {
    public FrameworkCard(){
        super();
        this.manaPoints = -3;
        this.damage = 3;
        this.name = CardNameEnum.FRAMEWORK;
        this.imgUrl = "https://i.imgur.com/vekhPge.png";
    }

}
