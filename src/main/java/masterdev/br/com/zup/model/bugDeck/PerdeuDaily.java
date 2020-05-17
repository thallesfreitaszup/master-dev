package masterdev.br.com.zup.model.bugDeck;

import masterdev.br.com.zup.model.Card;
import masterdev.br.com.zup.model.CardNameEnum;

public class PerdeuDaily extends Card {

    public PerdeuDaily() {
        super();
        this.mana = -3;
        this.damage = 5;
        this.name = CardNameEnum.PERDEUADAILY;
    }
}
