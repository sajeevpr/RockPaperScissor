package com.rps.game.exception;

/**
 * Exception to capture any invalid user input
 */
public class InvalidUserInputException extends Exception{

    /**
     * Exception message
     */
    private String exceptionMsg;

    /**
     * Constructor
     * @param exceptionMsg exception message
     */
    public InvalidUserInputException(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }
}
