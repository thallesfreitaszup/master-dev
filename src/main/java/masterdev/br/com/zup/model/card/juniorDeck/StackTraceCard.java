package masterdev.br.com.zup.model.card.juniorDeck;

import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;

public class StackTraceCard extends Card {

    public StackTraceCard() {

        super();
        this.manaPoints = -5;
        this.damage = 7;
        this.name = CardNameEnum.STACKTRACE;
        this.description = "Ó o endereço dos bugs aparecendo nas nossas stack traces! Isso + DEBUG = treta";
        this.imgUrl = "https://i.imgur.com/NowVaoc.png";
    }

}
