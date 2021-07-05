package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.ArrayList;

/**
 * Represents a player's hand
 */
public class Hand {

    // The cards currently in the hand
    private ArrayList<Card> cards;
    // The current score of the hand
    private int handScore;

    /**
     * Create a new hand
     */
    public Hand(){
        this.handScore = 0;
        this.cards = new ArrayList<>();
    }

    /**
     * Get the current ArrayList of cards
     * @return An ArrayList of Card objects, possible empty
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * Gets the current score of the hand
     * @return An integer representing the score of the hand
     */
    public int getHandScore() {
        return handScore;
    }

    /**
     * Reset the player's hand to blank for a new game
     */
    public void reset(){
        this.handScore = 0;
        this.cards.clear();
    }

    /**
     * Score the current hand
     * We need to take Aces into account, since they can be 1 or 11
     */
    public void scoreHand(){

        // Have we seen an ace?
        boolean ace = false;
        // Start at zero every time
        this.handScore = 0;

        // Look at each card
        for (Card card: this.cards){
            // If the card rank >= 10, it's a 10
            if (card.cardRank >= 10)
                this.handScore += 10;

            // Is the card an ace?
            else if (card.cardRank == 0){
                // indicate that we've seen an ace, and add an 11
                ace = true;
                this.handScore += 11;
            }
            // Otherwise, add the current rank, adjusting for zero-based index
            else
                this.handScore += card.cardRank + 1;
        }
        // If we've seen an ace, and we're over 21, we treat it like a 1
        if (this.handScore > 21 && ace)
            this.handScore -= 10;
    }

    /**
     * Helper function to tell us if we've busted
     * @return True if we're over 21, false otherwise
     */
    public boolean busted(){
        // Make sure the hand score is up to date first
        this.scoreHand();
        return this.handScore > 21;
    }

    /**
     * Print the hand in a nicer format
     * @return A pretty printed string
     */
    @Override
    public String toString() {
        // Always score the hand first
        this.scoreHand();
        return cards + ", Value=" + handScore;
    }
}
