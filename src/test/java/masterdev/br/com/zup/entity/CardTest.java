package masterdev.br.com.zup.entity;


import masterdev.br.com.zup.model.card.juniorDeck.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CardTest {

    @Test
    public void testCard() throws Exception {
        Assertions.assertEquals(2, new AntivirusCard().getMana());
        Assertions.assertEquals(2, new AntivirusCard().getDamage());
        Assertions.assertEquals(4, new CoffeeCard().getMana());
        Assertions.assertEquals(0, new CoffeeCard().getDamage());
        Assertions.assertEquals(-4, new ChangeExperiencePowerCard().getMana());
        Assertions.assertEquals(6, new ChangeExperiencePowerCard().getDamage());
        Assertions.assertEquals(-6, new TechLeadPowerCard().getMana());
        Assertions.assertEquals(8, new TechLeadPowerCard().getDamage());
        Assertions.assertEquals(-3, new FrameworkCard().getMana());
        Assertions.assertEquals(3, new FrameworkCard().getDamage());
        Assertions.assertEquals(-6, new DebugCard().getMana());
        Assertions.assertEquals(8, new DebugCard().getDamage());
        Assertions.assertEquals(-5, new StackTraceCard().getMana());
        Assertions.assertEquals(7, new StackTraceCard().getDamage());
        Assertions.assertEquals(2, new CoffeeBreakCard().getMana());
        Assertions.assertEquals(2, new CoffeeBreakCard().getDamage());
        Assertions.assertEquals(-4, new StackOverflowCard().getMana());
        Assertions.assertEquals(4, new StackOverflowCard().getDamage());
    }
}
