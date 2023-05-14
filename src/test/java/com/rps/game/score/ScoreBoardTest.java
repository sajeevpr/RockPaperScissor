package com.rps.game.score;

import com.rps.game.constants.Result;
import com.rps.game.hand.Hand;
import com.rps.game.hand.impl.PaperHand;
import com.rps.game.hand.impl.RockHand;
import com.rps.game.hand.impl.ScissorHand;
import com.rps.game.player.impl.ComputerPlayer;
import com.rps.game.player.impl.HumanPlayer;
import com.rps.game.player.Player;
import com.rps.game.util.GameUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ScoreBoardTest {

    private ScoreBoard scoreBoard;

    @BeforeEach
    void setUp() {
        List<Hand> handList = Arrays.asList(new RockHand(), new PaperHand(), new ScissorHand());
        Player humanPlayer = new HumanPlayer(handList, new Scanner(System.in));
        Player computerPlayer = new ComputerPlayer(handList);
        scoreBoard = new ScoreBoard(humanPlayer, computerPlayer);
    }

    @Test
    void addRound() {
        Result playerResult = Result.WIN;
        Round roundRec = new Round(new RockHand(), playerResult, new ScissorHand(), GameUtils.reverseResult(playerResult));
        scoreBoard.addRound(roundRec);
        assertEquals(1, scoreBoard.getRoundList().size());
    }

    @Test
    void printBoard() {
        Result playerResult = Result.WIN;
        scoreBoard.addRound(new Round(new RockHand(), playerResult,new ScissorHand(), GameUtils.reverseResult(playerResult)));
        scoreBoard.addRound(new Round(new RockHand(), playerResult, new ScissorHand(), GameUtils.reverseResult(playerResult)));
        playerResult = Result.LOSS;
        scoreBoard.addRound(new Round(new ScissorHand(), playerResult, new RockHand(), GameUtils.reverseResult(playerResult)));
        scoreBoard.printBoard();
        assertEquals(3, scoreBoard.getRoundList().size());
    }

    @Test
    void findWinnerHumanPlayer() {
        Result playerResult = Result.WIN;
        scoreBoard.addRound(new Round(new RockHand(), playerResult, new ScissorHand(), GameUtils.reverseResult(playerResult)));
        scoreBoard.addRound(new Round(new RockHand(), playerResult, new ScissorHand(), GameUtils.reverseResult(playerResult)));
        playerResult = Result.LOSS;
        scoreBoard.addRound(new Round(new ScissorHand(), playerResult, new RockHand(), GameUtils.reverseResult(playerResult)));
        Assertions.assertEquals(scoreBoard.getHumanPlayer(), scoreBoard.findWinner().get());
    }

    @Test
    void findWinnerComputer() {
        Result playerResult = Result.LOSS;
        scoreBoard.addRound(new Round(new ScissorHand(), playerResult, new RockHand(), GameUtils.reverseResult(playerResult)));
        scoreBoard.addRound(new Round(new ScissorHand(), playerResult, new RockHand(), GameUtils.reverseResult(playerResult)));
        playerResult = Result.WIN;
        scoreBoard.addRound(new Round(new RockHand(), playerResult, new ScissorHand(), GameUtils.reverseResult(playerResult)));
        Assertions.assertEquals(scoreBoard.getComputerPlayer(), scoreBoard.findWinner().get());
    }

    @Test
    void findWinnerDraw() {
        Result playerResult = Result.WIN;
        scoreBoard.addRound(new Round(new RockHand(), playerResult, new ScissorHand(), GameUtils.reverseResult(playerResult)));
        playerResult = Result.LOSS;
        scoreBoard.addRound(new Round(new ScissorHand(), playerResult, new RockHand(), GameUtils.reverseResult(playerResult)));
        assertEquals(Optional.empty(), scoreBoard.findWinner());
    }

    @Test
    void clearBoard() {
        Result playerResult = Result.WIN;
        scoreBoard.addRound(new Round(new ScissorHand(), playerResult, new ScissorHand(), GameUtils.reverseResult(playerResult)));
        scoreBoard.clearBoard();
        assertEquals(0, scoreBoard.getRoundList().size());
    }

}