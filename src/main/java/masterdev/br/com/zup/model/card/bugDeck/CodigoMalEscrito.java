package masterdev.br.com.zup.model.card.bugDeck;

import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;

public class CodigoMalEscrito extends Card {


    public CodigoMalEscrito() {

        super();
        this.manaPoints = -6;
        this.damage = 2;
        this.manaJuniorPoints = -2;
        this.name = CardNameEnum.CODIGOMALESCRITO;
        this.description = "Ixe, esse código não tá MAASSA não!";
        this.imgUrl = "https://i.imgur.com/bCMLzxt.png";
    }


}
