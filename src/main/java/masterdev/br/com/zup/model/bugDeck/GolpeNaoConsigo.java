package masterdev.br.com.zup.model.bugDeck;

import masterdev.br.com.zup.model.Card;
import masterdev.br.com.zup.model.CardNameEnum;

public class GolpeNaoConsigo extends Card {

    public GolpeNaoConsigo(){
        super();
        this.mana = -4;
        this.damage = 2;
        this.name = CardNameEnum.GOLPENAOCONSIGO;
    };
}
