package masterdev.br.com.zup.model.card.juniorDeck;

import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;

public class CoffeeBreakCard extends Card {

    public CoffeeBreakCard() {

        super();
        this.manaPoints = 2;
        this.damage = 2;
        this.name = CardNameEnum.COFFEEBREAK;
        this.description = "Bora dar uma espriguiçada, que na volta a gente vai arrepiar";
        this.imgUrl = "https://i.imgur.com/ZV79Cik.png";
    }

}
