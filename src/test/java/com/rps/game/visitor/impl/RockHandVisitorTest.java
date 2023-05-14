package com.rps.game.visitor.impl;

import com.rps.game.constants.Result;
import com.rps.game.hand.impl.PaperHand;
import com.rps.game.hand.impl.RockHand;
import com.rps.game.hand.impl.ScissorHand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RockHandVisitorTest {
    RockHandVisitor rockHandVisitor;

    @BeforeEach
    void setUp() {
        rockHandVisitor = new RockHandVisitor();
    }
    @Test
    void playAgainstRockTest() {
        assertEquals(Result.DRAW, rockHandVisitor.play(new RockHand()));
    }

    @Test
    void playAgainstPaperTest() {
        assertEquals(Result.LOSS, rockHandVisitor.play(new PaperHand()));
    }

    @Test
    void playAgainstScissorTest() {
        assertEquals(Result.WIN, rockHandVisitor.play(new ScissorHand()));
    }
}