import java.util.Scanner;
public class HumanUserStrategy implements MoveStrategy {
    
    private Scanner reader;

    public HumanUserStrategy() {
        reader = new Scanner(System.in);
    }
    
    @Override
    public int NextMove() {
        System.out.print("How many piles do you want to remove? (1 or 2): ");
        int move = reader.nextInt(); // This references the amount of marbles that the player has removed
        return move;
    }
    
}
