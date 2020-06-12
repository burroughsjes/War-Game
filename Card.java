/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jbjb2
 */
public class Card {
    private String suit;
    private int number;
    
    public Card() {
        this.suit = "Spades";
        this.number = 1;
    }
    
    public Card(String suit, int number) {
        this.suit = suit;
        this.number = number;
    }
    
    public String getSuit() {
        return suit;
    }
    
    public int getNumber() {
        return number;
    }
    
    public void setSuit(String suit) {
        this.suit = suit;
    }
    
    public void setNumber(int num) {
        this.number = num;
    }
    
    public String toString() {
        return number + " of " + suit;
    }
}
