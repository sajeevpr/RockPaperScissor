package com.rps.game.visitor.impl;

import com.rps.game.constants.Result;
import com.rps.game.hand.impl.PaperHand;
import com.rps.game.hand.impl.RockHand;
import com.rps.game.hand.impl.ScissorHand;
import com.rps.game.visitor.HandVisitor;

/**
 * Scissor hand visitor
 */
public class ScissorHandVisitor implements HandVisitor {

    /**
     * To play Scissor hand against Rock hand
     * @param rockHand rock hand
     * @return Result
     */
    @Override
    public Result play(RockHand rockHand) {
        return Result.LOSS;
    }

    /**
     * To play Scissor hand against Paper hand
     * @param paperHand paper hand
     * @return Result
     */
    @Override
    public Result play(PaperHand paperHand) {
        return Result.WIN;
    }

    /**
     * To play Scissor hand against scissor hand
     * @param scissorHand scissor hand
     * @return Result
     */
    @Override
    public Result play(ScissorHand scissorHand) {
        return Result.DRAW;
    }
}
