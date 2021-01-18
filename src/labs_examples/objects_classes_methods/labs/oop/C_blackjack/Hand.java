package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.ArrayList;

public class Hand {
    ArrayList<Card> cards;
    int handValue;

    public Hand(){
        this.handValue = 0;
        this.cards = new ArrayList<>();
    }

    public void scoreHand(){
        this.handValue = 0;

        for (Card card: this.cards){
            if (card.cardValue >= 10)
                this.handValue += 10;
            else if (card.cardValue == 0){
                this.handValue += 11;
                if (this.handValue > 21)
                    this.handValue -= 10;
            } else
                this.handValue += card.cardValue + 1;
        }
    }

    @Override
    public String toString() {
        this.scoreHand();
        return cards + ", Value=" + handValue;
    }
}
