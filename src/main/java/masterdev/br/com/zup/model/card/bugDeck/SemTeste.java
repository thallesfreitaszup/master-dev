package masterdev.br.com.zup.model.card.bugDeck;

import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;

public class SemTeste extends Card {

    public SemTeste() {

        super();
        this.manaPoints = -6;
        this.damage = 5;
        this.name = CardNameEnum.SEMTESTE;
        this.description = "Não vai testar, é? Vou aparecer e você nem vai notar de onde eu cheguei!";
        this.imgUrl = "https://i.imgur.com/bCMLzxt.png";
    }

}
