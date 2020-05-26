package masterdev.br.com.zup.entity;


import masterdev.br.com.zup.model.card.juniorDeck.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CardTest {

    @Test
    public void it_should_return_correct_mana_damage_points() throws Exception {
        Assertions.assertEquals(2, new AntivirusCard().getManaPoints());
        Assertions.assertEquals(2, new AntivirusCard().getDamage());
        Assertions.assertEquals(4, new CoffeeCard().getManaPoints());
        Assertions.assertEquals(0, new CoffeeCard().getDamage());
        Assertions.assertEquals(-4, new ChangeExperiencePowerCard().getManaPoints());
        Assertions.assertEquals(6, new ChangeExperiencePowerCard().getDamage());
        Assertions.assertEquals(-6, new TechLeadPowerCard().getManaPoints());
        Assertions.assertEquals(8, new TechLeadPowerCard().getDamage());
        Assertions.assertEquals(-3, new FrameworkCard().getManaPoints());
        Assertions.assertEquals(3, new FrameworkCard().getDamage());
        Assertions.assertEquals(-6, new DebugCard().getManaPoints());
        Assertions.assertEquals(8, new DebugCard().getDamage());
        Assertions.assertEquals(-5, new StackTraceCard().getManaPoints());
        Assertions.assertEquals(7, new StackTraceCard().getDamage());
        Assertions.assertEquals(2, new CoffeeBreakCard().getManaPoints());
        Assertions.assertEquals(2, new CoffeeBreakCard().getDamage());
        Assertions.assertEquals(-4, new StackOverflowCard().getManaPoints());
        Assertions.assertEquals(4, new StackOverflowCard().getDamage());
    }
}
