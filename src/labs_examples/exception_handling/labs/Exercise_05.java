package labs_examples.exception_handling.labs;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Exception Handling Exercise 5:
 *
 *      Demonstrate how to throw an exception.
 *
 */

public class Exercise_05 {

    public static void main(String[] args) throws ArithmeticException {
        Scanner kbd = new Scanner(System.in);
        int num, den, res;

        try {
            System.out.print("Enter a number: ");
            num = kbd.nextInt();
            System.out.print("Enter another number: ");
            den = kbd.nextInt();
            try {
                System.out.println(num / den);
            } catch (ArithmeticException e) {
                System.out.println("The second number must not be zero.");
                throw new ArithmeticException();
            }
        } catch (InputMismatchException e){
            System.out.println("You must enter a number.");
        }
    }
}