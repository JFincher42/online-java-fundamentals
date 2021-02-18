package labs_examples.exception_handling.labs;

import com.sun.org.apache.bcel.internal.generic.ArithmeticInstruction;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Exception Handling Exercise 6:
 *
 *      Demonstrate throwing an exception in one method and catching it in another method.
 *
 */

public class Exercise_06 {

    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        int num, den, res;

        try {
            System.out.print("Enter a number: ");
            num = kbd.nextInt();
            System.out.print("Enter another number: ");
            den = kbd.nextInt();

            try {
                printRes(num, den);
            } catch (ArithmeticException e) {
                System.out.println("The second number must not be zero.");
            }
        } catch (InputMismatchException e){
            System.out.println("You must enter a number.");
        }
    }

    public static void printRes(int num, int den) throws ArithmeticException{
        if (den == 0) throw new ArithmeticException();
        System.out.println(num / den);
    }

}