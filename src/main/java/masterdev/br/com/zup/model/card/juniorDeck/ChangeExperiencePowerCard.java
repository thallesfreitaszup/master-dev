package masterdev.br.com.zup.model.card.juniorDeck;

import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;

public class ChangeExperiencePowerCard extends Card {
    public ChangeExperiencePowerCard(){
        super();
        this.manaPoints = -4;
        this.damage = 6;
        this.name = CardNameEnum.CHANGEEXPERIENCEPOWER;
        this.imgUrl =  "https://i.imgur.com/pTYltoR.png";

    }

}
