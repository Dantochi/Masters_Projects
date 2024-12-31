public class Player {
    private String name;
    private MoveStrategy strategy;
    
    public Player(String name) {
        this.name = name;
        this.strategy = null; // No strategy means it's a human player
    }

    // 😅 This is nice, polymorphism happens in the constructor below... HumanStrategy, RandomStrategy and YourStrategy are candidates because they implement MoveStrategy
    public Player(String name, MoveStrategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    public int getMove(int currentPileSize) {
        // If the chosen strategy is HumanStrategy, the returned move here is the user input decision for marbles to take
        // If the chosen strategy is RandomStrategy, the returned move here is a random number between one and two
        YourStrategy winningMove = new YourStrategy();
        if(strategy instanceof YourStrategy){
            return winningMove.NextMove(currentPileSize);
        } else {
            return strategy.NextMove();
        }
//        if(strategy instanceof YourStrategy)
//            System.out.println("Your winning strategy has been implemented.");
//        return strategy.NextMove();
    }
    
    public String getName() {
        return name;
    }

    public MoveStrategy getStrategy() {
        return strategy;
    }
    
    public void setStrategy(MoveStrategy strategy) {
        this.strategy = strategy;
    }
    
}
