// Exercise 2
package exercises;

import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) throws Exception {
        System.out.print("Enter a number: ");

        Scanner scanner = new Scanner(System.in);
        int maxNumber = scanner.nextInt();

        // TODO: Loop from 1 to maxNumber.
        // If the number is divisible by 15, print "FizzBuzz".
        // Else if the number is divisible by 3, print "Fizz".
        // Else if the number is divisible by 5, print "Buzz".
        // Else, print the number itself.
        for (int i = 1; i <= maxNumber; i++) {
            if (i % 15 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }

        scanner.close();
    }
}
