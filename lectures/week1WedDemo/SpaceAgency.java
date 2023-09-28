public class SpaceAgency {

    public void countdown() {
        // Countdown from 10 to 1, then display "Liftoff!"
        System.out.println("Counting down...");
        // Loop to count down - note the starting value, the condition and how we change the value!
        for (int i = 10; i > 0; i--) { // Various operators: -=, +=, --, ++, /=, *=
            System.out.println(i);
        }
        System.out.println("Liftoff!");
    }

    // Example of overloading
    public void countdown(int startingPoint) {
        // Countdown from 10 to 1, then display "Liftoff!"
        System.out.println("Counting down...");
        // Loop to count down - note the starting value, the condition and how we change the value!
        for (int i = startingPoint; i > 0; i--) { // Various operators: -=, +=, --, ++, /=, *=
            System.out.println(i);
        }
        System.out.println("Liftoff!");
    }
}