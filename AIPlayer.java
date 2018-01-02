public class AIPlayer {

    public static char Player = 'O'; // Player AI associates with

    public AIPlayer() {}

    public static int[] RandomMove(Board board){
        return Random.move(board);
    }
}
