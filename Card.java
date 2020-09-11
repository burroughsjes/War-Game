/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jbjb2
 * The Card class represents a playing card.
 */
public class Card {
    private String suit;
    private int number;
    
    // creates a card object with a default suit of spades and default value of 1
    public Card() {
        this.suit = "Spades";
        this.number = 1;
    }
    
    // create a card object with given suit and given number
    public Card(String suit, int number) {
        this.suit = suit;
        this.number = number;
    }
    
    // returns a card's suit
    public String getSuit() {
        return suit;
    }
    
    // returns a card's number value
    public int getNumber() {
        return number;
    }
    
    // sets a card's suit to the given suit
    public void setSuit(String suit) {
        this.suit = suit;
    }
    
    // sets a card's number value to the given number
    public void setNumber(int num) {
        this.number = num;
    }
    
    // prints out the number and suit of a card
    public String toString() {
        return number + " of " + suit;
    }
}
