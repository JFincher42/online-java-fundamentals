package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

public class BlackJackController {
    public static void main(String[] args) {
        Deck deck = new Deck();

        Player human = new Player("Human");

        deck.deal(human);
        deck.deal(human);

        System.out.println("Hand: " + human.hand );
    }
}
