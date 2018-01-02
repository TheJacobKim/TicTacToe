import java.util.concurrent.ThreadLocalRandom;
import java.util.*;

public class Random extends AIPlayer{

    public static int[] move(Board board) {
        int[] moveHere = new int[2];
        int row, col;

        while(true) {
            row = ThreadLocalRandom.current().nextInt(0, 2);
            col = ThreadLocalRandom.current().nextInt(0, 2);
            if(board.getBoard(row, col) == ' '){
                moveHere[0] = row;
                moveHere[1] = col;
                return moveHere;
            }
        }
    }
}
