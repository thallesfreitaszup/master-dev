package masterdev.br.com.zup.dto;

import masterdev.br.com.zup.model.card.Card;

import java.util.List;

public class CardHandDto {

    private java.util.List<Card> bugHand;
    private List<Card> juniorHand;

    public List<Card> getBugHand() {
        return bugHand;
    }

    public void setBugHand(List<Card> bugHand) {
        this.bugHand = bugHand;
    }

    public List<Card> getJuniorHand() {
        return juniorHand;
    }

    public void setJuniorHand(List<Card> juniorHand) {
        this.juniorHand = juniorHand;
    }
}
