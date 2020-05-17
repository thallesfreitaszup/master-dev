package masterdev.br.com.zup.model.juniorDeck;

import masterdev.br.com.zup.model.Card;
import masterdev.br.com.zup.model.CardNameEnum;

public class CoffeeCard extends Card {
    public CoffeeCard(){
        super();
        this.mana = +4;
        this.name = CardNameEnum.COFFEE;
    }

}
