package com.rps.game.player;

import com.rps.game.exception.InvalidMoveException;
import com.rps.game.hand.Hand;

/**
 * Player abstract class
 */
public abstract class Player {

    /**
     * Player name
     */
    private String name;

    /**
     * Set player name
     * @param newName
     */
    public void setName(String newName) {
        name = newName;
    }

    /**
     * Get player name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Perform next hand Move in a round of game
     * @return hand
     * @throws InvalidMoveException exception for invalid move
     */
    public abstract Hand performHandMove() throws InvalidMoveException;
}
