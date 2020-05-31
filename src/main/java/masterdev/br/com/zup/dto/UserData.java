package masterdev.br.com.zup.dto;

public class UserData {

    private  String imageUrl;

    private long id;

    private String name;

    private int wins;

    private int losses;

    public UserData(long id, String name, int wins, int losses) {
        this.id = id;
        this.name = name;
        this.wins = wins;
        this.losses = losses;
        this.imageUrl = "https://i.imgur.com/P9DAD9G.png";
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }
}
