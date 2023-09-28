import java.util.Scanner; // For reading in data from the console
import java.util.InputMismatchException;

public class NumberGame {
    public static void main(String[] args) {
        // Create a Scanner for reading in data
        Scanner myScanner = new Scanner(System.in);
        try { // We will attempt to read in an integer (int)
            System.out.println("Please enter a number:");
            int thisValue = myScanner.nextInt();
            System.out.println("You entered " + thisValue); // If we get an int, display its value
        } catch (InputMismatchException e) { // Did not get an int as input, so we got something we can't use
            System.out.println("Invalid input");
        }
    }

}