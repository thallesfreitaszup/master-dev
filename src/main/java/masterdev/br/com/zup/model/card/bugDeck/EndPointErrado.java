package masterdev.br.com.zup.model.card.bugDeck;

import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;

public class EndPointErrado extends Card {

    public EndPointErrado() {
        super();
        this.mana = -4;
        this.damage = 4;
        this.name = CardNameEnum.ENDPOINTBATENDOERRADO;
    }
}
