package masterdev.br.com.zup.model.card.juniorDeck;

import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;


public class CoffeeCard extends Card {
    public CoffeeCard(){
        super();
        this.manaPoints = +4;
        this.name = CardNameEnum.COFFEE;
        this.imgUrl = "https://i.imgur.com/qCQdmvO.png";
    }

}
