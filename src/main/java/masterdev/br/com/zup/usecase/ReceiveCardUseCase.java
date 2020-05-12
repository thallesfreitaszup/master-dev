package masterdev.br.com.zup.usecase;

import masterdev.br.com.zup.dto.CardDto;
import masterdev.br.com.zup.factory.CardFactory;
import masterdev.br.com.zup.model.Card;
import masterdev.br.com.zup.model.CardNameEnum;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/card")
public class ReceiveCardUseCase {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
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
