package masterdev.br.com.zup.model.players;

public enum PlayerTypeEnum {
    JUNIOR("JUNIOR"),BUG("BUG");

    private String name;

    PlayerTypeEnum(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

}
