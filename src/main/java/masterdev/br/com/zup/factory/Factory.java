package masterdev.br.com.zup.factory;

import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;
import masterdev.br.com.zup.exception.BadRequestException;
import org.springframework.stereotype.Component;

@Component
public abstract class Factory {

    public abstract Card getCard(CardNameEnum cardNameEnum) throws BadRequestException;

}
