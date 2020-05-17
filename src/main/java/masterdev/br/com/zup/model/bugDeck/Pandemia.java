package masterdev.br.com.zup.model.bugDeck;

import masterdev.br.com.zup.model.Card;
import masterdev.br.com.zup.model.CardNameEnum;

public class Pandemia extends Card {

    public Pandemia() {
        super();
        this.mana = -6;
        this.damage = 5;
        this.name = CardNameEnum.PANDEMIA;
    }
}
