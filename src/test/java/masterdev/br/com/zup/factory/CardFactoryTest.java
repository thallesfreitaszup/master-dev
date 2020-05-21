package masterdev.br.com.zup.factory;

import masterdev.br.com.zup.model.card.CardNameEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class CardFactoryTest {
    CardFactory cardFactory;
    @BeforeEach
    public  void setup(){
        this.cardFactory = new CardFactory();
    }
    @Test
    public void testCreateCard() throws Exception {

        Assertions.assertEquals(CardNameEnum.ANTIVIRUS.name(), cardFactory.getCard(CardNameEnum.ANTIVIRUS).getName().name());
        Assertions.assertEquals(CardNameEnum.CHANGEEXPERIENCEPOWER.name(), cardFactory.getCard(CardNameEnum.CHANGEEXPERIENCEPOWER).getName().name());
        Assertions.assertEquals(CardNameEnum.TECHLEADPOWER.name() , cardFactory.getCard(CardNameEnum.TECHLEADPOWER).getName().name());
        Assertions.assertEquals(CardNameEnum.COFFEE.name(), cardFactory.getCard(CardNameEnum.COFFEE).getName().name());
        Assertions.assertEquals(CardNameEnum.DEBUG.name(), cardFactory.getCard(CardNameEnum.DEBUG).getName().name());
        Assertions.assertEquals(CardNameEnum.FRAMEWORK.name(), cardFactory.getCard(CardNameEnum.FRAMEWORK).getName().name());
        Assertions.assertEquals(CardNameEnum.STACKOVERFLOW.name(), cardFactory.getCard(CardNameEnum.STACKOVERFLOW).getName().name());
        Assertions.assertEquals(CardNameEnum.STACKTRACE.name(), cardFactory.getCard(CardNameEnum.STACKTRACE).getName().name());
        Assertions.assertEquals(CardNameEnum.COFFEEBREAK.name(), cardFactory.getCard(CardNameEnum.COFFEEBREAK).getName().name());


    }

}
