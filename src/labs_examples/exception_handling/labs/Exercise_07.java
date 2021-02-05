package labs_examples.exception_handling.labs;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Exception Handling Exercise 7:
 *
 *      1) Create a custom exception.
 *      2) Demonstrate a method throwing your custom exception.
 */

class DivideByZeroException extends Exception
{
    @Override
    public String toString(){
        return "Denominator is zero, that is not allowed in this universe.";
    }
}

public class Exercise_07 {


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
            } catch (DivideByZeroException e) {
                System.out.println(e);
            }
        } catch (InputMismatchException e){
            System.out.println("You must enter a number.");
        }
    }

    public static void printRes(int num, int den) throws DivideByZeroException{
        if (den == 0) throw new DivideByZeroException();
        System.out.println(num / den);
    }
}