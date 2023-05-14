package com.rps.game;

import com.rps.game.exception.InvalidMoveException;
import com.rps.game.exception.InvalidUserInputException;
import com.rps.game.hand.Hand;
import com.rps.game.hand.impl.PaperHand;
import com.rps.game.hand.impl.RockHand;
import com.rps.game.hand.impl.ScissorHand;
import com.rps.game.player.Player;
import com.rps.game.player.impl.ComputerPlayer;
import com.rps.game.player.impl.HumanPlayer;
import com.rps.game.score.ScoreBoard;
import com.rps.game.visitor.HandVisitor;
import com.rps.game.visitor.impl.PaperHandVisitor;
import com.rps.game.visitor.impl.RockHandVisitor;
import com.rps.game.visitor.impl.ScissorHandVisitor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class GameTest {

    @InjectMocks
    Game game;

    @Mock
    ComputerPlayer computerPlayer;

    List<Hand> handList;

    @BeforeEach
    void setUp() {
        //creating visitorHands
        HandVisitor rockVisitorHand = new RockHandVisitor();
        HandVisitor paperVisitorHand = new PaperHandVisitor();
        HandVisitor scissorVisitorHand = new ScissorHandVisitor();

        //creating hands
        Hand rockHand = new RockHand(rockVisitorHand);
        Hand paperHand = new PaperHand(paperVisitorHand);
        Hand scissorHand = new ScissorHand(scissorVisitorHand);
        handList = Arrays.asList(rockHand, paperHand, scissorHand);

        Scanner scanner = new Scanner(System.in);
        //creating human player
        Player humanPlayer = new HumanPlayer(handList, scanner);

        doReturn("ComputerPlayer").when(computerPlayer).getName();

        ScoreBoard scoreBoard = new ScoreBoard(humanPlayer, computerPlayer);

        //updating game object
        game.setComputerPlayer(computerPlayer);
        game.setHumanPlayer(humanPlayer);
        game.setHandList(handList);
        game.setBoard(scoreBoard);


    }

    @Test
    void playGameOneRound() throws InvalidUserInputException, InvalidMoveException {

        //computer to choose Rock
        doReturn(new RockHand(new RockHandVisitor())).when(computerPlayer).performHandMove();

        //User options below - rounds:1, move:Scissor
        System.setIn(new ByteArrayInputStream("1\n3".getBytes()));
        Scanner sc = new Scanner(System.in);
        HumanPlayer humanPlayer = (HumanPlayer)game.getHumanPlayer();
        humanPlayer.setScanner(sc);
        game.setScanner(sc);
        Optional<Player> winner = game.playGame();
        assertEquals(true, winner.get() instanceof ComputerPlayer);
    }

    @Test
    void playGameTwoRounds() throws InvalidUserInputException, InvalidMoveException {

        //computer to choose Rock
        doReturn(new RockHand(new RockHandVisitor())).when(computerPlayer).performHandMove();

        //User options below - rounds:1, move:Scissor
        System.setIn(new ByteArrayInputStream("2\n3\n1".getBytes()));
        Scanner sc = new Scanner(System.in);
        HumanPlayer humanPlayer = (HumanPlayer)game.getHumanPlayer();
        humanPlayer.setScanner(sc);
        game.setScanner(sc);
        Optional<Player> winner = game.playGame();
        assertEquals(true, winner.get() instanceof ComputerPlayer);
    }
}