import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final int WINNING_POSITION = 100;
    private static final int START_POSITION = 0;
    private static Random random=new Random();

    private static int rollDice() {
        return random.nextInt(6) + 1;  // Roll the die (1 to 6)
    }
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Welcome to snake and ladder game..!");


    }
}