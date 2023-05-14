package com.rps.game.player.impl;

import com.rps.game.exception.InvalidMoveException;
import com.rps.game.hand.Hand;
import com.rps.game.hand.impl.PaperHand;
import com.rps.game.hand.impl.RockHand;
import com.rps.game.hand.impl.ScissorHand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class HumanPlayerTest {

    @InjectMocks
    HumanPlayer humanPlayer;

    @BeforeEach
    void setUp() {
        List<Hand> handList = Arrays.asList(new RockHand(), new PaperHand(), new ScissorHand());
        humanPlayer.setHandList(handList);
    }

    @Test
    void performHandMoveTest() throws InvalidMoveException {
       System.setIn(new ByteArrayInputStream("1\n2\n3".getBytes()));
       humanPlayer.setScanner(new Scanner(System.in));
       assertEquals(true, humanPlayer.performHandMove() instanceof RockHand);
       assertEquals(true, humanPlayer.performHandMove() instanceof PaperHand);
       assertEquals(true, humanPlayer.performHandMove() instanceof ScissorHand);
    }

    @Test
    void performInvalidHandMoveTest()  {
       System.setIn(new ByteArrayInputStream("10\nA".getBytes()));
       humanPlayer.setScanner(new Scanner(System.in));
       Assertions.assertThrows(InvalidMoveException.class, () -> humanPlayer.performHandMove());
       Assertions.assertThrows(InvalidMoveException.class, () -> humanPlayer.performHandMove());
    }
}