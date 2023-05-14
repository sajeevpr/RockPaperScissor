package com.rps.game.visitor.impl;

import com.rps.game.constants.Result;
import com.rps.game.hand.impl.PaperHand;
import com.rps.game.hand.impl.RockHand;
import com.rps.game.hand.impl.ScissorHand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaperHandVisitorTest {

    PaperHandVisitor paperHandVisitor;

    @BeforeEach
    void setUp() {
        paperHandVisitor = new PaperHandVisitor();
    }

    @Test
    void playAgainstRockTest() {
        assertEquals(Result.WIN, paperHandVisitor.play(new RockHand()));
    }

    @Test
    void playAgainstPaperTest() {
        assertEquals(Result.DRAW, paperHandVisitor.play(new PaperHand()));
    }

    @Test
    void playAgainstScissorTest() {
        assertEquals(Result.LOSS, paperHandVisitor.play(new ScissorHand()));
    }
}