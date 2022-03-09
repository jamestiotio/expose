// Exercise 2
package exercises;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) throws Exception {
        System.out.print("Enter a year: ");

        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();

        // TODO: If the year is divisible by 4, print "Leap year!", else print "Not a leap year!"
        if (year % 4 == 0) {
            System.out.println("Leap year!");
        } else {
            System.out.println("Not a leap year!");
        }

        scanner.close();
    }
}
