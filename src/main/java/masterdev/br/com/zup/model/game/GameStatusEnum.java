package masterdev.br.com.zup.model.game;

public enum GameStatusEnum {
    RUNNING("RUNNING"),FINISHED("FINISHED");

    private String status;

    GameStatusEnum(String status) {

        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
