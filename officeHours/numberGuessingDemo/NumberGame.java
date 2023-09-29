import java.util.Scanner; // For reading in data from the console
import java.util.InputMismatchException;
import java.util.Random; // Used for generating a random number

public class NumberGame {
    public static void main(String[] args) {
        // Create a Scanner for reading in data
        Scanner myScanner = new Scanner(System.in);
        // Bring in the Random package to allow us to generate numbers (pseudo)randomly
        Random myRNG = new Random();
        int pickedNumber = myRNG.nextInt(1000) + 1; // Pick a random number
        int guessCount = 1; // First guess to start
        // System.out.println("The number selected was "+ pickedNumber);

        while (guessCount < 13) { // While we still have guesses remaining...
            // ...keep playing
            try { // We will attempt to read in an integer (int)
                System.out.println("You have " + (13 - guessCount) + " guesses remaining.");
                System.out.println("Please enter a number:");
                int theUsersGuess = myScanner.nextInt();
                // Another idea by Reba: use .nextLine(), and then attempt to convert to an int, and if it isn't possible, then handle that accordingly
                System.out.println("You entered " + theUsersGuess); // If we get an int, display its value
                // On your own, add logic to check to see whether the value is < 1 or > 1000
                if (theUsersGuess < pickedNumber) {
                    System.out.println("The actual value is higher");
                } else if (theUsersGuess > pickedNumber) {
                    System.out.println("The actual value is lower");
                } else {
                    System.out.println("You win!!!");
                    break; // No need to guess any more - we won, so get out of the loop
                }
                guessCount++; // Increment guess count
                if (guessCount == 13) { // If we're out of guesses - you lost
                    System.out.println("You lost - the actual value is "+ pickedNumber);
                }
            } catch (InputMismatchException e) { // Did not get an int as input, so we got something we can't use
                System.out.println("Invalid input - you automatically lose!");
                break; // Exit the loop immediately - the game is over
            }
        }
    }

}