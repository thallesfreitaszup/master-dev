package masterdev.br.com.zup.model.card.bugDeck;

import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;


public class SemTeste extends Card {
    public SemTeste() {
        this.manaPoints = -6;
        this.damage = 5;
        this.name = CardNameEnum.SEMTESTE;
        this.imgUrl = "https://i.imgur.com/slkFCKv.png";
    }
}
