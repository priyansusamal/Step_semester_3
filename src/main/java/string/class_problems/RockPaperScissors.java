import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

    static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if (playerMove.equals("Rock") && computerMove.equals("Scissors")) {
            return "Player Wins";
        }

        if (playerMove.equals("Paper") && computerMove.equals("Rock")) {
            return "Player Wins";
        }

        if (playerMove.equals("Scissors") && computerMove.equals("Paper")) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int i = 1; i <= 5; i++) {

            System.out.print("Enter Rock, Paper or Scissors: ");
            String player = sc.nextLine();

            int number = random.nextInt(3);

            String computer;

            if (number == 0) {
                computer = "Rock";
            }
            else if (number == 1) {
                computer = "Paper";
            }
            else {
                computer = "Scissors";
            }

            String result = playRound(player, computer);

            System.out.println("Round " + i);
            System.out.println("Player: " + player);
            System.out.println("Computer: " + computer);
            System.out.println("Result: " + result);

            if (result.equals("Player Wins")) {
                wins++;
            }
            else if (result.equals("Computer Wins")) {
                losses++;
            }
            else {
                draws++;
            }
        }

        double percentage = (wins / 5.0) * 100;

        System.out.println("\nWins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Win Percentage: " + percentage + "%");
    }
}