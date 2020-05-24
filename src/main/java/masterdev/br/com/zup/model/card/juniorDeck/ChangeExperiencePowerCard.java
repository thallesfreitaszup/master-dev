package masterdev.br.com.zup.model.card.juniorDeck;

import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;

public class ChangeExperiencePowerCard extends Card {
    public ChangeExperiencePowerCard(){
        super();
        this.mana = -4;
        this.damage = 6;
        this.name = CardNameEnum.CHANGEEXPERIENCEPOWER;
    }

}
