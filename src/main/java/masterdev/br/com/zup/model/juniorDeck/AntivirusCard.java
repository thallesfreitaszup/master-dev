package masterdev.br.com.zup.model.juniorDeck;

import masterdev.br.com.zup.model.Card;
import masterdev.br.com.zup.model.CardNameEnum;

public class AntivirusCard extends Card {
    public AntivirusCard(){
        super();
        this.mana = 2;
        this.damage = 2;
        this.name = CardNameEnum.ANTIVIRUS;
    }

}
