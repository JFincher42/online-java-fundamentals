package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Deck {
    Card[] cards;
    ArrayList<Integer> usedCards;

    public Deck(){
        this.cards = new Card[52];

        for (int suit = 0; suit<4; suit++){
            for (int value = 0; value < 13; value++){
                this.cards[suit*13+value] = new Card(suit, value);
            }
        }

        this.usedCards = new ArrayList<>();
    }

    public void deal(Player player){
        Random rand = new Random();
        int randomCard;

        do {
            randomCard = rand.nextInt(52);
        } while (this.usedCards.contains(randomCard));

        player.hand.cards.add(cards[randomCard]);
        player.hand.scoreHand();
        this.usedCards.add(randomCard);
    }

    public void reset(){
        usedCards.clear();
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + Arrays.toString(cards) +
                '}';
    }
}
