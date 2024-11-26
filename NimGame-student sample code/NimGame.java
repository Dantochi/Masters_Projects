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
        this.humanPlayer = humanPlayer;
        this.computerPlayer = computerPlayer;
        this.isHumanTurn = random.nextBoolean();
    }

    public void assignMove(int removeAmount) {

        marbleSize -= removeAmount; // This removes the amount of marbles taken from the pile either by the computer or human as the game goes on
        isHumanTurn = !isHumanTurn;
    }

    public boolean checkWinner() {
        return marbleSize <= 0;
    }

    public void saveGame() {
        System.out.println("Code not yet implemented\n");
    }

    public void loadGame() {
        System.out.println("Code not yet implemented \n");
    }

    public void undoLastMove() {
        System.out.println("Code not yet implemented \n");
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
