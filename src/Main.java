import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final int WINNING_POSITION = 100;
    private static final int START_POSITION = 0;
    private static Random random=new Random();

    private static int rollDice() {
        return random.nextInt(6) + 1;
    }
    private static String checkOption() {
        String[] options = {"No Play", "Ladder", "Snake"};
        return options[random.nextInt(options.length)];
    }

    private static void playSinglePlayer() {
        int position = START_POSITION;
        int diceRollCount = 0;

        while (position != WINNING_POSITION) {
            System.out.println("Press Enter to roll the dice...");
        new Scanner(System.in).nextLine();
            int diceValue = rollDice();
            diceRollCount++;
            System.out.println("Rolled: " + diceValue);

            String option = checkOption();
            System.out.println("Option result: " + option);

            int newPosition;
            switch (option) {
                case "No Play":
                    newPosition = position;
                    break;
                case "Ladder":
                    newPosition = position + diceValue;
                    break;
                case "Snake":
                    newPosition = position - diceValue;
                    break;
                default:
                    newPosition = position;
            }
            if (newPosition > WINNING_POSITION) {
                System.out.println("Exceeded 100, staying at " + position);
            } else if (newPosition < START_POSITION) {
                System.out.println("Position below 0, restarting from 0");
                position = START_POSITION;
            } else {
                position = newPosition;
                System.out.println("Moved to position: " + position);
            }
        }

        System.out.println("Player reached position 100!");
        System.out.println("Total dice rolls: " + diceRollCount);
    }
    private static void playTwoPlayers() {
        int position1 = START_POSITION;
        int position2 = START_POSITION;
        int diceRollCount1 = 0;
        int diceRollCount2 = 0;
        int currentPlayer = 1;

        while (position1 != WINNING_POSITION && position2 != WINNING_POSITION) {
            if (currentPlayer == 1) {
                System.out.println("Player 1's turn. Press Enter to roll the dice...");
                new Scanner(System.in).nextLine();

                int diceValue = rollDice();
                diceRollCount1++;
                System.out.println("Player 1 rolled: " + diceValue);

                String option = checkOption();
                System.out.println("Player 1 option result: " + option);

                int newPosition = calculateNewPosition(position1, diceValue, option);
                if (newPosition != -1) {
                    position1 = newPosition;
                    System.out.println("Player 1 moved to position: " + position1);
                } else {
                    System.out.println("Player 1 exceeded 100, staying at " + position1);
                }

                if (position1 == WINNING_POSITION) {
                    System.out.println("Player 1 won the game!");
                } else if (!option.equals("No Play")) {
                    currentPlayer = 2;
                }
            } else {
                System.out.println("Player 2's turn. Press Enter to roll the dice...");
                new Scanner(System.in).nextLine();

                int diceValue = rollDice();
                diceRollCount2++;
                System.out.println("Player 2 rolled: " + diceValue);

                String option = checkOption();
                System.out.println("Player 2 option result: " + option);

                int newPosition = calculateNewPosition(position2, diceValue, option);
                if (newPosition != -1) {
                    position2 = newPosition;
                    System.out.println("Player 2 moved to position: " + position2);
                } else {
                    System.out.println("Player 2 exceeded 100, staying at " + position2);
                }
                if (position2 == WINNING_POSITION) {
                    System.out.println("Player 2 won the game!");
                } else if (!option.equals("No Play")) {
                    currentPlayer = 1;
                }
            }
        }

        System.out.println("Total dice rolls - Player 1: " + diceRollCount1 + ", Player 2: " + diceRollCount2);
    }

    private static int calculateNewPosition(int currentPosition, int diceValue, String option) {
        int newPosition = currentPosition;

        switch (option) {
            case "No Play":
                newPosition = currentPosition;  // Stay in the same position
                break;
            case "Ladder":
                newPosition = currentPosition + diceValue;  // Move forward
                break;
            case "Snake":
                newPosition = currentPosition - diceValue;  // Move backward
                break;
        }

        // Handle position constraints
        if (newPosition < START_POSITION) {
            return START_POSITION;  // Restart from 0 if below 0
        } else if (newPosition > WINNING_POSITION) {
            return -1;  // Indicate exceeding the winning position
        } else {
            return newPosition;  // Return the new valid position
        }
    }
    public static void main(String[] args) {
        System.out.printf("Welcome to snake and ladder game..!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose mode: 1 - Single Player, 2 - Two Players");
        int mode = scanner.nextInt();

        if (mode == 1) {
            playSinglePlayer();
        } else if (mode == 2) {
            playTwoPlayers();
        } else {
            System.out.println("Invalid mode selected");
        }

        scanner.close();

    }
}