package masterdev.br.com.zup.model.players;

import masterdev.br.com.zup.model.card.juniorDeck.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Arrays;
@Entity
@DiscriminatorValue("JUNIOR")
public class Junior extends Player {

    public Junior(){
        this.manaPoints = 20;
        this.life = 20;
        this.cards = Arrays.asList(new CoffeeCard(),new AntivirusCard(),new FrameworkCard(),new ChangeExperiencePowerCard(),new StackOverflowCard(),
                new StackTraceCard(),new TechLeadPowerCard(), new CoffeeBreakCard());

        this.type = PlayerTypeEnum.JUNIOR;
    }

    public Junior(String nickName){
        this();
        this.nickName = nickName;
    }

}
