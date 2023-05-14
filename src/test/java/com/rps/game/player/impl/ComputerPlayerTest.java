package com.rps.game.player.impl;

import com.rps.game.hand.Hand;
import com.rps.game.hand.impl.PaperHand;
import com.rps.game.hand.impl.RockHand;
import com.rps.game.hand.impl.ScissorHand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class ComputerPlayerTest {

    @InjectMocks
    ComputerPlayer computerPlayer;

    @Mock
    SecureRandom random;

    @BeforeEach
    void setUp() {
        List<Hand> handList = Arrays.asList(new RockHand(), new PaperHand(), new ScissorHand());
        computerPlayer.setHandList(handList);
    }

    @Test
    void performHandMoveTest() {
        doReturn(0).when(random).nextInt(3);
        assertEquals(true, computerPlayer.performHandMove() instanceof RockHand);
        doReturn(1).when(random).nextInt(3);
        assertEquals(true, computerPlayer.performHandMove() instanceof PaperHand);
        doReturn(2).when(random).nextInt(3);
        assertEquals(true, computerPlayer.performHandMove() instanceof ScissorHand);
    }
}