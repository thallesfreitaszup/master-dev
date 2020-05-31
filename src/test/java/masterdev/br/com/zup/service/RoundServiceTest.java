package masterdev.br.com.zup.service;

import masterdev.br.com.zup.dto.CardHandDto;
import masterdev.br.com.zup.dto.RoundDto;
import masterdev.br.com.zup.factory.Factory;
import masterdev.br.com.zup.model.card.Card;
import masterdev.br.com.zup.model.card.CardNameEnum;
import masterdev.br.com.zup.model.card.bugDeck.AdmTempo;
import masterdev.br.com.zup.model.card.bugDeck.CodigoMalEscrito;
import masterdev.br.com.zup.model.card.bugDeck.GolpeNaoConsigo;
import masterdev.br.com.zup.model.card.bugDeck.Pandemia;
import masterdev.br.com.zup.model.card.juniorDeck.*;
import masterdev.br.com.zup.model.game.Game;
import masterdev.br.com.zup.model.game.GameStatusEnum;
import masterdev.br.com.zup.model.players.Bug;
import masterdev.br.com.zup.model.players.Junior;
import masterdev.br.com.zup.model.user.User;
import masterdev.br.com.zup.repository.GameRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static masterdev.br.com.zup.model.game.GameStatusEnum.FINISHED;
import static masterdev.br.com.zup.model.players.PlayerTypeEnum.BUG;
import static masterdev.br.com.zup.model.players.PlayerTypeEnum.JUNIOR;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class RoundServiceTest {
    @Mock
    GameRepository gameRepository;
    @Mock
    Factory factory;
    @InjectMocks
    RoundService roundService;
    @Mock
    GameService gameService;
    @Mock
    UserService userService;
    @Test
    public void when_junior_plays_it_should_update_life_mana_and_move() throws Exception {

        RoundDto roundDto = new RoundDto();
        roundDto.setPlayerType("JUNIOR");
        roundDto.setName("TECHLEADPOWER");
        Game game = new Game("thalles");
        game.setId(1);

        Game gameUpdated = new Game("thalles");
        gameUpdated.getJunior().setMana(14);
        gameUpdated.getBug().setLife(12);
        gameUpdated.setMove(2);

        when(factory.getCard(CardNameEnum.valueOf(roundDto.getName()))).thenReturn(new TechLeadPowerCard());

        Game gameResponse = roundService.roundJuniorEffect(roundDto,game);
        final ArgumentCaptor<Game> captor = ArgumentCaptor.forClass(Game.class);
        verify(gameService).save(captor.capture());
        final Game argument = captor.getValue();
        Assertions.assertEquals(gameUpdated.getJunior().getMana(),argument.getJunior().getMana());
        Assertions.assertEquals(gameUpdated.getBug().getLife(),argument.getBug().getLife());
        Assertions.assertEquals(gameUpdated.getMove(),argument.getMove());
    }

    @Test
    public void when_bug_is_dead_should_finish_game() throws Exception {
        RoundDto roundDto = new RoundDto();
        roundDto.setPlayerType("JUNIOR");
        roundDto.setName("STACKTRACE");
        Game game = new Game("thalles");
        game.setId(1);
        game.getBug().setLife(5);
        game.getJunior().setMana(20);
        Game gameUpdated = new Game("thalles");
        gameUpdated.getJunior().setMana(15);
        gameUpdated.getBug().setLife(-2);

        when(factory.getCard(CardNameEnum.valueOf(roundDto.getName()))).thenReturn(new StackTraceCard());

        roundService.roundJuniorEffect(roundDto,game);

        final ArgumentCaptor<Game> captor = ArgumentCaptor.forClass(Game.class);
        verify(gameService).save(captor.capture());
        final Game argument = captor.getValue();
        verify(userService,times(1)).updateWinScore(game.getJunior().getNickName());

        Assertions.assertEquals(gameUpdated.getJunior().getMana(),argument.getJunior().getMana());
        Assertions.assertEquals(gameUpdated.getBug().getLife(),argument.getBug().getLife());
        Assertions.assertEquals(JUNIOR.getName(),argument.getWinner());
        Assertions.assertEquals(FINISHED,argument.getStatus());
    }
    @Test
    public void when_bug_plays_it_should_update_life_mana_and_move() throws Exception {

        RoundDto roundDto = new RoundDto();
        roundDto.setPlayerType("JUNIOR");
        roundDto.setName("GOLPENAOCONSIGO");
        Game game = new Game("thalles");
        game.setId(1);

        Game gameUpdated = new Game("thalles");
        gameUpdated.getBug().setMana(16);
        gameUpdated.getJunior().setLife(18);
        gameUpdated.getJunior().setMana(17);
        gameUpdated.setMove(2);

        when(factory.getCard(CardNameEnum.valueOf(roundDto.getName()))).thenReturn(new GolpeNaoConsigo());

        Game gameResponse = roundService.roundBugEffect(roundDto,game);
        final ArgumentCaptor<Game> captor = ArgumentCaptor.forClass(Game.class);
        verify(gameService).save(captor.capture());
        final Game argument = captor.getValue();

        Assertions.assertEquals(gameUpdated.getBug().getMana(),argument.getBug().getMana());
        Assertions.assertEquals(gameUpdated.getJunior().getLife(),argument.getJunior().getLife());
        Assertions.assertEquals(gameUpdated.getJunior().getMana(),argument.getJunior().getMana());
        Assertions.assertEquals(gameUpdated.getMove(),argument.getMove());
    }
    @Test
    public void when_junior_is_dead_should_finish_game() throws Exception {

        RoundDto roundDto = new RoundDto();
        roundDto.setPlayerType("JUNIOR");
        roundDto.setName("CODIGOMALESCRITO");
        Game game = new Game("thalles");
        game.setId(1);
        game.getBug().setMana(16);
        game.getJunior().setLife(1);
        game.getJunior().setMana(20);

        Game gameUpdated = new Game("thalles");
        gameUpdated.getBug().setMana(10);
        gameUpdated.getJunior().setLife(-1);
        gameUpdated.getJunior().setMana(18);
        gameUpdated.setMove(2);

        when(factory.getCard(CardNameEnum.valueOf(roundDto.getName()))).thenReturn(new CodigoMalEscrito());

        Game gameResponse = roundService.roundBugEffect(roundDto,game);
        final ArgumentCaptor<Game> captor = ArgumentCaptor.forClass(Game.class);
        verify(gameService).save(captor.capture());
        final Game argument = captor.getValue();

        verify(userService,times(1)).updateLossScore(game.getJunior().getNickName());
        Assertions.assertEquals(gameUpdated.getBug().getMana(),argument.getBug().getMana());
        Assertions.assertEquals(gameUpdated.getJunior().getLife(),argument.getJunior().getLife());
        Assertions.assertEquals(gameUpdated.getJunior().getMana(),argument.getJunior().getMana());
        Assertions.assertEquals(gameUpdated.getMove(),argument.getMove());
        Assertions.assertEquals(BUG.getName(),argument.getWinner());
        Assertions.assertEquals(FINISHED,argument.getStatus());

    }
    @Test
    public void should_update_mana_and_sort_cards_with_no_repeated_hand() throws Exception {

        Game game = new Game("thalles");
        game.setId(1);

        Game gameUpdated = new Game("thalles");
        gameUpdated.getBug().setMana(22);
        gameUpdated.getJunior().setMana(22);

        CardHandDto cardHandDto = new CardHandDto();
        cardHandDto.setJuniorHand(new ArrayList<>(Arrays.asList(new AntivirusCard(), new FrameworkCard(), new StackTraceCard())));
        cardHandDto.setBugHand(new ArrayList<>(Arrays.asList(new GolpeNaoConsigo(), new AdmTempo(), new CodigoMalEscrito())));

        when(gameService.findGame(game.getId())).thenReturn(game);

        roundService.finishRoundEffect(game.getId(),cardHandDto);
        final ArgumentCaptor<Game> captor = ArgumentCaptor.forClass(Game.class);
        verify(gameService).save(captor.capture());
        final Game argument = captor.getValue();

        Assertions.assertEquals(gameUpdated.getBug().getMana(),argument.getBug().getMana());
        Assertions.assertEquals(gameUpdated.getJunior().getMana(),argument.getJunior().getMana());
        Assertions.assertNotEquals(argument.getJunior().getHand().get(3),cardHandDto.getJuniorHand().get(0));
        Assertions.assertNotEquals(argument.getJunior().getHand().get(3),cardHandDto.getJuniorHand().get(1));
        Assertions.assertNotEquals(argument.getJunior().getHand().get(3),cardHandDto.getJuniorHand().get(2));
        Assertions.assertNotEquals(argument.getBug().getHand().get(3),cardHandDto.getBugHand().get(0));
        Assertions.assertNotEquals(argument.getBug().getHand().get(3),cardHandDto.getBugHand().get(1));
        Assertions.assertNotEquals(argument.getBug().getHand().get(3),cardHandDto.getBugHand().get(2));

    }

    @Test
    public void should_update_move_when_skip_round() throws Exception {

        Game game = new Game("thalles");
        game.setId(1);

        Game gameUpdated = new Game("thalles");
        gameUpdated.updateMove();

        when(gameService.findGame(game.getId())).thenReturn(game);

        roundService.skipRoundEffect(game.getId());
        final ArgumentCaptor<Game> captor = ArgumentCaptor.forClass(Game.class);
        verify(gameService).save(captor.capture());
        final Game argument = captor.getValue();

        Assertions.assertEquals(gameUpdated.getMove(),argument.getMove());

    }

    @Test
    public void when_game_is_finished_it_should_restart_and_junior_should_play() throws Exception {
        RoundDto roundDto = new RoundDto();
        roundDto.setPlayerType("JUNIOR");
        roundDto.setName("COFFEE");
        Game game = new Game("thalles");
        game.setId(1);
        game.setStatus(FINISHED);

        Game gameUpdated = new Game("thalles");
        gameUpdated.getJunior().setMana(24);
        gameUpdated.setMove(2);

        when(factory.getCard(CardNameEnum.valueOf(roundDto.getName()))).thenReturn(new CoffeeCard());
        when(gameService.findGame(game.getId())).thenReturn(game);

        roundService.roundEffect(roundDto,game.getId());
        final ArgumentCaptor<Game> captor = ArgumentCaptor.forClass(Game.class);
        verify(gameService).save(captor.capture());
        final Game argument = captor.getValue();
        Assertions.assertEquals(gameUpdated.getMove(),argument.getMove());
        Assertions.assertEquals(gameUpdated.getStatus(),argument.getStatus());
        Assertions.assertEquals(gameUpdated.getJunior().getLife(),argument.getJunior().getLife());
        Assertions.assertEquals(gameUpdated.getBug().getLife(),argument.getBug().getLife());
        Assertions.assertEquals(gameUpdated.getBug().getMana(),argument.getBug().getMana());
        Assertions.assertEquals(gameUpdated.getJunior().getMana(),argument.getJunior().getMana());

    }
    @Test
    public void when_game_is_finished_it_should_restart_and_bug_should_play() throws Exception {
        RoundDto roundDto = new RoundDto();
        roundDto.setPlayerType("BUG");
        roundDto.setName("PANDEMIA");
        Game game = new Game("thalles");
        game.setId(1);
        game.setStatus(FINISHED);

        Game gameUpdated = new Game("thalles");
        gameUpdated.getBug().setMana(12);
        gameUpdated.getJunior().setLife(14);
        gameUpdated.setMove(2);

        when(factory.getCard(CardNameEnum.valueOf(roundDto.getName()))).thenReturn(new Pandemia());
        when(gameService.findGame(game.getId())).thenReturn(game);

        roundService.roundEffect(roundDto,game.getId());
        final ArgumentCaptor<Game> captor = ArgumentCaptor.forClass(Game.class);
        verify(gameService).save(captor.capture());
        final Game argument = captor.getValue();
        Assertions.assertEquals(gameUpdated.getMove(),argument.getMove());
        Assertions.assertEquals(gameUpdated.getStatus(),argument.getStatus());
        Assertions.assertEquals(gameUpdated.getJunior().getLife(),argument.getJunior().getLife());
        Assertions.assertEquals(gameUpdated.getBug().getLife(),argument.getBug().getLife());
        Assertions.assertEquals(gameUpdated.getBug().getMana(),argument.getBug().getMana());
        Assertions.assertEquals(gameUpdated.getJunior().getMana(),argument.getJunior().getMana());

    }


}
