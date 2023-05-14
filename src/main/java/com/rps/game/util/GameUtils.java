package com.rps.game.util;

import com.rps.game.constants.Result;
import com.rps.game.exception.InvalidUserInputException;
import com.rps.game.hand.Hand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

/**
 * Util class for the Game
 */
public final class GameUtils {

    /**
     * Private constructor
     */
    private GameUtils() {
    }

    static Logger log = LoggerFactory.getLogger(GameUtils.class);

    /**
     * To reverse the result so that the other player result can be updated
     * @param result result
     * @return reversed result
     */
    public static Result reverseResult(Result result) {
        if (Result.WIN.equals(result)) {
            return Result.LOSS;
        } else if (Result.LOSS.equals(result)) {
            return Result.WIN;
        } else {
            return Result.DRAW;
        }
    }

    /**
     * To Read number of rounds
     * @param sc scanner
     * @return number of rounds
     * @throws InvalidUserInputException exception for invalid user input
     */
    public static int readRoundsInput(Scanner sc) throws InvalidUserInputException {
        final String errorMsg = "Invalid User input (Rounds). System exiting";
        int retry = 2;
        String input;
        int i = 0;
        while (true) {
            i++;
            try {
                input = sc.nextLine();
                return Integer.parseInt(input);
            } catch (Exception e) {
                if (i <= retry) {
                    log.info("Invalid input. Please enter an integer value");
                } else {
                    log.info(errorMsg);
                    throw new InvalidUserInputException(errorMsg);
                }
            }
        }
    }

    /**
     * Get display message for the list of hands
     * @param handList list of all hands in the game
     * @return formatted message containing list of hands
     */
    public static String getHandListMsg(List<Hand> handList) {
        StringBuilder msg = new StringBuilder();
        for(int i=0; i< handList.size(); i++) {
            msg.append((i+1)+"."+handList.get(i).getHandName()+" ");
        }
        return msg.toString();
    }
}
