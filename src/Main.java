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


            public static void main(String[] args) {
        System.out.printf("Welcome to snake and ladder game..!");


    }
}