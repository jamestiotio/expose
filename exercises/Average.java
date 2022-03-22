// Exercise 3
package exercises;

import java.util.ArrayList;

public class Average {
    public static void main(String[] args) {
        // Initialize ArrayList
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        // TODO: Fill up the ArrayList with numbers 1 to 19
        for (int i = 1; i <= 19; i++) {
            numbers.add(i);
        }

        // TODO: Print the average of the numbers in "numbers"
        float sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        System.out.println("Average is: " + sum / numbers.size());
    }
}
