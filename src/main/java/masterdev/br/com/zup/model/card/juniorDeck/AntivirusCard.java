package masterdev.br.com.zup.model.card.juniorDeck;

import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;

public class AntivirusCard extends Card {

    public AntivirusCard() {

        super();
        this.manaPoints = 2;
        this.damage = 2;
        this.name = CardNameEnum.ANTIVIRUS;
        this.description = "Aqui a gente é protegido até contra COVID. RALA, vírus";
        this.imgUrl = "https://i.imgur.com/3yV7yxV.png";
    }

//    TODO remover comentários

//    @Override
//    public Image uploadImage() {
//        try {
//            URL iconURL = new URL("../../main/resources/images/ANTIVIRUS.png");
//            ImageIcon icon = new ImageIcon(iconURL);
//            Image i = icon.getImage();
//            return i;
//        } catch(Exception e) {
//            System.out.println(e);
//            return null;
//        }
//    }

}
