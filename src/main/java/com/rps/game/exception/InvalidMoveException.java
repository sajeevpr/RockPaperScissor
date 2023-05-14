package com.rps.game.exception;

/**
 * Exception to capture any invalid moves from the user
 */
public class InvalidMoveException extends Exception{

    /**
     * exception message
     */
    private String exceptionMsg;

    /**
     * Constructor
     * @param exceptionMsg exception message
     */
    public InvalidMoveException(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }
}
