package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

public class Player {
    String name;
    Hand hand;
    int potValue;

    public Player(String name) {
        this.name = name;
        this.potValue = 0;
        this.hand = new Hand();
    }

    public boolean computerAI() {
        this.hand.scoreHand();
        return (this.hand.handValue < 16);
    }
}
