package masterdev.br.com.zup.model.juniorDeck;

import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class AntivirusCard extends Card {
    public AntivirusCard() {
        super();
        this.mana = 2;
        this.damage = 2;
        this.name = CardNameEnum.ANTIVIRUS;
        this.image = this.uploadImage();
        this.url = "/images/0";
    }

//    @Override
    public Image uploadImage()  {
        try {
            URL iconURL = new URL("../../main/resources/images/ANTIVIRUS.png");
            ImageIcon icon = new ImageIcon(iconURL);
            Image i = icon.getImage();
            return i;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

}
