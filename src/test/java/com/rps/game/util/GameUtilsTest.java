package com.rps.game.util;

import com.rps.game.constants.Result;
import com.rps.game.exception.InvalidUserInputException;
import com.rps.game.hand.impl.PaperHand;
import com.rps.game.hand.impl.RockHand;
import com.rps.game.hand.impl.ScissorHand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class GameUtilsTest {

    @Test
    void reverseResultTest() {
        Assertions.assertEquals(Result.WIN, GameUtils.reverseResult(Result.LOSS));
        Assertions.assertEquals(Result.LOSS, GameUtils.reverseResult(Result.WIN));
        Assertions.assertEquals(Result.DRAW, GameUtils.reverseResult(Result.DRAW));

    }

    @Test
    void readRoundsInputTest() throws InvalidUserInputException {
        System.setIn(new ByteArrayInputStream("3".getBytes()));
        int value = GameUtils.readRoundsInput(new Scanner(System.in));
        System.out.println(value);
        assertEquals(3, value);
    }

    @Test
    void readRoundsInputInvalidInputTest()  {
        System.setIn(new ByteArrayInputStream("A".getBytes()));
        Assertions.assertThrows(InvalidUserInputException.class, () -> GameUtils.readRoundsInput(new Scanner(System.in)));
    }

    @Test
    void getHandListMsgTest() {
        assertEquals("1.Rock 2.Paper 3.Scissor",
                GameUtils.getHandListMsg(
                        Arrays.asList(new RockHand(null), new PaperHand(null), new ScissorHand(null))).trim());
    }
}