// Imports go at the top of your file
import java.util.Arrays;

public class WednesdayDemo {
    public static void main(String[] args) {
        String thisMessage = "This is Spinal Tap!";
        // String name = 'Adrian'; // ILLEGAL: characters are defined with single quotes
        String city = "San Francisco";
        String attraction = "Golden Gate Bridge";
        // One way to put strings together with variables
        String sellingPoint = "The city of " + city + " has this attraction named " + attraction;
        System.out.println(sellingPoint);
        // Another way to combine (concatenate) strings
        String message2 = "The city of ";
        message2 = message2.concat(city); // MUST save updated string into a variable, otherwise it won't be truly added!
        System.out.println(message2);
        // System.out.println(city == "San Francisco"); // Sometimes works - but NOT always, due to memory location
        System.out.println(city.equals("San Francisco")); // Always work as it should

        // Bring in our SpaceAgency class
        SpaceAgency myAgency = new SpaceAgency(); // Dependency injection - bring in the SpaceAgency class
        myAgency.countdown();
        myAgency.countdown(20);

        // Integer array and importing (preview of tomorrow)
        int[] myValues = {8, 12, 4, 5};
        System.out.println(Arrays.toString(myValues));
        

        // Type casting
        int justAnInteger = 3 /2; // Gives 1, NOT 1.5!
        double actualQuotient = (double) 3 / 2; // Gives 1.5, as we change the 3 to 3.0 with the (double)
        System.out.println(actualQuotient);
    }
}