import java.util.Random;

public class YourStrategy implements MoveStrategy {
    @Override
    public int NextMove() {
        return 0;
    }

    public int NextMove(int marbles){
        if(marbles == 1) {
            return 1;
        } else if(marbles % 2 == 1 || marbles == 5 || marbles == 2){
            return 2;
        } else {
            return 1;
        }
    }
}
