/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jbjb2
 */
import java.util.*;

public class Deck {
    private LinkedList<Card> deckOfCards;
    private int deckSize;
    
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
    
    public Deck(LinkedList<Card> d) {
        deckOfCards = d;
        
        deckSize = d.size();
    }
    
    public int getDeckSize() {
        return deckSize;
    }
    
    public void shuffleVers1() {
        Collections.shuffle(deckOfCards);
    }
    
    public void shuffleVers2() {
        for (int count = 0; count < deckSize; count++) {
            deckOfCards.add((int)(Math.random() * deckSize), deckOfCards.removeFirst());
        }
    }
    
    public Card drawFirst() {
        deckSize--;
        return deckOfCards.removeFirst();
    }
    
    //work on !!
    /*
    public LinkedList<Card> drawMultiple(int count) {
        LinkedList<Card> removals = new LinkedList<Card>();
        
        deckSize -= count;
        
        while (count > 0) {
            removals.addLast(deckOfCards.removeFirst());
        }
       
        return removals;
    }*/
    
    
    public void addLast(Card c) {
        deckSize++;
        deckOfCards.addLast(c);
    }
    
    public void addManyLast(LinkedList<Card> cards) {
        deckSize += cards.size();
        
        for (Card card : cards) {
            deckOfCards.addLast(card);
        }
    }
    
    public LinkedList<Card> getFirstHalf() {
        int half = deckSize / 2;
        
        LinkedList<Card> halfDeck = new LinkedList<Card>();
        Iterator<Card> itr = deckOfCards.subList(0, half).iterator();
        
        while(half > 0 && itr.hasNext()) {
            halfDeck.add(itr.next());
        }
        
        return halfDeck;
    }
    
    public LinkedList<Card> getLastHalf() {
        int half = deckSize / 2;
        
        LinkedList<Card> halfDeck = new LinkedList<Card>();
        Iterator<Card> itr = deckOfCards.subList(half, deckSize).iterator();
        while(half > 0 && itr.hasNext()) {
            halfDeck.add(itr.next());
        }
        
        return halfDeck;
    }
    
    public String toString() {
        String msg = "";
        
        for (int i = 0; i < deckOfCards.size(); i++) {
            msg += deckOfCards.get(i) + "\n";
        }
        
        return msg;
    }
}
