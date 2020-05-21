package masterdev.br.com.zup.model.players;

import masterdev.br.com.zup.model.card.PlayerTypeEnum;
import masterdev.br.com.zup.model.juniorDeck.*;
import java.util.Arrays;

public class Junior extends Player {

    public Junior(){
        this.mana = 20;
        this.life = 20;
        this.cards = Arrays.asList(new CoffeeCard(),new AntivirusCard(),new FrameworkCard(),new ChangeExperiencePowerCard(),new StackOverflowCard(),
                new StackTraceCard(),new TechLeadPowerCard(), new CoffeeBreakCard());
        this.name = PlayerTypeEnum.JUNIOR;
    }
}
