public class FactorialTest { // Name of file must match name of class exactly
    public static void main(String[] args) { // Needed so we can run our file
        System.out.println(factorial(3)); // 1 * 2 * 3 = 6
        System.out.println(factorial(5)); // 1 * 2 * 3 * 4 * 5 = 120
        System.out.println(factorial(7)); // 1 * 2 * 3 * 4 * 5 * 6 * 7 = 5040
    }

    public static int factorial(int n) {
        // Challenge for you: account for edge cases like negative integers and 0 (do you need to add any extra code)

        int product = 1; // Define the starting value for the product

        // For loop to calculate the product (the result of multiplying numbers together), with i = 1, 2, ..., n
        for (int i = 1; i <= n; i++) {
            product = product * i; // Change (recalculate) the product here
            // product *= i; // Alternate, shorthand way to increment the product by multiplying by the current value i
        }
        return product; // Return the final, calculated product
    }
}