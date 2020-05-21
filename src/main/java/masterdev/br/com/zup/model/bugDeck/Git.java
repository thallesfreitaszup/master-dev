package masterdev.br.com.zup.model.bugDeck;

import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;


public class Git extends Card {
    public Git() {
        super();
        this.mana = -1;
        this.damage = 2;
        this.name = CardNameEnum.GIT;
    }
}
