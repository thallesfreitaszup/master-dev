package masterdev.br.com.zup.model.card.juniorDeck;

import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;

public class TechLeadPowerCard extends Card {

    public TechLeadPowerCard() {

        super();
        this.manaPoints = -6;
        this.damage = 8;
        this.name = CardNameEnum.TECHLEADPOWER;
        this.description = "Chama os heróis! Quem manja, manja! Tech lead chegou, bugginho, deu ruim procê";
        this.imgUrl = "https://i.imgur.com/y8xXHlS.png";
    }

}
