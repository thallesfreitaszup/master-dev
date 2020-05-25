package masterdev.br.com.zup.model.card.bugDeck;

import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;

public class Pandemia extends Card {

    public Pandemia() {

        super();
        this.manaPoints = -8;
        this.damage = 6;
        this.name = CardNameEnum.PANDEMIA;
        this.description = "Já não basta os bugs, agora ainda tem vírus por ái! E é COVID? Aí danou!";
        this.imgUrl = "https://i.imgur.com/slkFCKv.png";
    }

}
