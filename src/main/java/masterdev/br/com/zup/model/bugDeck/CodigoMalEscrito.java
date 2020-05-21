package masterdev.br.com.zup.model.bugDeck;

import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;

public class CodigoMalEscrito extends Card {

    public CodigoMalEscrito() {
        super();
        this.mana = -6;
        this.damage = 2;
        this.name = CardNameEnum.CODIGOMALESCRITO;
    }
}
