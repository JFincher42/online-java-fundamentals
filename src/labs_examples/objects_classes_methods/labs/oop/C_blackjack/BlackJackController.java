package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.Locale;
import java.util.Scanner;

public class BlackJackController {

    public static void main(String[] args) {
        playBlackJack();
    }

    public static void playBlackJack() {
        Player human, computer;
        Scanner kbd = new Scanner(System.in);

        String playerName = getPlayerName(kbd);
        human = new Player(playerName, 200);
        computer = new Player("Computer", 200);

        boolean keepPlaying = true;
        Deck deck = new Deck();

        while (keepPlaying) {
            // Clear the current deck
            deck.reset();

            // Clear player hands as well
            human.hand.reset();
            computer.hand.reset();

            // Ask for a human bet
            int betAmount = getBetAmount(kbd, human.potValue);

            // Deal each player two cards
            deck.deal(human);
            deck.deal(computer);
            deck.deal(human);
            deck.deal(computer);

            // Keep giving player cards until they say stop, or they bust
            String hit;
            do {
                // Print the hand and value
                System.out.println("Your hand: " + human.hand.toString());
                System.out.print("Another card (y/n): ");
                hit = kbd.nextLine().trim().toLowerCase();
                if (hit.equals("y")) deck.deal(human);
            } while (hit.equals("y") && (!human.hand.busted()));

            // Did the player bust?
            if (human.hand.busted())
                System.out.println("You busted with " + human.hand.toString());

            // Process computer play
            while (computer.computerAI() && !computer.hand.busted()) {
                deck.deal(computer);
            }

            // Show results
            System.out.println("Computer has: " + computer.hand.toString());
            // Did the computer bust?
            if (computer.hand.busted())
                System.out.println("Computer busted with " + computer.hand.toString());

            // Check for a winner
            int winner = checkWinner(human, computer);

            // Recalculate everyone's pot
            // If winner is positive, human's pot will go up and computer will go down
            human.potValue += (betAmount * winner);
            computer.potValue -= (betAmount * winner);

            // Show new pots
            System.out.println("You now have $" + human.potValue + ".");
            System.out.println("The computer now has $" + computer.potValue + ".");

            // Did we lose all our money, or win all the computer's money?
            if (human.potValue == 0) {
                System.out.println("You lost it all! Time to hit the ATM!");
                keepPlaying = false;
            } else if (computer.potValue <= 0) {
                System.out.println("You cleaned me out! I can't play anymore!");
                keepPlaying = false;
            }
            // Ask for another game
            else {
                System.out.print("Another game (y/n): ");
                keepPlaying = kbd.nextLine().trim().equalsIgnoreCase("y");
            }
        }
        System.out.println("Bye!");
    }

    /**
     * Check for a winner
     * @param human - the human player
     * @param computer - the computer player
     * @return -1 if the computer won, 1 if the player won, 0 if it's a push
     */
    private static int checkWinner(Player human, Player computer) {
        // Did both players bust?
        if (computer.hand.busted() && human.hand.busted()) {
            System.out.println("You both busted!");
            return 0;
        }
        // Did the computer bust? Player wins
        else if (computer.hand.busted()) {
            System.out.println("Computer busted - You won!");
            return 1;
        }
        // Did the player bust? Computer wins
        else if (human.hand.busted()) {
            System.out.println("You busted - Computer won!");
            return -1;
        }
        // No one busted, who has the better hand
        else if (human.hand.handScore > computer.hand.handScore) {
            System.out.println("You win!");
            return 1;
        } else if (human.hand.handScore < computer.hand.handScore) {
            System.out.println("Computer wins!");
            return -1;
        } else {
            System.out.println("It's a push!");
            return 0;
        }
    }

    private static String getPlayerName(Scanner kbd) {
        System.out.println("Welcome to Black Jack!");
        System.out.println();
        System.out.println("You will play against the computer.");
        System.out.println("The computer hits on 15, stands on 16.");
        System.out.println();
        System.out.print("What is your name: ");
        String playerName = kbd.nextLine().trim();

        int i = playerName.indexOf('3');
        return playerName;
    }

    private static int getBetAmount(Scanner kbd, int currentPot) {
        System.out.print("You have $" + currentPot + ". How much do you want to bet?: ");
        int amount = kbd.nextInt();
        while (amount > currentPot) {
            System.out.print("You can't bet that much. Try again: ");
            amount = kbd.nextInt();
        }

        // Remove the newline from the scanner or else the next scan won't happen
        kbd.nextLine();
        return amount;
    }

}