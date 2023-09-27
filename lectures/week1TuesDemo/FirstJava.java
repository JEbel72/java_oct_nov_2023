public class FirstJava { // File name must match name of class EXACTLY, and is PascalCase
    public static void main(String[] args) { // Our code will run through this method
        System.out.println("This is our first Java program in the Java stack in Coding Dojo!!!");
        char thisChar = 'x'; // Variable names are camelCase
        String message = "Hello there!"; // Strings MUST use double quotes - NOT single quotes
        int x = 10;
        Integer x2 = 20; // Wrapper class used here - to allow for additional functionality and behavior
        boolean isHappy = true;

        int currentTemperature = 60;
        System.out.println("Testing if blocks");
        if (currentTemperature > 90) {
            System.out.println("Too hot!!!");
        } else if (currentTemperature >= 80) {
            System.out.println("Getting a bit warm....");
        } else if (currentTemperature >= 65 && currentTemperature < 80) { // Note the two conditions here!!!
            System.out.println("Just right!");
        } else {
            System.out.println("Getting cold...");
        }
        // Countdown from 10 to 1, then display "Liftoff!"
        System.out.println("Counting down...");
        // Loop to count down - note the starting value, the condition and how we change the value!
        for (int i = 10; i > 0; i--) { // Various operators: -=, +=, --, ++, /=, *=
            System.out.println(i);
        }
        System.out.println("Liftoff!");
        
    }

}