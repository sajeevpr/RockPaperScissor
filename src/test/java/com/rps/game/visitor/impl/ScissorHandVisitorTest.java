package com.rps.game.visitor.impl;

import com.rps.game.constants.Result;
import com.rps.game.hand.impl.PaperHand;
import com.rps.game.hand.impl.RockHand;
import com.rps.game.hand.impl.ScissorHand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScissorHandVisitorTest {

    ScissorHandVisitor scissorHandVisitor;

    @BeforeEach
    void setUp() {
        scissorHandVisitor = new ScissorHandVisitor();
    }

    @Test
    void playAgainstRockTest() {
        assertEquals(Result.LOSS, scissorHandVisitor.play(new RockHand()));
    }

    @Test
    void playAgainstPaperTest() {
        assertEquals(Result.WIN, scissorHandVisitor.play(new PaperHand()));
    }

    @Test
    void playAgainstScissorTest() {
        assertEquals(Result.DRAW, scissorHandVisitor.play(new ScissorHand()));
    }
}