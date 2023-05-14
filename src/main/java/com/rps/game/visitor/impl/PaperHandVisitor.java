package com.rps.game.visitor.impl;

import com.rps.game.constants.Result;
import com.rps.game.hand.impl.PaperHand;
import com.rps.game.hand.impl.RockHand;
import com.rps.game.hand.impl.ScissorHand;
import com.rps.game.visitor.HandVisitor;

/**
 * Paper Hand Visitor
 */
public class PaperHandVisitor implements HandVisitor {

    /**
     * Paper hand playing against Rock hand
     * @param rockHand rock hand
     * @return Result
     */
    @Override
    public Result play(RockHand rockHand) {
        return Result.WIN;
    }

    /**
     * Paper hand playing against Paper hand
     * @param paperHand paper hand
     * @return Result
     */
    @Override
    public Result play(PaperHand paperHand) {
        return Result.DRAW;
    }

    /**
     * Paper hand playing against scissor hand
     * @param scissorHand scissor hand
     * @return Result
     */
    @Override
    public Result play(ScissorHand scissorHand) {
        return Result.LOSS;
    }
}
