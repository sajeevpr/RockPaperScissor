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
class ScissorHandTest {

    @InjectMocks
    ScissorHand scissorHand;

    @BeforeEach
    void setUp() {
        scissorHand.setHandVisitor(new ScissorHandVisitor());
    }

    @Test
    void playAgainstRockHandTest() {
        assertEquals(Result.LOSS, scissorHand.play(new RockHand(new RockHandVisitor())));
    }

    @Test
    void playAgainstPaperHandTest() {
        assertEquals(Result.WIN, scissorHand.play(new PaperHand(new PaperHandVisitor())));
    }

    @Test
    void playAgainstScissorHandTest() {
        assertEquals(Result.DRAW, scissorHand.play(new ScissorHand(new ScissorHandVisitor())));
    }
}