package masterdev.br.com.zup.model.card.bugDeck;

import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;

public class PerdeuDaily extends Card {

    public PerdeuDaily() {

        super();
        this.manaPoints = -3;
        this.damage = 5;
        this.name = CardNameEnum.PERDEUADAILY;
        this.description = "Foi juvena, e acabou perdendo a hora da daily, né? Sentou na graxa!";
        this.imgUrl = "https://i.imgur.com/slkFCKv.png";
    }

}
