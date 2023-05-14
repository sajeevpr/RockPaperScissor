package com.rps.game;

import com.rps.game.exception.InvalidMoveException;
import com.rps.game.exception.InvalidUserInputException;
import com.rps.game.hand.Hand;
import com.rps.game.hand.impl.PaperHand;
import com.rps.game.hand.impl.RockHand;
import com.rps.game.hand.impl.ScissorHand;
import com.rps.game.player.impl.HumanPlayer;
import com.rps.game.player.Player;
import com.rps.game.visitor.HandVisitor;
import com.rps.game.visitor.impl.PaperHandVisitor;
import com.rps.game.visitor.impl.RockHandVisitor;
import com.rps.game.visitor.impl.ScissorHandVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Main class for Rock Paper Scissor Game!
 */
public class Application {

    static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) throws InvalidUserInputException, InvalidMoveException {
        log.info("Welcome to Rock Paper Scissor Game!");

        Scanner sc = new Scanner(System.in);
        //creating visitorHands
        HandVisitor rockVisitorHand = new RockHandVisitor();
        HandVisitor paperVisitorHand = new PaperHandVisitor();
        HandVisitor scissorVisitorHand = new ScissorHandVisitor();

        //creating hands
        Hand rockHand = new RockHand(rockVisitorHand);
        Hand paperHand = new PaperHand(paperVisitorHand);
        Hand scissorHand = new ScissorHand(scissorVisitorHand);
        List<Hand> handList = Arrays.asList(rockHand, paperHand, scissorHand);

        //creating human player
        Player humanPlayer = new HumanPlayer(handList, sc);

        Game game = new Game(humanPlayer, handList, sc);

        do {
            game.playGame();

            log.info("Do you want to play again (Y/N)");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("N")) {
                log.info("Rock Paper Scissor Game Ends");
                break;
            }
        } while (true);
    }
}
