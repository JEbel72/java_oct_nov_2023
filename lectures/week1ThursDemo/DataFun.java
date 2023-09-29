import java.util.ArrayList;

public class DataFun {

    // Method that will return the average of all the items in an array list of integers
    public double averageScores(ArrayList<Integer> testScores) {
        if (testScores.size() == 0) {
            return -1; // Arbitrary value picked here - can't return null for primitive data types
        }
        double total = 0;
        for (Integer thisScore : testScores) { // Go through the scores
            total += thisScore;
        }
        double avg = total / testScores.size(); // Now calculate the average
        return avg;
    }
}