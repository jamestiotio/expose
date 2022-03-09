// Exercise 1
package exercises;

import java.util.Scanner;

public class Name {
    public static void main(String[] args) {
        System.out.print("Enter your name: ");

        // TODO: Initialize a Scanner object with the name "scanner"
        Scanner scanner = new Scanner(System.in);

        // TODO: Read input name
        String name = scanner.nextLine();

        // TODO: Print "Hello, name!"
        System.out.println("Hello, " + name + "!");

        // Close scanner (good practice!)
        scanner.close();
    }
}
