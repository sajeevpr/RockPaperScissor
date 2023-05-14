package com.rps.game.player.impl;

import com.rps.game.exception.InvalidMoveException;
import com.rps.game.hand.Hand;
import com.rps.game.player.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

/**
 * Human player extending Player
 */
public class HumanPlayer extends Player {

    static Logger log = LoggerFactory.getLogger(HumanPlayer.class);

    /**
     * Scanner
     */
    private Scanner scanner;

    /**
     * List of all hands in the game
     */
    private List<Hand> handList;

    /**
     * Constructor
     * @param handList list of all hands in the game
     * @param scanner scanner
     */
    public HumanPlayer(List<Hand> handList, Scanner scanner) {
        this.handList = handList;
        this.scanner = scanner;
        setName("HumanPlayer");
    }

    /**
     * To set scanner
     * @param scanner scanner
     */
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * To set hand list
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
    public Hand performHandMove() throws InvalidMoveException {
        return readUserMoveInput();
    }

    /**
     * Return the hand based on user input
     * @return hand
     * @throws InvalidMoveException exception for invalid user moves
     */
    private Hand readUserMoveInput() throws InvalidMoveException {
        final String errorMsg = "Invalid User input";
        int retry = 2;
        String input;
        int i = 0;
        while (true) {
            i++;
            try {
                input = scanner.nextLine();
                int integerInput = Integer.parseInt(input)-1;
                Hand userHandMove = handList.get(integerInput);
                if (userHandMove != null) {
                    return userHandMove;
                } else if (userHandMove == null && i <= retry) {
                    log.info(errorMsg);
                } else {
                    throw new InvalidMoveException(errorMsg);
                }
            } catch (Exception e) {
                if (i <= retry) {
                    log.info(errorMsg);
                } else {
                    log.info(errorMsg);
                    throw new InvalidMoveException(errorMsg);
                }
            }
        }
    }
}
