package com.rps.game.visitor;

import com.rps.game.constants.Result;
import com.rps.game.hand.impl.PaperHand;
import com.rps.game.hand.impl.RockHand;
import com.rps.game.hand.impl.ScissorHand;

/**
 * Hand Visitor
 */
public interface HandVisitor {

    /**
     * Play against Rock Hand
     * @param rockHand rock hand
     * @return Result
     */
    Result play(RockHand rockHand);

    /**
     * Play against Paper Hand
     * @param paperHand paper hand
     * @return Result
     */
    Result play(PaperHand paperHand);

    /**
     * Play against Scissor Hand
     * @param scissorHand scissor hand
     * @return Result
     */
    Result play(ScissorHand scissorHand);

}
