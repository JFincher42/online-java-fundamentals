package labs_examples.exception_handling.labs;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Exception Handling Exercise 3:
 *
 *      Demonstrate a try/catch/finally block.
 *
 */

public class Exercise_03 {

    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        int num, den, res;

        try {
            System.out.print("Enter a number: ");
            num = kbd.nextInt();
            System.out.print("Enter another number: ");
            den = kbd.nextInt();
            System.out.println(num / den);

        } catch (InputMismatchException e){
            System.out.println("You must enter a number.");
        } catch (ArithmeticException e) {
            System.out.println("The second number must not be zero.");
        } finally {
            System.out.println("Thanks for trying.");
        }
    }

}