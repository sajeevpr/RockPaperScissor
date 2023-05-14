package com.rps.game.hand.impl;

import com.rps.game.util.GameUtils;
import com.rps.game.constants.Result;
import com.rps.game.hand.AbstractHand;
import com.rps.game.hand.Hand;
import com.rps.game.visitor.HandVisitor;

/**
 * Paper hand
 */
public class PaperHand extends AbstractHand {

    /**
     * Constructor
     * @param handVisitor hand visitor
     */
    public PaperHand(HandVisitor handVisitor) {
        super("Paper", handVisitor);
    }

    /**
     * Empty constructor
     */
    public PaperHand() {
    }

    /**
     * Play against another hand
     * @param hand another hand
     * @return Result
     */
    @Override
    public Result play(Hand hand) {
        return GameUtils.reverseResult(hand.getHandVisitor().play(this));
    }
}
