package masterdev.br.com.zup.model.players;

import masterdev.br.com.zup.model.bugDeck.*;
import masterdev.br.com.zup.model.card.PlayerTypeEnum;

import java.util.Arrays;

public class Bug extends Player {


    public Bug() {
        this.mana = 20;
        this.life = 20;
        this.name = PlayerTypeEnum.BUG;
        this.cards = Arrays.asList(new GolpeNaoConsigo(),new CodigoMalEscrito(),new PerdeuDaily(),new EndPointErrado(),new PerdendoContato(),
                new AdmTempo(),new Git(), new Pandemia(), new SemTeste());
    }
}

