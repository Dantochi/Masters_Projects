import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NimGameGUI extends JFrame implements ActionListener {

    private TextBasedUI nimGame;
    public NimGameGUI(){
        super("The Game of 1-2 Nim Assessment"); // This is to instantiate an object of the JFrame class
        nimGame = new TextBasedUI();
        JLabel modeLabel = new JLabel("Select mode: ");
        JRadioButton easyRadioButton = new JRadioButton("Easy", true); // This gives the text on the button and leaves it selected by default
        JRadioButton hardRadioButton = new JRadioButton("Hard");
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(easyRadioButton);
        radioGroup.add(hardRadioButton);

        JPanel mainPanel = new JPanel();

        // Panel of Easy and Hard Mode
        JPanel modePanel = new JPanel();
        modePanel.add(modeLabel);
        modePanel.add(easyRadioButton);
        modePanel.add(hardRadioButton);
//        add(modePanel);

        // Panel for Winner
        JLabel winnerLabel = new JLabel("Winner: ");
        JLabel winnerResult = new JLabel("None");
        JPanel winnerPanel = new JPanel();
        winnerPanel.add(winnerLabel);
        winnerPanel.add(winnerResult);
//        add(winnerPanel);

        // Game Function Button Panels
        JButton newButton = new JButton("New Game");
        JButton saveButton = new JButton("Save");
        JButton loadButton = new JButton("Load");
        JButton undoButton = new JButton("Undo");
        newButton.addActionListener(this);
        saveButton.addActionListener(this);
        loadButton.addActionListener(this);
        undoButton.addActionListener(this);
        JPanel gameFunctionPanel = new JPanel();
        gameFunctionPanel.add(newButton);
        gameFunctionPanel.add(saveButton);
        gameFunctionPanel.add(loadButton);
        gameFunctionPanel.add(undoButton);
//        add(gameFunctionPanel);

        // Moves button
        JButton removeOneButton = new JButton("Remove 1");
        JButton removeTwoButton = new JButton("Remove 2");
        JPanel movePanel = new JPanel();
        movePanel.setLayout(new GridLayout(2, 1));
        movePanel.add(removeOneButton);
        movePanel.add(removeTwoButton);
//        add(movePanel);

        JPanel textPanel = new JPanel();
        JLabel marbles = new JLabel("Number of piles: ");
        JLabel num = new JLabel("10");
//        num.setEditable(false);
        textPanel.add(marbles);
        textPanel.add(num);
        JTextField textArea = new JTextField(5);
        JPanel marbleTextPanel = new JPanel(new GridLayout(2, 1));
        marbleTextPanel.add(textArea);
        marbleTextPanel.add(textPanel);

        //score Panel
        JPanel scorePanel = new JPanel(new GridLayout(1, 2));
        scorePanel.add(movePanel);
        scorePanel.add(marbleTextPanel);
//        scorePanel.add(num);

        mainPanel.setLayout(new GridLayout(4, 1)); // here I set the main panel to border layout to place panels in the SOUTH, WEST, EAST, NORTH and CENTER
        mainPanel.add(modePanel);
        mainPanel.add(winnerPanel);
        mainPanel.add(gameFunctionPanel);
        mainPanel.add(scorePanel);
//        mainPanel.add(movePanel);
        add(mainPanel);
//        add(scorePanel);



        makeFrame();
    }

    private void makeFrame(){
        setSize(500, 300); // This sets the size of the GUI window
        setVisible(true); // This is to make the GUI visible by setting it to true because by default it is invisible
    }

    public void actionPerformed(ActionEvent event){
        // Implement new game functionality
//        System.out.println(event.getActionCommand());
        switch(event.getActionCommand()){
            case "New Game":

                System.out.println("You have started a new game");
                break;
            case "Save":
                System.out.println("You have saved your game");
                break;
            case "Load":
                System.out.println("You have loaded your saved game");
                break;
            case "Undo":
                System.out.println("You have gone back to your previous step");
                break;
            default:
                System.out.println("Invalid choice. Please select again.");
                break;
        }
    }
}
