package com.rps.game.score;

import com.rps.game.constants.Result;
import com.rps.game.player.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Score Board for the Game
 */
public class ScoreBoard {

    static Logger log = LoggerFactory.getLogger(ScoreBoard.class);

    /**
     * Human player
     */
    private Player humanPlayer;

    /**
     * Computer Player
     */
    private Player computerPlayer;

    /**
     * List of Rounds
     */
    private List<Round> roundList;

    /**
     * Constructor
     * @param humanPlayer human player
     * @param computerPlayer computer player
     */
    public ScoreBoard(Player humanPlayer, Player computerPlayer) {
        this.humanPlayer = humanPlayer;
        this.computerPlayer = computerPlayer;
        roundList = new ArrayList<>();
    }

    /**
     * Get human player
     * @return human player
     */
    public Player getHumanPlayer() {
        return humanPlayer;
    }

    /**
     * Get Computer player
     * @return computer player
     */
    public Player getComputerPlayer() {
        return computerPlayer;
    }

    /**
     * Get list of rounds
     * @return list of rounds
     */
    public List<Round> getRoundList() {
        return roundList;
    }

    /**
     * Add round to the score board
     * @param round round
     */
    public void addRound(Round round) {
        roundList.add(round);
    }

    /**
     * Print Board contents
     */
    public void printBoard() {
        log.info("*****Score Board*****");
        for (int i=0; i<roundList.size();i++) {
            Round round = roundList.get(i);
            log.info("Round :{}, {} chooses {} and {}, {} chooses {} and {}",
                    i+1,
                    getHumanPlayer().getName(),
                    round.getHumanPlayerHand().getHandName(),
                    round.getHumanPlayerResult(),
                    getComputerPlayer().getName(),
                    round.getComputerPlayerHand().getHandName(),
                    round.getComputerPlayerResult()
                    );
        }
    }

    /**
     * Find Game Winner
     * @return Winner player, Optional.empty() for DRAW
     */
    public Optional<Player> findWinner() {
        int humanPlayerWins = 0;
        int computerPlayerWins = 0;
        for (int i=0; i<roundList.size();i++) {
            Round round = roundList.get(i);
            if (round.getHumanPlayerResult().equals(Result.WIN)) {
                humanPlayerWins++;
            } else if (round.getComputerPlayerResult().equals(Result.WIN)) {
                computerPlayerWins++;
            }
        }
        log.info("*****Final Result*****");
        if (humanPlayerWins == computerPlayerWins) {
            log.info("Game is DRAW");
            return Optional.empty();
        } else if (humanPlayerWins > computerPlayerWins) {
            log.info("{} Wins with {} wins",getHumanPlayer().getName(),humanPlayerWins);
            return Optional.of(humanPlayer);
        } else {
            log.info("{} Wins with {} wins",getComputerPlayer().getName(), computerPlayerWins);
            return Optional.of(computerPlayer);
        }
    }

    /**
     * Clear the board of all rounds
     */
    public void clearBoard() {
        roundList = new ArrayList<>();
    }

}
