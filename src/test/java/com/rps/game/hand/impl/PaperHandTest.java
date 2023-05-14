package com.rps.game.hand.impl;

import com.rps.game.constants.Result;
import com.rps.game.visitor.impl.PaperHandVisitor;
import com.rps.game.visitor.impl.RockHandVisitor;
import com.rps.game.visitor.impl.ScissorHandVisitor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PaperHandTest {

    @InjectMocks
    PaperHand paperHand;

    @BeforeEach
    void setUp() {
        paperHand.setHandVisitor(new PaperHandVisitor());
    }

    @Test
    void playAgainstRockTest() {
        assertEquals(Result.WIN, paperHand.play(new RockHand(new RockHandVisitor())));
    }

    @Test
    void playAgainstPaperTest() {
        assertEquals(Result.DRAW, paperHand.play(new PaperHand(new PaperHandVisitor())));
    }

    @Test
    void playAgainstScissorTest() {
        assertEquals(Result.LOSS, paperHand.play(new ScissorHand(new ScissorHandVisitor())));
    }
}