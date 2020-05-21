package masterdev.br.com.zup.model.card;

import java.awt.Image;
import java.util.List;

public class CardImages {
    private List<Image> images;
    public CardImages(List<Image> images) {
        this.images = images;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image>  images) {
        this.images = images;
    }
}
