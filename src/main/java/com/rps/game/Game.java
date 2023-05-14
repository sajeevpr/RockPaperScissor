package com.rps.game;

import com.rps.game.constants.Result;
import com.rps.game.exception.InvalidMoveException;
import com.rps.game.exception.InvalidUserInputException;
import com.rps.game.hand.Hand;
import com.rps.game.player.impl.ComputerPlayer;
import com.rps.game.player.Player;
import com.rps.game.score.Round;
import com.rps.game.score.ScoreBoard;
import com.rps.game.util.GameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Rock Paper Scissor Game
 */
public class Game {

    static Logger log = LoggerFactory.getLogger(Game.class);

    /**
     * Human player
     */
    private Player humanPlayer;

    /**
     * Computer player
     */
    private Player computerPlayer;

    /**
     * List of all hands in the Game
     */
    private List<Hand> handList;

    /**
     * Score board
     */
    private ScoreBoard board;

    /**
     * Scanner
     */
    private Scanner scanner;

    /**
     * Constructor
     * @param humanPlayer human player
     * @param handList list of all hands in the game
     * @param scanner scanner
     */
    public Game(Player humanPlayer, List<Hand> handList, Scanner scanner) {
        this.humanPlayer = humanPlayer;
        this.computerPlayer = new ComputerPlayer(handList);
        this.handList = handList;
        this.board = new ScoreBoard(this.humanPlayer, this.computerPlayer);
        this.scanner = scanner;
    }

    /**
     * To get human player
     * @return human player
     */
    public Player getHumanPlayer() {
        return humanPlayer;
    }

    /**
     * To set scanner
     * @param scanner scanner
     */
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * To set human player
     * @param humanPlayer human player
     */
    public void setHumanPlayer(Player humanPlayer) {
        this.humanPlayer = humanPlayer;
    }

    /**
     * To set Computer player
     * @param computerPlayer computer player
     */
    public void setComputerPlayer(Player computerPlayer) {
        this.computerPlayer = computerPlayer;
    }

    /**
     * To set list of hands
     * @param handList list of hands
     */
    public void setHandList(List<Hand> handList) {
        this.handList = handList;
    }

    /**
     * To set the score board
     * @param board
     */
    public void setBoard(ScoreBoard board) {
        this.board = board;
    }

    /**
     * Play game with multiple rounds
     * @return Optional<Player> with either human player, computer player or empty (for DRAW)
     * @throws InvalidUserInputException exception for invalid user input
     * @throws InvalidMoveException exception for invalid moves of a user
     */
    public Optional<Player> playGame() throws InvalidUserInputException, InvalidMoveException {

        Optional<Player> winnerPlayer = Optional.empty();
        int rounds = 0;
        final String handListMsg = GameUtils.getHandListMsg(handList);

        board.clearBoard();
        log.info("Please enter the number of rounds");
        rounds = GameUtils.readRoundsInput(scanner);

        for (int round = 1; round <= rounds; round++) {

            System.out.println("");
            log.info("Round {}/{} Started", round, rounds);

            //peform computer move
            Hand computerHandMove = computerPlayer.performHandMove();
            log.info("Round {}/{}: {} has already selected the next hand move.", round, rounds, computerPlayer.getName());

            log.info("Round {}/{}: Please type your hand move (integer) : {}", round, rounds, handListMsg);

            Hand userHandMove = humanPlayer.performHandMove();

            //compare the moves and findout the winner
            Result playerResult = userHandMove.play(computerHandMove);

            log.info("Round {}/{} : {} chooses {} and {}, {} chooses {} and {}",
                    round,
                    rounds,
                    humanPlayer.getName(),
                    userHandMove.getHandName(),
                    playerResult,
                    computerPlayer.getName(),
                    computerHandMove.getHandName(),
                    GameUtils.reverseResult(playerResult));

            //Record results
            Round roundRec = new Round(userHandMove, playerResult, computerHandMove, GameUtils.reverseResult(playerResult));
            board.addRound(roundRec);
            board.printBoard();
            if (round == rounds) {
                System.out.println("");
                log.info("*****All Rounds Finished*****");
                winnerPlayer = board.findWinner();
            }
        }
        return winnerPlayer;
    }


}