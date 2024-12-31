import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class NimGame {
    private Player humanPlayer;
    private Player computerPlayer;
    private boolean isHumanTurn;
    private int marbleSize;

    public NimGame(Player humanPlayer, Player computerPlayer) {
        Random random = new Random(); // Initialized the random class
        this.marbleSize = random.nextInt(5, 21); // Used the random class to generate a random number between the origin = 5 and 21 = bound which is exclusive which means it generates numbers between 5 and 20. The method 'nextint()' returns an integer;
        // Whenever an instance of nim game is made, a random number of marbles is generated
        // Found out from the java Random class written file that you can generate a random either with no specification, or a bound provided (being exclusive) or a bound and origin provided (the bound also being exclusive)
        this.humanPlayer = humanPlayer; // Here the name and strategy is created if the both as passed in when the Nim Game class is made. Player has two constructors
        this.computerPlayer = computerPlayer; // Same thing here
        this.isHumanTurn = random.nextBoolean(); // This
    }

    public void assignMove(int removeAmount) {

        marbleSize -= removeAmount; // This removes the amount of marbles taken from the pile either by the computer or human as the game goes on
        isHumanTurn = !isHumanTurn;
    }

    public boolean checkWinner() {
        return marbleSize <= 0;
    }

    public void saveGame(int marbles, boolean humanTurn, MoveStrategy humanStrategy, MoveStrategy computerStrategy) {
        try{
            FileWriter gameWriter = new FileWriter("GameHistory.txt", true);
            gameWriter.write("Marble Size: " + marbles + "\n" +
                    "Human Turn: " + humanTurn + "\n" +
                    "Human Strategy: " + humanStrategy + "\n" +
                    "Computer Strategy: " + computerStrategy + "\n\n");
            gameWriter.close();
        } catch (IOException e){
            System.out.println("An error occurred.");
        }
        System.out.println("You have saved your progress 👏🏾.");
    }

    public void loadGame(MoveStrategy computerStrategy) {
        // You can check if the strategy in the file is the same in the one in the game and if its not, return the error that strategy is not the same as that in file
        // To check strategy, you can use the first letter such as H for humanStrategy, Y for Your strategy, R for Random Strategy
        System.out.println("Code not yet implemented\n");
    }



    public void undoLastMove(ArrayList<Integer> moves) {
        // I first give a condition to ensure there is something still in the array
        if(moves.size() < 2){
            System.out.println("There are no moves to revert to!!! 👀");
        } else {
            int array_size = moves.size();
            int last_move = moves.get(array_size - 1);
            moves.remove(array_size - 1); // Here the list updates and the second to last element becomes the last in the array
            array_size -= 1; // Update the array size when an element is removed
            int second_to_last_move = moves.get(array_size - 1);
            moves.remove(array_size - 1);
            int total_marbles_restored = last_move + second_to_last_move;
            marbleSize += total_marbles_restored;
            System.out.println(total_marbles_restored + " have been restored to the pile");
            System.out.print("This is the current value of the moves list " + moves + "\n");
        }
//        System.out.println("Code not yet implemented \n");
    }

    public void resetGame() {
        System.out.println("You have reset your game!!!\n");
        System.out.println("------------------------------");
        TextBasedUI textUi = new TextBasedUI(); // I reset the game by creating a new instance of the TEXT_UI interface which in turn resets all the other classes connected to it.
    }

    public Player getHumanPlayer() {
        return humanPlayer;
    }

    public Player getComputerPlayer(){
        return computerPlayer;
    }

    public int getMarbleSize() {
        return marbleSize;
    }

    public boolean isHumanTurn() {
        return isHumanTurn;
    }

}
