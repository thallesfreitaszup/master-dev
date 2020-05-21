package masterdev.br.com.zup.controller;

import masterdev.br.com.zup.dto.CardDto;
import masterdev.br.com.zup.factory.CardFactory;
import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class CardController {
    @PostMapping
    public Card execute(CardDto cardDto) {
        Card card = null;
        try{
            card = CardFactory.getCard(CardNameEnum.valueOf(cardDto.getName()));
            // TO DO
        }catch(Exception exception){
            //to DO
            return card;
        }
        return card;
    }
}
