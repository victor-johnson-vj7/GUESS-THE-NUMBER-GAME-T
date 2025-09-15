import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean playAgain = true;

        System.out.println("Welcome to the Guess the Number Game!");

        while (playAgain) {
            System.out.println("\nChoose a difficulty level:");
            System.out.println("E - Easy (1 to 10)");
            System.out.println("M - Medium (1 to 50)");
            System.out.println("H - Hard (1 to 100)");
            System.out.print("Enter your choice (E/M/H): ");

            String choice = scanner.next();
            int maxNumber;

            switch (choice) {
                case "E":
                case "e":
                    maxNumber = 10;
                    break;
                case "M":
                case "m":
                    maxNumber = 50;
                    break;
                case "H":
                case "h":
                    maxNumber = 100;
                    break;
                default:
                    System.out.println("Invalid choice! Defaulting to Medium.");
                    maxNumber = 50;
            }

            Random random = new Random();
            int secretNumber = random.nextInt(maxNumber) + 1;
            int attempts = 0;
            int maxAttempts = 5;
            boolean guessedCorrectly = false;

            System.out.println("\nI've picked a number between 1 and " + maxNumber + ". You have " + maxAttempts + " attempts!");

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < secretNumber) {
                    System.out.println("Too low!");
                } else if (guess > secretNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Correct! You guessed it in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    break;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You've used all your attempts! The number was: " + secretNumber);
            }

            System.out.print("Do you want to play again? (Y/N): ");
            String again = scanner.next();
            playAgain = again.equals("Y") || again.equals("y");
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
