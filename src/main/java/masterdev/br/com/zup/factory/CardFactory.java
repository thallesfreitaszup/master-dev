package masterdev.br.com.zup.factory;

import masterdev.br.com.zup.model.*;
import org.jboss.resteasy.core.ExceptionAdapter;

import javax.ws.rs.NotFoundException;

public class CardFactory {
    public static Card getCard(CardNameEnum cardNameEnum) throws Exception {
        switch(cardNameEnum){
            case CHANGEEXPERIENCEPOWER:
                return new ChangeExperiencePowerCard();
            case ANTIVIRUS:
                return new AntivirusCard();
            case COFFEEBREAK:
                return new CoffeeBreakCard();

            case COFFEE:
                return new CoffeeCard();

            case DEBUG:
                return new DebugCard();

            case FRAMEWORK:
                return new FrameworkCard();
            case STACKOVERFLOW:
                return new StackOverflowCard();
            case STACKTRACE:
                return new StackTraceCard();
            case TECHLEADPOWER:
                return new TechLeadPowerCard();
            default:
                throw new NotFoundException("Not found");
        }
    }
}
