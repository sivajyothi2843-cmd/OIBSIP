import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalRounds = 0;
        int totalScore = 0;
        String playAgain;

        System.out.println("=================================");
        System.out.println("     NUMBER GUESSING GAME");
        System.out.println("=================================");

        do {
            totalRounds++;

            int number = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessed = false;

            System.out.println("\nRound " + totalRounds);
            System.out.println("I have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();

                attempts++;

                if (guess == number) {
                    System.out.println("Correct! You guessed the number!");
                    System.out.println("Attempts used: " + attempts);

                    int score = (maxAttempts - attempts + 1) * 10;
                    totalScore += score;

                    System.out.println("Round Score: " + score);
                    guessed = true;
                    break;

                } else if (guess < number) {
                    System.out.println("Too Low!");
                } else {
                    System.out.println("Too High!");
                }

                System.out.println("Attempts remaining: "
                        + (maxAttempts - attempts));
            }

            if (!guessed) {
                System.out.println("\nYou Lost!");
                System.out.println("The correct number was: " + number);
            }

            System.out.println("\n---------------------------------");
            System.out.println("Round " + totalRounds
                    + " completed in " + attempts + " attempts.");
            System.out.println("Total Score: " + totalScore);
            System.out.println("---------------------------------");

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = sc.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("\n=================================");
        System.out.println("        GAME OVER");
        System.out.println("Total Rounds: " + totalRounds);
        System.out.println("Final Score: " + totalScore);
        System.out.println("Thank you for playing!");
        System.out.println("=================================");

        sc.close();
    }
}
