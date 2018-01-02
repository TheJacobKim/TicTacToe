/*
 * Name: Hyunjun Kim
 * Date: Oct 26, 2017
 * File: TicTacToe.java
 * Sources of Help:
 *
 * the fact that I like the 
 */

import objectdraw.*;
import Acme.*;
import java.awt.*;
import java.util.*;


/**
 * Starts Tic Tac Toe Game
 */
public class TicTacToeGUI extends WindowController {
    /* Canvas settings */
    private static int canvasHeight = 600;
    private static int canvasWidth = 600;
    private static int ONE_THIRD_HEIGHT = canvasHeight/3;
    private static int TWO_THIRD_HEIGHT = canvasHeight/3*2;
    private static int ONE_THIRD_WIDTH = canvasWidth/3;
    private static int TWO_THIRD_WIDTH = canvasWidth/3*2;

    /* X & O settings */
    private static final double DIAMETER = 150;

    /* Who's turn is it? */
    private static Character turn = 'X';

    /* Create lines for quadrants */
    private Line VertLine1, VertLine2, HoriLine1, HoriLine2;

    /* 2D array of Tic Tac Toe board */
    public static Board theBoard = new Board();

    /* Player and AI's turn */
    private static char playerTurn = 'X';
    private static char AITurn = 'O';

    /**
     * Main method
     * @param args Not used in this program.
     */
    public static void main(String[] args) {
        new Acme.MainFrame(new TicTacToeGUI(), args, canvasHeight, canvasWidth);
    }

    /**
     * Start CrazyOrbGUI by making two lines which represent x-axis and y-axis.
     */
    public void begin() {
        /* Show lines */
        VertLine1 = new Line(ONE_THIRD_WIDTH, 0, ONE_THIRD_WIDTH,
                canvasHeight, canvas);
        VertLine2 = new Line(TWO_THIRD_WIDTH, 0, TWO_THIRD_WIDTH,
                canvasHeight, canvas);
        HoriLine1 = new Line(0, ONE_THIRD_HEIGHT, canvasWidth,
                ONE_THIRD_HEIGHT, canvas);
        HoriLine2 = new Line(0, TWO_THIRD_HEIGHT, canvasWidth,
                TWO_THIRD_HEIGHT, canvas);

    }

    /**
     * When mouse is clicked, create a crazy orb.
     * @param point: point of mouse pointer.
     */
    public void onMouseClick(Location point) {
        int[] moveHere = new int[2];
        if (!Board.GameEnd(canvas) && turn == playerTurn) {
            int loc = checkLocation(point, theBoard.getBoard());
            if (turn == playerTurn && loc != -1) {
                new Line(25 + 200 * (loc % 3), 25 + 200 * (loc / 3),
                        175 + 200 * (loc % 3), 175 + 200 * (loc / 3), canvas);
                new Line(175 + 200 * (loc % 3), 25 + 200 * (loc / 3),
                        25 + 200 * (loc % 3), 175 + 200 * (loc / 3), canvas);
                turn = AITurn;
            } else if (turn == AITurn && loc != -1) {
                new FramedOval(25 + 200 * (loc % 3), 25 + 200 * (loc / 3),
                        DIAMETER, DIAMETER, canvas);
                turn = playerTurn;
            }
            Board.GameEnd(canvas);
        }
        else if(!Board.GameEnd(canvas)) {
            moveHere = runAlgorithm(theBoard);
            new FramedOval(moveHere[0]*200, moveHere[1]*200,
                    DIAMETER, DIAMETER, canvas);
            turn = 'X';
            Board.GameEnd(canvas);
        }

        System.out.println(Arrays.deepToString(theBoard.getBoard()));
    }


    public static int[] runAlgorithm(Board board) {
        String currentAlgorithm = "Random";
        int[] moveHere = new int[2];

        if(currentAlgorithm.equals("Random")) {
            moveHere = AIPlayer.RandomMove(board);
        }
        board.setBoard(moveHere[0], moveHere[1], turn);
        return moveHere;
    }
    /**
     * Check which block was clicked.
     * @param point
     * @return location of the block
     */
    public static int checkLocation(Location point, Character[][] Board) {
        double x = point.getX();
        double y = point.getY();

        int loc;

        // Check location for each block
        if(x > 0 && x < ONE_THIRD_WIDTH && y > 0 && y < ONE_THIRD_HEIGHT) {
            if(Board[0][0] == ' ') {
                Board[0][0] = turn;
                loc = 0;
            } else
                loc = -1;
        } else if(x > 0 && x < ONE_THIRD_WIDTH && y > ONE_THIRD_HEIGHT &&
                y < TWO_THIRD_HEIGHT) {
            if(Board[1][0] == ' ') {
                Board[1][0] = turn;
                loc = 3;
            } else
                loc = -1;
        } else if(x > 0 && x < ONE_THIRD_WIDTH && y > TWO_THIRD_HEIGHT &&
                y < canvasHeight) {
            if(Board[2][0] == ' ') {
                Board[2][0] = turn;
                loc = 6;
            } else
                loc = -1;
        } else if(x > ONE_THIRD_WIDTH && x < TWO_THIRD_WIDTH && y > 0 &&
                y < ONE_THIRD_HEIGHT) {
            if(Board[0][1] == ' ') {
                Board[0][1] = turn;
                loc = 1;
            } else
                loc = -1;
        } else if(x > ONE_THIRD_WIDTH && x < TWO_THIRD_WIDTH &&
                y > ONE_THIRD_HEIGHT && y < TWO_THIRD_HEIGHT) {
            if(Board[1][1] == ' ') {
                Board[1][1] = turn;
                loc = 4;
            } else {
                loc = -1;
            }
        } else if(x > ONE_THIRD_WIDTH && x < TWO_THIRD_WIDTH &&
                y > TWO_THIRD_HEIGHT && y < canvasHeight) {
            if(Board[2][1] == ' ') {
                Board[2][1] = turn;
                loc = 7;
            } else
                loc = -1;
        } else if(x > TWO_THIRD_WIDTH && x < canvasWidth && y > 0 &&
                y < ONE_THIRD_HEIGHT) {
            if(Board[0][2] == ' ') {
                Board[0][2] = turn;
                loc = 2;
            } else
                loc = -1;
        } else if(x > TWO_THIRD_WIDTH && x < canvasWidth &&
                y > ONE_THIRD_HEIGHT && y < TWO_THIRD_HEIGHT) {
            if(Board[1][2] == ' ') {
                Board[1][2] = turn;
                loc = 5;
            } else {
                loc = -1;
            }
        } else if(x > TWO_THIRD_WIDTH && x < canvasWidth &&
                y > TWO_THIRD_HEIGHT && y < canvasHeight){
            if(Board[2][2] == ' ') {
                Board[2][2] = turn;
                loc = 8;
            } else
                loc = -1;
        } else {
            loc = -1;
        }
        return loc;
    }

    /**
     * When game ends, display a win message
     * @param turn
     * @param canvas
     */
    public static void displayWinMessage(Character turn, DrawingCanvas canvas) {
        Text winMessage = new Text(turn + " Won!", 200, 200, canvas);
        winMessage.setFontSize(80);
        winMessage.setBold();
        winMessage.show();
    }
} // End of public class TicTacToeGUI
