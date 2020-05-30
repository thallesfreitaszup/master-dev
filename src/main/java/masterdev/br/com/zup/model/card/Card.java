package masterdev.br.com.zup.model.card;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import masterdev.br.com.zup.model.card.bugDeck.*;
import masterdev.br.com.zup.model.card.juniorDeck.*;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property ="name", include = JsonTypeInfo.As.EXISTING_PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = AntivirusCard.class, name = "ANTIVIRUS"),
        @JsonSubTypes.Type(value = CoffeeBreakCard.class, name = "COFFEEBREAK"),
        @JsonSubTypes.Type(value = CoffeeCard.class, name = "COFFEE"),
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

    protected boolean selected;

    protected int damage;
    @JsonIgnore
    protected int manaJuniorPoints;



    protected CardNameEnum name;

    protected String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return
            name.equals(card.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manaPoints, damage, name, description, imgUrl);
    }

    protected String imgUrl;

    public int getManaPoints() {
        return manaPoints;
    }

    public void setManaPoints(int manaPoints) {
        this.manaPoints = manaPoints;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }

    public int getDamage(){
        return this.damage;
    }

    public void setDamage(int damage){
        this.damage =damage;
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

    public void setManaJuniorPoints(int manaJuniorPoints) {
        this.manaJuniorPoints = manaJuniorPoints;
    }

    public int getManaJuniorPoints() {
        return manaJuniorPoints;
    }
}
