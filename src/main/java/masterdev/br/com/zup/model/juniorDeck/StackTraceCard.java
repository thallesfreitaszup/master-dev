package masterdev.br.com.zup.model.juniorDeck;

import masterdev.br.com.zup.model.Card;
import masterdev.br.com.zup.model.CardNameEnum;

public class StackTraceCard extends Card {
    public StackTraceCard(){
        super();
        this.mana = -5;
        this.damage = 7;
        this.name = CardNameEnum.STACKTRACE;
    }

}
