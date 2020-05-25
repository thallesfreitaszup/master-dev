package masterdev.br.com.zup.model.card.bugDeck;

import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;

public class GolpeNaoConsigo extends Card {

    private int juniorManaPoints;

    public GolpeNaoConsigo() {

        super();
        this.manaPoints = -4;
        this.damage = 2;
        this.juniorManaPoints = -3;
        this.name = CardNameEnum.GOLPENAOCONSIGO;
        this.description = "Desiste aí! Você não vai conseguir resolver esse bug, né?";
        this.imgUrl = "https://i.imgur.com/slkFCKv.png";
    }

    public int getJuniorManaPoints() {

        return juniorManaPoints;
    }

    public void setJuniorManaPoints(int juniorManaPoints) {

        this.juniorManaPoints = juniorManaPoints;
    }

}
