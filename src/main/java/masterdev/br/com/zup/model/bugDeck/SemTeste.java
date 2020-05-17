package masterdev.br.com.zup.model.bugDeck;

import masterdev.br.com.zup.model.Card;
import masterdev.br.com.zup.model.CardNameEnum;

public class SemTeste extends Card {
    public SemTeste() {
        this.mana = -8;
        this.damage = 6;
        this.name = CardNameEnum.SEMTESTE;
    }
}
