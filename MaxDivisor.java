import java.util.Scanner;

public class MaxDivisor {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user to input the range
        System.out.print("Enter the upper limit for the range (e.g., 10000): ");
        int upperLimit = input.nextInt();
        input.close();

        int maxDivisors = 0;
        int numberWithMaxDivisors = 0;

        // Loop through each number in the range to find the number with the most divisors
        for (int N = 1; N <= upperLimit; N++) {
            int divisorCount = 0;

            // Optimize divisor calculation by looping only up to the square root of N
            for (int testDivisor = 1; testDivisor <= Math.sqrt(N); testDivisor++) {
                if (N % testDivisor == 0) {
                    // Count both the divisor and its complement
                    divisorCount++;
                    if (testDivisor != N / testDivisor) {
                        divisorCount++;
                    }
                }
            }

            // Update the number with the highest divisor count
            if (divisorCount > maxDivisors) {
                maxDivisors = divisorCount;
                numberWithMaxDivisors = N;
            }
        }

        // Output the results
        System.out.println("Between 1 and " + upperLimit + ", the number with the most divisors is " + numberWithMaxDivisors);
        System.out.println("It has " + maxDivisors + " divisors.");
    }
}
