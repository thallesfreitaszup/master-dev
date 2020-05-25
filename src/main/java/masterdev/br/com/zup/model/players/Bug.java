package masterdev.br.com.zup.model.players;

import masterdev.br.com.zup.model.card.bugDeck.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Arrays;

@Entity
@DiscriminatorValue("BUG")
public class Bug extends Player {

    public Bug() {

        this.mana = 20;
        this.life = 20;
        this.type = PlayerTypeEnum.BUG;
        this.cards = Arrays.asList(new GolpeNaoConsigo(),new CodigoMalEscrito(),new PerdeuDaily(),new EndPointErrado(),new PerdendoContato(),
                new AdmTempo(),new Git(), new Pandemia(), new SemTeste());
        this.imageUrl = "https://i.imgur.com/slkFCKv.png";
    }
}

