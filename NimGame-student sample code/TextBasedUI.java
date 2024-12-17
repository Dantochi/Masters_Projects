import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TextBasedUI {
    
    private NimGame game;
    private Scanner reader;
    private ArrayList<Integer> moveList;

    public TextBasedUI() {
        reader = new Scanner(System.in); // This creates a Scanner class to take in user choice of computer's strategy or gameMode and the options of reset, save, make move, undo etc.
        moveList = new ArrayList<>();
        File gameFile = new File("GameHistory.txt");
        try { // I added this bit
            if (gameFile.createNewFile()) {
                System.out.println("Game File created: " + gameFile.getName());
            } else {
                System.out.println("Game File History already exists.");
            }
        } catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        System.out.println("The Game of 1-2 Nim Assessment!");
        System.out.println("------------------------------");
        System.out.println("Choose a computer strategy:");
        System.out.println("""
                [R] Random
                [Y] Your Strategy
                """); // This was changed from using new line tags to using the """ """... its just to make the user go to the next line and not the same line as Your strategy option;

        String gameMode = reader.nextLine().toUpperCase(); // Takes in the users choice for the gameMode
        MoveStrategy computerStrategy; // This creates a move strategy to take in the user choice of game Mode for the computer... this helps when creating the class

        if (gameMode.equals("R")) {
            computerStrategy = new RandomStrategy(); // If the choice is R, we assign a RandomStrategy class to MoveStrategy for Computer... Polymorphism... nice
            System.out.println("You selected Random Computer strategy.");
        } else if (gameMode.equals("Y")) {
            computerStrategy = new YourStrategy(); // If the choice is Y, we assign a YourStrategy class (which I have to implement) to MoveStrategy for Computer... Polymorphism... nice
            System.out.println("You selected Your Computer strategy.");
        } else {
            System.out.println("Invalid option. Exiting..."); // Maybe something I can do here is to give the player another chance to pick again when they make an invalid option by using a loop or recursion
            return;
        }

        Player player1 = new Player("Human", new HumanUserStrategy()); // Takes in the Human Strategy and Name of the human
        Player player2 = new Player("Computer", computerStrategy); // Takes in the computer strategy specified at the start of the game and the name of the computer

        this.game = new NimGame(player1, player2); // Takes in the two players that have been created, this bit helps to assign move, check for winner, randomize marble size, check for whose turn it turn, save, undo, reset etc.
        startGame();
    }

    private void startGame() {
        System.out.println("\nInitial number of marbles: " + game.getMarbleSize()); // This returns the default marble size from the Nim game class by its instance 'game'
        displayMarbles(); // This displays the symbol '@' according to the number of marbles available

        while (!game.checkWinner()) {
            displayMenu();
        }

        announceWinner();
    }

        private void displayMenu() {  
        System.out.println("\nChoose an option: \n"
            + "[M] Make a move\n"
            + "[S] Save game\n"
            + "[L] Load saved game\n"
            + "[U] Undo move\n"
            + "[C] Clear game\n"
            + "[Q] Quit game\n");

        String choice = reader.nextLine().toUpperCase();
        switch (choice) {
            case "M":
                makeMove();
                break;
            case "S":
                game.saveGame();
                break;
            case "L":
                game.loadGame();
                displayMarbles();
                break;
            case "U":
                game.undoLastMove(moveList);
                displayMarbles();
                break;
            case "C":
                game.resetGame();
                startGame();
                break;
            case "Q":
                System.out.println("Thank you for playing! Exiting game...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please select again.");
        }
    }

    /**
     * Handle making a move for the human or computer player
     */ 
    private void makeMove() {
        
        if (game.isHumanTurn()){ // if this returns true from the Nim game class, it means its the turn of the human
            assignMoveFrom(game.getHumanPlayer()); // This is where marbles are deducted by humans move and marble size is updated and the human turn is negated to pass the turn to the computer player
            if(!game.checkWinner())
                assignMoveFrom(game.getComputerPlayer()); // computer move
        } else {
            assignMoveFrom(game.getComputerPlayer()); // This is where marbles are deducted by computers move and marble size is updated and the computer turn is negated to pass the turn to the human player
            if(!game.checkWinner())
                assignMoveFrom(game.getHumanPlayer()); // I'm not sure why this bit is needed but let's go with the flow and break some things intentionally later...
        }
    }
        

    private void assignMoveFrom(Player player) {
        System.out.println("\nIt is " + player.getName() + "'s turn to play.");
        int move = player.getMove(game.getMarbleSize()); // gets the move made by the player but currently, it does nothing with the pile_size, may be this can be used to create suggestions
        while (move > 2 || move < 0){
            // So this re-assigns the to move and breaks out of the loop whence value is not greater than two
            if (move > 2){
                System.out.println("\n" + player.getName() + " you can only pick a max of 2 marbles");
            }
            else{
                System.out.println("\n" + player.getName() + " have not picked any marble. This is an invalid input");
            }
            System.out.println("Try again");
            move = player.getMove(game.getMarbleSize()); // So this re-assigns the to move and breaks out of the loop whence value is not greater than two
        }
        game.assignMove(move); // when this runs the game.isHumanTurn() is assigned the opposite of its current boolean value, in this case, its value changes from true to false and it subtracts the value of move made by the computer or user from the pile of marbles;
        moveList.add(move);
        registerMove(move);
        System.out.println("This is the list that contains the value of moves that have been made " + moveList);
        //storeMove(move, player); // This is used to store the move that has been made by a player by writing to a file;
        System.out.println(player.getName() + " takes " + move + " marbles.");
        displayMarbles();
    }

    private void storeMove(int move, Player player){
        //This is what I am trying to implement
        //That I store the moves of both human and computer
        //Then when the array is of size = 2 (containing the file move and computer move)
        //pass the array into the registerMove method
        //Then reset the array
        ArrayList<Integer> moveList = new ArrayList<>();
        moveList.add(move);
        System.out.println(moveList);
        System.out.println(move + " was made by "+ player.getName());
//        if(moveList.size() == 2){
//            System.out.println(moveList.size());
//            registerMove(moveList);
//            moveList.clear();
//        }
    }
    private void registerMove(int move){
        // This should accept an array as an argument
        // Loop through the array
        // Store the moves of one game turn in this format for easy recovery:
        // {humanMove, ComputerMove}
        try{
            FileWriter gameWriter = new FileWriter("GameHistory.txt", true);
            //for (int move : moveList){
            gameWriter.write(move + ", ");
            //}
            gameWriter.close();
        } catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    private void displayMarbles() {
        System.out.println("Current number of marbles: " + game.getMarbleSize()); // This gets the randomized number of marbles set and the value everytime it is the marble is decremented
        for (int i = 0; i < game.getMarbleSize(); i++) {
            System.out.print("@ ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
    
    private void announceWinner() {
        String winnerName;
        if (game.isHumanTurn()) // This bit helps to check who is the winner, in its implementation, it checks for if the number of moves is less than or equal to zero
            // if it is, then it means that the player before the current player must have made it zero or finished the marbles and therefore, the previous player wins
            winnerName = game.getComputerPlayer().getName(); //Computer Wins
        else
            winnerName = game.getHumanPlayer().getName(); //Human Wins
        System.out.println("*** " + winnerName + " is the winner! ***");
    }


    public static void main(String[] args) {
        TextBasedUI textUi = new TextBasedUI(); // This runs the game
    }
}
