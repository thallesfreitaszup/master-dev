package masterdev.br.com.zup.model;

public enum CardNameEnum {
    ANTIVIRUS("ANTIVIRUS"),CHANGEEXPERIENCEPOWER("CHANGE EXPERIENCE POWER"),COFFEEBREAK("COFFEE BREAK"),
    COFFEE("COFFEE"),DEBUG("DEBUG"),STACKOVERFLOW("STACK OVERFLOW"),STACKTRACE("STACKTRACE"),FRAMEWORK("FRAMEWORK"),
    TECHLEADPOWER("TECH LEAD POWER");
    private String name;

    CardNameEnum(String name) {
        this.name = name;
    }
}
