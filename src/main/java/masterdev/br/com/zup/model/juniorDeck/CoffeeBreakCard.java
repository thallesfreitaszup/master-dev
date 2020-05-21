package masterdev.br.com.zup.model.juniorDeck;

import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;

public class CoffeeBreakCard extends Card {
    public CoffeeBreakCard(){
        super();
        this.mana = 2;
        this.damage = 2;
        this.name = CardNameEnum.COFFEEBREAK;
    }

}
