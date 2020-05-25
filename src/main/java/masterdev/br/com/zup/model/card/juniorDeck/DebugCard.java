package masterdev.br.com.zup.model.card.juniorDeck;

import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;

public class DebugCard extends Card {

    public DebugCard() {

        super();
        this.manaPoints = -6;
        this.damage = 8;
        this.name = CardNameEnum.DEBUG;
        this.description = "Se debugar a gente encontra erro até de mandarim. DEBUUUGA galera!";
        this.imgUrl = "https://i.imgur.com/Kqk0XFo.png";
    }

}
