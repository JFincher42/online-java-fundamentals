package labs_examples.exception_handling.labs;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Exception Handling Exercise 1:
 *
 *      1) Demonstrate a try/catch.
 *
 */
public class Exercise_01 {

    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        int num, den, res;

        System.out.print("Enter a number: ");
        num = kbd.nextInt();
        System.out.print("Enter another number: ");
        den = kbd.nextInt();

        try {
            System.out.println(num / den);
        } catch (ArithmeticException e) {
            System.out.println("The second number must not be zero.");
        }
    }

}