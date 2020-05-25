package masterdev.br.com.zup.model.card.bugDeck;

import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;
import org.apache.logging.log4j.message.Message;

import java.text.MessageFormat;

public class AdmTempo extends Card {

    public AdmTempo() {

        super();
        this.manaPoints = -1;
        this.damage = 3;
        this.name = CardNameEnum.MAADMDETEMPO;
        this.description = "O famoso 'deixa pra última hora', acabou ferrando o prazo de novo!";
//        this.description = MessageFormat.format("Bug utilizou a carta {0} causando {1} de dano", this.name.getName(), this.damage);
        this.imgUrl = "https://i.imgur.com/slkFCKv.png";
    }

}
