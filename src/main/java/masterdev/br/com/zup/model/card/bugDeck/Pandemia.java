package masterdev.br.com.zup.model.card.bugDeck;


import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;


public class Pandemia extends Card {

    public Pandemia() {
        super();
        this.manaPoints = -8;
        this.damage = 6;
        this.name = CardNameEnum.PANDEMIA;
        this.imgUrl = "https://i.imgur.com/slkFCKv.png";
    }
}
