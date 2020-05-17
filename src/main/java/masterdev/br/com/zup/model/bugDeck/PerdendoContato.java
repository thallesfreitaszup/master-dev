package masterdev.br.com.zup.model.bugDeck;

import masterdev.br.com.zup.model.Card;
import masterdev.br.com.zup.model.CardNameEnum;

public class PerdendoContato extends Card {

    public PerdendoContato() {
        super();
        this.mana = -6;
        this.damage = 4;
        this.name = CardNameEnum.PERDENDOCONTATO;
    }
}
