/*
 * Name: Hyunjun Kim
 * Date: Oct 26, 2017
 * File: Board.java
 * Sources of Help:
 *
 *
 */

import objectdraw.*;
import Acme.*;

/**
 * Declares Board object
 */
public class Board {

    /* 2D array of Tic Tac Toe board */
    private static Character[][] Board = new Character[3][3];

    /**
     * ctor, initializes the board
     */
    public Board(){
        /* Initialize 2D array */
        for (int i = 0; i < Board.length; i++) {
            for (int j = 0; j < Board[i].length; j++) {
                Board[i][j] = ' ';
            }
        }
    }

    /**
     * return current Board
     * @return 2D array of board
     */
    public static Character[][] getBoard() {
        return Board;
    }


    public static char getBoard(int row, int col) {
        return Board[row][col];
    }
    /**
     * Accepts x & y coordinates and turn to update the board
     * @param x location
     * @param y location
     * @param turn indicates the current turn.
     */
    public static void setBoard(int x, int y, char turn) {
        Board[x][y] = turn;
    }

    /**
     * Check if someone has won
     * @return
     */
    public static boolean GameEnd(DrawingCanvas canvas) {
        // Check win condition for columns
        for(int i = 0; i < Board.length; i++) {
            if(Board[i][0] != ' ' && Board[i][0] == Board[i][1] && Board[i][1] == Board[i][2]) {
                System.out.println(Board[i][0] + " Won!");
                TicTacToeGUI.displayWinMessage(Board[i][0], canvas);
                return true;
            }
            if(Board[0][i] != ' ' && Board[0][i] == Board[1][i] && Board[1][i] == Board[2][i]) {
                System.out.println(Board[0][i] + " Won!");
                TicTacToeGUI.displayWinMessage(Board[0][i], canvas);
                return true;
            }
        }

        // Check win conditions for diagonals
        if(Board[0][0] != ' ' && Board[0][0] == Board[1][1] && Board[1][1] == Board[2][2]) {
            System.out.println(Board[0][0] + " Won!");
            TicTacToeGUI.displayWinMessage(Board[0][0], canvas);
            return true;
        }
        if(Board[0][2] != ' ' && Board[0][2] == Board[1][1] && Board[1][1] == Board[2][0]) {
            System.out.println(Board[0][2] + " Won!");
            TicTacToeGUI.displayWinMessage(Board[0][2], canvas);
            return true;
        }

        return false;
    }
} // End of public class Board

// dkdlridldkridldxrlaisklrmdksirlagisdrkdi


// rlaguswns Wkd zz apzk guswns Wkd

// rlaugskdmdkr irldkxm rTic Tac Toe GU Idlrdi lrsidk m dirdk
// GUI disladkrki sldi r d adkrial dr krasid krkxidk mrkalsid krmd익 이게뭐야
