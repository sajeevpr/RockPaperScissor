package com.rps.game.player.impl;

import com.rps.game.exception.InvalidMoveException;
import com.rps.game.hand.Hand;
import com.rps.game.player.Player;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

/**
 * Computer player extending Player
 */
public class ComputerPlayer extends Player {

    /**
     * Random instance
     */
    private Random random;

    /**
     * List of all hands in the game
     */
    private List<Hand> handList;

    /**
     * Constructor
     * @param handList list of all hands in the game
     */
    public ComputerPlayer(List<Hand> handList) {
        this(new SecureRandom(), handList);
        setName("ComputerPlayer");
    }

    /**
     * Constructor
     * @param random random
     * @param handList list of all hands in the game
     */
    public ComputerPlayer(Random random, List<Hand> handList) {
        this.random = random;
        this.handList = handList;
    }

    /**
     * To set the hand list
     * @param handList list of all hands in the game
     */
    public void setHandList(List<Hand> handList) {
        this.handList = handList;
    }

    /**
     * Perform next hand Move in a round of game
     * @return hand
     * @throws InvalidMoveException exception for invalid move
     */
    @Override
    public Hand performHandMove() {
        final int randomNumber = random.nextInt(handList.size());
        return handList.get(randomNumber);
    }
}
