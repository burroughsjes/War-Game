/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jbjb2
 * A WarGameMain object represents a card game of War. 
 */
import java.util.*;

public class WarGameMain {

    public static void main(String[] args) {
        
        // ------------ SET UP ---------------------
        Deck dComp;
        Deck dPlayer;
        
        //creating deck of 52 cards
        Deck d1 = new Deck();
        
        //shuffling the cards
        d1.shuffleVers2();
        
        //splitting deck to give half to computer and player
        dComp = new Deck(d1.getFirstHalf());
        dPlayer = new Deck(d1.getLastHalf());
        
        
        // ------------ GAME PLAY ----------------------
        while (dComp.getDeckSize() != 0 && dPlayer.getDeckSize() != 0) {
            Card compDraw = dComp.drawFirst();
            Card playerDraw = dPlayer.drawFirst();

            System.out.println("Computer's draw: " + compDraw);
            System.out.println("Size of computer's deck: " + dComp.getDeckSize());
            System.out.println();
            System.out.println("Your draw: " + playerDraw);
            System.out.println("Size of your deck: " + dPlayer.getDeckSize());
            System.out.println();

            if (compDraw.getNumber() > playerDraw.getNumber()) {
                System.out.println("*Computer wins this round.*\n");
                dComp.addLast(compDraw);
                dComp.addLast(playerDraw);
            }

            else if (compDraw.getNumber() < playerDraw.getNumber()) {
                System.out.println("*You win this round.*\n");
                dPlayer.addLast(compDraw);
                dPlayer.addLast(playerDraw);
            }

            // war happens when the cards' number values are equal
            else {
                System.out.println("=================================");
                System.out.println("It's WAR!\n");

                LinkedList<Card> compDraws = new LinkedList<Card>();
                LinkedList<Card> playerDraws = new LinkedList<Card>();

                do {
                    // computer and user sacrifices 4 cards each time war happens
                    int amountComp = 4;
                    int amountPlayer = 4;
                    if (dComp.getDeckSize() < amountComp) {
                        amountComp = dComp.getDeckSize();
                    }
                    if (dPlayer.getDeckSize() < amountPlayer) {
                        amountPlayer = dPlayer.getDeckSize();
                    }
                    
                    for (int i = 0; i < amountComp; i++) {
                        compDraws.add(dComp.drawFirst());
                    } 

                    for (int i = 0; i < amountPlayer; i++) {
                        playerDraws.add(dPlayer.drawFirst());
                    } 

                    System.out.println("Computer's draw: " + compDraws.getLast());
                    System.out.println("Size of computer's deck: " + dComp.getDeckSize());
                    System.out.println();
                    System.out.println("Your draw: " + playerDraws.getLast());
                    System.out.println("Size of your deck: " + dPlayer.getDeckSize());
                    System.out.println();

                    if (compDraws.getLast().getNumber() > playerDraws.getLast().getNumber()) {
                        System.out.println("*Computer wins this round.*\n");
                        dComp.addLast(compDraw);
                        dComp.addLast(playerDraw);
                        dComp.addManyLast(compDraws);
                        dComp.addManyLast(playerDraws);
                    }

                    else if (compDraws.getLast().getNumber() < playerDraws.getLast().getNumber()) {
                        System.out.println("*You win this round.*\n");
                        dPlayer.addLast(compDraw);
                        dPlayer.addLast(playerDraw);
                        dPlayer.addManyLast(compDraws);
                        dPlayer.addManyLast(playerDraws);
                    }

                    else {
                        System.out.println("*Need to draw again.*\n");
                    }
                } while (compDraws.getLast().getNumber() == playerDraws.getLast().getNumber());

                System.out.println("=================================\n");
            }
        }
        
        System.out.println("\nFINISHED");

        if (dComp.getDeckSize() == 0) {
            System.out.println("You won!");
        }
        else {
            System.out.println("The computer won!");
        }
    }
}
