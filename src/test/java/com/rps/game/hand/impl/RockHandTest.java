package com.rps.game.hand.impl;

import com.rps.game.constants.Result;
import com.rps.game.visitor.impl.PaperHandVisitor;
import com.rps.game.visitor.impl.RockHandVisitor;
import com.rps.game.visitor.impl.ScissorHandVisitor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RockHandTest {

    @InjectMocks
    RockHand rockHand;

    @BeforeEach
    void setUp() {
        rockHand.setHandVisitor(new RockHandVisitor());
    }

    @Test
    void playAgainstRockHandTest() {
        Assertions.assertEquals(Result.DRAW, rockHand.play(new RockHand(new RockHandVisitor())));
    }

    @Test
    void playAgainstPaperHandTest() {
        Assertions.assertEquals(Result.LOSS, rockHand.play(new PaperHand(new PaperHandVisitor())));
    }

    @Test
    void playAgainstScissorHandTest() {
        Assertions.assertEquals(Result.WIN, rockHand.play(new ScissorHand(new ScissorHandVisitor())));
    }
}