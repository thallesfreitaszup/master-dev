package masterdev.br.com.zup.model.card.bugDeck;

import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;

public class PerdendoContato extends Card {

    public PerdendoContato() {

        super();
        this.manaPoints = -6;
        this.damage = 4;
        this.name = CardNameEnum.PERDENDOCONTATO;
        this.description = "Ficou com dúvida e não falou com o time? Vem aqui com o bug, vai!!!";
        this.imgUrl = "https://i.imgur.com/slkFCKv.png";
    }

}
