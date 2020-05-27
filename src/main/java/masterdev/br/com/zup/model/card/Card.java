package masterdev.br.com.zup.model.card;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import masterdev.br.com.zup.model.card.bugDeck.*;
import masterdev.br.com.zup.model.card.juniorDeck.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property ="name", include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = AntivirusCard.class, name = "ANTIVIRUS"),
        @JsonSubTypes.Type(value = CoffeeBreakCard.class, name = "COFFEEBREAK"),
        @JsonSubTypes.Type(value = CoffeeCard.class, name = "COFFEECARD"),
        @JsonSubTypes.Type(value = DebugCard.class, name = "DEBUG"),
        @JsonSubTypes.Type(value = StackOverflowCard.class, name = "STACKOVERFLOW"),
        @JsonSubTypes.Type(value = StackTraceCard.class, name = "STACKTRACE"),
        @JsonSubTypes.Type(value = TechLeadPowerCard.class, name = "TECHLEADPOWER"),
        @JsonSubTypes.Type(value = ChangeExperiencePowerCard.class, name = "CHANGEEXPERIENCEPOWER"),
        @JsonSubTypes.Type(value = GolpeNaoConsigo.class, name = "GOLPENAOCONSIGO"),
        @JsonSubTypes.Type(value = CodigoMalEscrito.class, name = "CODIGOMALESCRITO"),
        @JsonSubTypes.Type(value = PerdeuDaily.class, name = "PERDEUADAILY"),
        @JsonSubTypes.Type(value = EndPointErrado.class, name = "ENDPOINTBATENDOERRADO"),
        @JsonSubTypes.Type(value = PerdendoContato.class, name = "PERDENDOCONTATO"),
        @JsonSubTypes.Type(value = AdmTempo.class, name = "MAADMDETEMPO"),
        @JsonSubTypes.Type(value = Git.class, name = "GIT"),
        @JsonSubTypes.Type(value = Pandemia.class, name = "PANDEMIA"),
        @JsonSubTypes.Type(value = SemTeste.class, name = "SEMTESTE"),

        @JsonSubTypes.Type(value = FrameworkCard.class, name = "FRAMEWORK") }
)
public abstract class Card {

    protected int manaPoints;

    protected int damage;

    protected CardNameEnum name;

    protected String description;

    protected String imgUrl;

    public int getManaPoints() {
        return manaPoints;
    }

    public void setManaPoints(int manaPoints) {
        this.manaPoints = manaPoints;
    }

    public int getDamage(){
        return this.damage;
    }

    public void setDamage(int damage){
        this.damage+=damage;
    }

    public CardNameEnum getName() {
        return name;
    }

    public void setName(CardNameEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

}
