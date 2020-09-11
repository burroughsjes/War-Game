/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jbjb2
 * The Deck class represents 52 playing cards, which makes up a typical deck.
 */
import java.util.*;

public class Deck {
    private LinkedList<Card> deckOfCards;
    private int deckSize;
    
    // constructs a deck with the usual frequency of suits and numbers
    public Deck() {
        deckOfCards = new LinkedList<Card>();
        
        String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};
        int maxNumber = 13;
        
        for (String suit : suits) {
            for (int num = 1; num <= maxNumber; num++) {
                deckOfCards.add(new Card(suit, num));
            }
        }
        
        deckSize = deckOfCards.size();
    }
    
    // constructs a deck from the given LinkedList
    public Deck(LinkedList<Card> d) {
        deckOfCards = d;
        
        deckSize = d.size();
    }
    
    // returns how many cards are in the deck
    public int getDeckSize() {
        return deckSize;
    }
    
    // shuffles deck using shuffle method in Collections
    public void shuffleVers1() {
        Collections.shuffle(deckOfCards);
    }
    
    // shuffles deck using random method
    public void shuffleVers2() {
        for (int count = 0; count < deckSize; count++) {
            deckOfCards.add((int)(Math.random() * deckSize), deckOfCards.removeFirst());
        }
    }
    
    // returns a card on top of deck
    public Card drawFirst() {
        deckSize--;
        return deckOfCards.removeFirst();
    }
    
    // work on !!
    /*
    public LinkedList<Card> drawMultiple(int count) {
        LinkedList<Card> removals = new LinkedList<Card>();
        
        deckSize -= count;
        
        while (count > 0) {
            removals.addLast(deckOfCards.removeFirst());
        }
       
        return removals;
    }*/
    
    // adds given card to bottom of deck
    public void addLast(Card c) {
        deckSize++;
        deckOfCards.addLast(c);
    }
    
    // adds LinkedList of cards to bottom of deck
    public void addManyLast(LinkedList<Card> cards) {
        deckSize += cards.size();
        
        for (Card card : cards) {
            deckOfCards.addLast(card);
        }
    }
    
    // returns top half of deck
    public LinkedList<Card> getFirstHalf() {
        int half = deckSize / 2;
        
        LinkedList<Card> halfDeck = new LinkedList<Card>();
        Iterator<Card> itr = deckOfCards.subList(0, half).iterator();
        
        while(half > 0 && itr.hasNext()) {
            halfDeck.add(itr.next());
        }
        
        return halfDeck;
    }
    
    // returns bottom half of deck
    public LinkedList<Card> getLastHalf() {
        int half = deckSize / 2;
        
        LinkedList<Card> halfDeck = new LinkedList<Card>();
        Iterator<Card> itr = deckOfCards.subList(half, deckSize).iterator();
        while(half > 0 && itr.hasNext()) {
            halfDeck.add(itr.next());
        }
        
        return halfDeck;
    }
    
    // prints out all of the cards in the deck
    public String toString() {
        String msg = "";
        
        for (int i = 0; i < deckOfCards.size(); i++) {
            msg += deckOfCards.get(i) + "\n";
        }
        
        return msg;
    }
}
