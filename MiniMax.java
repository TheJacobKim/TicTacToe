///*
// * Name: Hyunjun Kim
// * Date: Oct 26, 2017
// * File: MiniMax.java
// * Sources of Help:
// *
// *
// */
//
///**
// * MiniMax algorithm
// */
//public class MiniMax extends AIPlayer{
//    public static int[] MiniMax(Board board) {
//        for(Character[] i : board.getBoard()) {
//            for(char j : i) {
//                if(i == null) {
//                    Board.getBo
//                }
//            }
//        }
//    }
//
//    public static int[] getScore(char currentPly, ){
//
//    }
//
//    public static boolean gameEnd() {
//
//    }
//
//
//    public static int EvalScore(Board origBoard) {
//        Character[][] Board = origBoard.getBoard();
//        // Check win condition for columns
//        for(int i = 0; i < Board.length; i++) {
//            if(Board[i][0] != null && Board[i][0] == Board[i][1] && Board[i][1] == Board[i][2]) {
//                System.out.println(Board[i][0] + " Won!");
//                TicTacToeGUI.displayWinMessage(Board[i][0], canvas);
//                return true;
//            }
//            if(Board[0][i] != null && Board[0][i] == Board[1][i] && Board[1][i] == Board[2][i]) {
//                System.out.println(Board[0][i] + " Won!");
//                TicTacToeGUI.displayWinMessage(Board[0][i], canvas);
//                return true;
//            }
//        }
//
//        // Check win conditions for diagonals
//        if(Board[0][0] != null && Board[0][0] == Board[1][1] && Board[1][1] == Board[2][2]) {
//            System.out.println(Board[0][0] + " Won!");
//            TicTacToeGUI.displayWinMessage(Board[0][0], canvas);
//            return true;
//        }
//        if(Board[0][2] != null && Board[0][2] == Board[1][1] && Board[1][1] == Board[2][0]) {
//            System.out.println(Board[0][2] + " Won!");
//            TicTacToeGUI.displayWinMessage(Board[0][2], canvas);
//            return true;
//        }
//
//        return false;
//    }
//} // End of public class MiniMax