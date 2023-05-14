package com.rps.game.score;

import com.rps.game.constants.Result;
import com.rps.game.hand.Hand;

/**
 * Round class to capture the result of each round
 */
public class Round {

    /**
     * Hand chosen by the human player
     */
    private Hand humanPlayerHand;

    /**
     * Result after choosing the hand by human player
     */
    private Result humanPlayerResult;

    /**
     * Random hand chosen by the computer
     */
    private Hand computerPlayerHand;

    /**
     * Result after choosing the hand by computer
     */
    private Result computerPlayerResult;

    /**
     * Constructor
     * @param humanPlayerHand human player hand
     * @param humanPlayerResult human player result
     * @param computerPlayerHand computer player hand
     * @param computerPlayerResult computer player result
     */
    public Round(Hand humanPlayerHand, Result humanPlayerResult, Hand computerPlayerHand, Result computerPlayerResult) {
        this.humanPlayerHand = humanPlayerHand;
        this.humanPlayerResult = humanPlayerResult;
        this.computerPlayerHand = computerPlayerHand;
        this.computerPlayerResult = computerPlayerResult;
    }

    /**
     * To get human player hand
     * @return hand
     */
    public Hand getHumanPlayerHand() {
        return humanPlayerHand;
    }

    /**
     * To get human player result
     * @return Result
     */
    public Result getHumanPlayerResult() {
        return humanPlayerResult;
    }

    /**
     * To get Computer player hand
     * @return hand
     */
    public Hand getComputerPlayerHand() {
        return computerPlayerHand;
    }

    /**
     * To return computer player result
     * @return Result
     */
    public Result getComputerPlayerResult() {
        return computerPlayerResult;
    }
}
