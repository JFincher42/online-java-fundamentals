package labs_examples.arrays.labs;

import java.util.Scanner;

/**
 * Arrays calculator
 *
 *      Take in 10 numbers from the user. Place the numbers in an array. Using the loop of your choice,
 *      calculate the sum of all of the numbers in the array as well as the average.
 *
 *      Print the results to the console.
 *
 */

public class Exercise_01 {

    public static void main(String[] args){

        int[] numbers = new int[10];
        int sum = 0;
        Scanner keyboard = new Scanner(System.in);

        for (int i=0; i< numbers.length; i++){
            System.out.print("Enter a number: ");
            numbers[i] = keyboard.nextInt();
            sum += numbers[i];
        }

        System.out.print("Sum = " + sum);
    }

}