package masterdev.br.com.zup.model.bugDeck;

import masterdev.br.com.zup.model.Card;
import masterdev.br.com.zup.model.CardNameEnum;

public class AdmTempo extends Card {

    public AdmTempo() {
        super();
        this.mana = -1;
        this.damage = 3;
        this.name = CardNameEnum.MAADMDETEMPO;
    }
}
