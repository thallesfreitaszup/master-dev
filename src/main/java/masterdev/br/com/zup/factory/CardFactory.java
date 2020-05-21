package masterdev.br.com.zup.factory;

import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;
import masterdev.br.com.zup.model.juniorDeck.*;
import masterdev.br.com.zup.model.bugDeck.*;


public class CardFactory extends Factory  {

    public  Card getCard(CardNameEnum cardNameEnum) throws Exception {
        switch (cardNameEnum) {
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
            case GOLPENAOCONSIGO:
                return new GolpeNaoConsigo();
            case CODIGOMALESCRITO:
                return new CodigoMalEscrito();
            case PERDEUADAILY:
                return new PerdeuDaily();
            case ENDPOINTBATENDOERRADO:
                return new EndPointErrado();
            case PERDENDOCONTATO:
                return new PerdendoContato();
            case MAADMDETEMPO:
                return new AdmTempo();
            case GIT:
                return new Git();
            case PANDEMIA:
                return new Pandemia();
            case SEMTESTE:
                return new SemTeste();
            default:
                throw new Exception("Not found");
        }
    }
}
