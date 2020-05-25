package masterdev.br.com.zup.model.players;

import masterdev.br.com.zup.model.card.juniorDeck.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Arrays;

@Entity
@DiscriminatorValue("JUNIOR")
public class Junior extends Player {

    public Junior() {

        this.mana = 20;
        this.life = 20;
        this.type = PlayerTypeEnum.JUNIOR;
        this.cards = Arrays.asList(new CoffeeCard(),new AntivirusCard(),new FrameworkCard(),new ChangeExperiencePowerCard(),new StackOverflowCard(),
                new StackTraceCard(),new TechLeadPowerCard(), new CoffeeBreakCard());
        this.imageUrl = "https://i.imgur.com/bCMLzxt.png";
    }

    public Junior(String nickName) {

        this();
        this.nickName = nickName;
    }

}
