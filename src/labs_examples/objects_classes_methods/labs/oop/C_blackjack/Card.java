package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

public class Card {
    // Some static vars used to display the card in a nicer manner
    static final char[] suits = new char[]{'♠', '♦', '♥', '♣'};
    static final String[] ranks = new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    // The value and suit of the card
    int cardRank, cardSuit;

    /**
     * Construct a new card, given the suit and value of the card
     *
     * @param cardSuit - which suit is this card? Values 0-3
     * @param cardRank - which rank is this card? Values 0-12
     */
    public Card(int cardSuit, int cardRank) {
        this.cardSuit = cardSuit;
        this.cardRank = cardRank;
    }

    /**
     * Print the card out in a more user-friendly manner
     * @return - a String with the rank and suit printed nicely
     */
    @Override
    public String toString() {
        return ranks[cardRank] + suits[cardSuit];
    }
}
