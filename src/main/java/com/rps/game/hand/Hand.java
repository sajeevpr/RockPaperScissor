package com.rps.game.hand;

import com.rps.game.constants.Result;
import com.rps.game.visitor.HandVisitor;

/**
 * Hand Interface
 */
public interface Hand {

    /**
     * To get hand name
     * @return
     */
    String getHandName();

    /**
     * To get hand visitor
     * @return
     */
    HandVisitor getHandVisitor();

    /**
     * Play against another hand
     * @param hand another hand
     * @return Result
     */
    Result play(Hand hand);
}
