package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Represents a deck of cards for a card game
 */
public class Deck {
    // The current deck of cards
    Card[] cards;
    // Which cards in the deck have been used already?
    ArrayList<Integer> usedCards;

    /**
     * Create a new deck of cards
     */
    public Deck(){
        // Set the array to the proper size
        this.cards = new Card[52];

        // Loop through each suit
        for (int suit = 0; suit<4; suit++){
            // Loop through each rank
            for (int rank = 0; rank < 13; rank++){
                // Figure out which card using some math
                this.cards[suit*13+rank] = new Card(suit, rank);
            }
        }

        // No cards have been used yet
        this.usedCards = new ArrayList<>();
    }

    /**
     * Deal a single card to a given player
     * @param player - to which player object should we give the card?
     */
    public void deal(Player player){
        // Need to generate random cards
        Random rand = new Random();
        // This will be the card we use
        int randomCard;

        // Keep generating random cards until we get one that hasn't been used
        do {
            randomCard = rand.nextInt(52);
        } while (this.usedCards.contains(randomCard));

        // Add this card to the player's hand and rescore the hand
        player.hand.cards.add(cards[randomCard]);
        player.hand.scoreHand();

        // Mark this card as used
        this.usedCards.add(randomCard);
    }

    /**
     * Reset the deck for a new game
     */
    public void reset(){
        // Simply clear the usedCards ArrayList
        usedCards.clear();
    }

    /**
     * Print the deck in a nicer way
     * @return A string with the pretty printed deck
     */
    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + Arrays.toString(cards) +
                '}';
    }
}
