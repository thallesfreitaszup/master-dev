package masterdev.br.com.zup.factory;

import io.quarkus.test.junit.QuarkusTest;
import masterdev.br.com.zup.factory.CardFactory;
import masterdev.br.com.zup.model.CardNameEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.ws.rs.NotFoundException;




public class CardFactoryTest {
    @Test
    public void testCreateCard() throws Exception {

        Assertions.assertEquals(CardNameEnum.ANTIVIRUS.name(), CardFactory.getCard(CardNameEnum.ANTIVIRUS).getName().name());
        Assertions.assertEquals(CardNameEnum.CHANGEEXPERIENCEPOWER.name(), CardFactory.getCard(CardNameEnum.CHANGEEXPERIENCEPOWER).getName().name());
        Assertions.assertEquals(CardNameEnum.TECHLEADPOWER.name() ,CardFactory.getCard(CardNameEnum.TECHLEADPOWER).getName().name());
        Assertions.assertEquals(CardNameEnum.COFFEE.name(),CardFactory.getCard(CardNameEnum.COFFEE).getName().name());
        Assertions.assertEquals(CardNameEnum.DEBUG.name(),CardFactory.getCard(CardNameEnum.DEBUG).getName().name());
        Assertions.assertEquals(CardNameEnum.FRAMEWORK.name(),CardFactory.getCard(CardNameEnum.FRAMEWORK).getName().name());
        Assertions.assertEquals(CardNameEnum.STACKOVERFLOW.name(),CardFactory.getCard(CardNameEnum.STACKOVERFLOW).getName().name());
        Assertions.assertEquals(CardNameEnum.STACKTRACE.name(),CardFactory.getCard(CardNameEnum.STACKTRACE).getName().name());
        Assertions.assertEquals(CardNameEnum.COFFEEBREAK.name(),CardFactory.getCard(CardNameEnum.COFFEEBREAK).getName().name());


    }
    @Test
    public void testthrowException()  {

        Assertions.assertThrows(NotFoundException.class, ()-> CardFactory.getCard(CardNameEnum.TEST));

    }
}