package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

public class Card {
    static char[] suits = new char[]{'♠', '♦', '♥', '♣'};
    static String[] values = new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    int cardValue, suitValue;

    public Card(int suitValue, int cardValue) {
        this.suitValue = suitValue;
        this.cardValue = cardValue;
    }

    @Override
    public String toString() {
        return values[cardValue] + suits[suitValue];
    }
}
