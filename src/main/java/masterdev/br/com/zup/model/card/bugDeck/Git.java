package masterdev.br.com.zup.model.card.bugDeck;

import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;

public class Git extends Card {

    public Git() {

        super();
        this.manaPoints = -1;
        this.damage = 2;
        this.name = CardNameEnum.GIT;
        this.description = "Fez as correções mas não commitou? Que mancada! Quebrou tudo o projeto";
        this.imgUrl = "https://i.imgur.com/bCMLzxt.png";
    }

}
