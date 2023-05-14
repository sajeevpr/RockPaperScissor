package com.rps.game.visitor.impl;

import com.rps.game.constants.Result;
import com.rps.game.hand.impl.PaperHand;
import com.rps.game.hand.impl.RockHand;
import com.rps.game.hand.impl.ScissorHand;
import com.rps.game.visitor.HandVisitor;

/**
 * Rock hand visitor
 */
public class RockHandVisitor implements HandVisitor {
    /**
     * To play Rock hand against Rock hand
     * @param rockHand rock hand
     * @return Result
     */
    @Override
    public Result play(RockHand rockHand) {
        return Result.DRAW;
    }

    /**
     * To play Rock hand against Paper hand
     * @param paperHand paper hand
     * @return Result
     */
    @Override
    public Result play(PaperHand paperHand) {
        return Result.LOSS;
    }

    /**
     * To play Rock hand against Scissor hand
     * @param scissorHand scissor hand
     * @return Result
     */
    @Override
    public Result play(ScissorHand scissorHand) {
        return Result.WIN;
    }
}
