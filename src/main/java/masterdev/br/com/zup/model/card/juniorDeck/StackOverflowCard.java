package masterdev.br.com.zup.model.card.juniorDeck;

import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;


public class StackOverflowCard extends Card {
    public StackOverflowCard(){
        super();
        this.mana = -4;
        this.damage = 4;
        this.name = CardNameEnum.STACKOVERFLOW;
        this.imgUrl = "https://i.imgur.com/TJI3o4x.png";
    }

}
