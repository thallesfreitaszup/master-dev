package masterdev.br.com.zup.model.bugDeck;

import masterdev.br.com.zup.model.Card;
import masterdev.br.com.zup.model.CardNameEnum;

public class EndPointErrado extends Card {

    public EndPointErrado() {
        super();
        this.mana = -4;
        this.damage = 4;
        this.name = CardNameEnum.ENDPOINTBATENDOERRADO;
    }
}
