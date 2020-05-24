package masterdev.br.com.zup.model.card.juniorDeck;

import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;

public class StackTraceCard extends Card {
    public StackTraceCard(){
        super();
        this.mana = -5;
        this.damage = 7;
        this.name = CardNameEnum.STACKTRACE;
    }

}
