package masterdev.br.com.zup.model.card.bugDeck;

import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;

public class PerdendoContato extends Card {

    public PerdendoContato() {
        super();
        this.manaPoints = -6;
        this.damage = 4;
        this.name = CardNameEnum.PERDENDOCONTATO;
        this.imgUrl = "https://i.imgur.com/slkFCKv.png";
    }
}
