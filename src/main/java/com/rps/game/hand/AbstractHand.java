package com.rps.game.hand;

import com.rps.game.visitor.HandVisitor;

/**
 * AbstractHand implemented from Hand interface
 */
public abstract class AbstractHand implements Hand {

    /**
     * hand visitor
     */
    private HandVisitor handVisitor;

    /**
     * hand name
     */
    private String handName;

    /**
     * Empty Constructor
     */
    public AbstractHand() {
    }

    /**
     * Constructor
     * @param handName hand name
     * @param handVisitor hand visitor
     */
    protected AbstractHand(String handName, HandVisitor handVisitor) {
        this.handName = handName;
        this.handVisitor = handVisitor;
    }

    /**
     * Get hand name
     * @return hand name
     */
    @Override
    public String getHandName() {
        return handName;
    }

    /**
     * Get hand visitor
     * @return hand visitor
     */
    @Override
    public HandVisitor getHandVisitor() {
        return handVisitor;
    }

    /**
     * Set hand visitor
     * @param handVisitor hand visitor
     */
    public void setHandVisitor(HandVisitor handVisitor) {
        this.handVisitor = handVisitor;
    }
}
