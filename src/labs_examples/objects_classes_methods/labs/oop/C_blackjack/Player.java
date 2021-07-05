package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

public class Player {
    String name;
    Hand hand;
    int potValue;

    public Player(String name, int potValue) {
        this.name = name;
        this.potValue = potValue;
        this.hand = new Hand();
    }

    public boolean computerAI() {
        this.hand.scoreHand();
        return (this.hand.handScore < 16);
    }
}
