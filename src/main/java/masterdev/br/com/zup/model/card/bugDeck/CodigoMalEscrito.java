package masterdev.br.com.zup.model.card.bugDeck;

import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;

public class CodigoMalEscrito extends Card {

    private int juniorManaPoints;

    public CodigoMalEscrito() {

        super();
        this.manaPoints = -6;
        this.damage = 2;
        this.juniorManaPoints = -2;
        this.name = CardNameEnum.CODIGOMALESCRITO;
        this.description = "Ixe, esse código não tá MAASSA não!";
        this.imgUrl = "https://i.imgur.com/bCMLzxt.png";
    }

    public int getJuniorManaPoints() {

        return juniorManaPoints;
    }

    public void setJuniorManaPoints(int juniorManaPoints) {

        this.juniorManaPoints = juniorManaPoints;
    }

}
