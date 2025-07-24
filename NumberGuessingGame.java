import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        final int MIN_NUM = 1;
        final int MAX_NUM = 100;
        final int MAX_ATTEMPTS = 7;

        int score = 0;
        int round = 1;

        System.out.println("🎲 Welcome to the Number Guessing Game!");

        while(true) {
            int secretNumber = random.nextInt(MAX_NUM - MIN_NUM + 1) + MIN_NUM;
            int attemptsLeft = MAX_ATTEMPTS;

            System.out.println("\n🔢 Round " + round + ": Guess the number between " + MIN_NUM + " and " + MAX_NUM);

            boolean guessedCorrectly = false;

            while (attemptsLeft > 0) {
                System.out.print("🤔 You have " + attemptsLeft + " attempts left. Enter your guess: ");
                int guess;

                try {
                    guess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("❌ Please enter a valid integer.");
                    continue;
                }

                if (guess < MIN_NUM || guess > MAX_NUM) {
                    System.out.println("⚠️ Stay within the range " + MIN_NUM + " to " + MAX_NUM + "!");
                    continue;
                }

                if (guess == secretNumber) {
                    System.out.println("🎉 Correct! You've guessed the number " + secretNumber + "!");
                    score++;
                    guessedCorrectly = true;
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("📉 Too low!");
                } else {
                    System.out.println("📈 Too high!");
                }

                attemptsLeft--;
            }

            if (!guessedCorrectly) {
                System.out.println("💔 Out of attempts! The number was " + secretNumber + ".");
            }

            System.out.println("✅ Your current score: " + score + " point(s)");

            System.out.print("🔁 Would you like to play another round? (yes/no): ");
            String playAgain = scanner.nextLine().trim().toLowerCase();
            if (!playAgain.equals("yes")) {
                System.out.println("\n🏁 Game Over! Final score: " + score + " point(s)");
                break;
            }
            round++;
        }

        scanner.close();
    }
}
