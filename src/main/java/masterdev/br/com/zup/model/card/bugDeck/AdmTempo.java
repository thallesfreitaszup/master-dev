package masterdev.br.com.zup.model.card.bugDeck;

import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;

public class AdmTempo extends Card {

    public AdmTempo() {
        super();
        this.manaPoints = -1;
        this.damage = 3;
        this.name = CardNameEnum.MAADMDETEMPO;
        this.imgUrl = "https://i.imgur.com/slkFCKv.png";
    }
}
