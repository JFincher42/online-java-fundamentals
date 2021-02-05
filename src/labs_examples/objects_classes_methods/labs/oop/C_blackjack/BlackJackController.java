package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.Locale;
import java.util.Scanner;

public class BlackJackController {

    public static void main(String[] args) {
        playBlackJack();
    }

    public static void playBlackJack(){
        Player human, computer;
        Scanner kbd = new Scanner(System.in);

        System.out.println("Welcome to Black Jack!");
        System.out.println();
        System.out.println("You will play against the computer.");
        System.out.println("The computer hits on 15, stands on 16.");
        System.out.println();
        System.out.print("What is your name: ");
        String playerName = kbd.nextLine().trim();
        human = new Player(playerName);
        computer = new Player("Computer");

        boolean keepPlaying = true;
        Deck deck = new Deck();

        while (keepPlaying){
            // Clear the current deck
            deck.reset();

            // Clear player hands as well
            human.hand.reset();
            computer.hand.reset();

            // Deal each player two cards
            deck.deal(human);
            deck.deal(computer);
            deck.deal(human);
            deck.deal(computer);

            // Print the values
            String hit;
            do {
                // Ask to hit
                System.out.println("Your hand: " + human.hand.toString());
                System.out.print("Another card (y/n): ");
                hit = kbd.nextLine().trim().toLowerCase(Locale.ROOT);
                if (hit.equals("y")) deck.deal(human);
            } while (hit.equals("y") && (!human.hand.busted()));

            // Did the player bust?
            if (human.hand.busted())
                System.out.println("You busted with " + human.hand.toString());

            // Process computer play
            while (computer.computerAI() && !computer.hand.busted()){
                deck.deal(computer);
            }

            // Show results
            System.out.println("Computer has: " + computer.hand.toString());

            if (computer.hand.busted() && human.hand.busted()){
                System.out.println("You both busted!");
            } else if (computer.hand.busted() || ((human.hand.handValue > computer.hand.handValue))) {
                System.out.println("You win!");
            } else if (human.hand.busted() || (human.hand.handValue < computer.hand.handValue)) {
                System.out.println("The computer wins!");
            } else {
                System.out.println("It's a push!");
            }

            System.out.print("Another game (y/n): ");
            String another = kbd.nextLine().trim().toLowerCase();
            keepPlaying = (another.equals("y"));
        }
        System.out.println("Bye!");
    }
}
