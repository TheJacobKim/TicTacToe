/*
 * Name: Hyunjun Kim
 * Date: Dec 20, 2017
 * File: TicTacToeGUI.java
 *
 * CrazyOrbGUI.java makes an user graphics interface. When you run the program,
 * 600 x 600 canvas is created with an x-axis and y-axis at the center of the
 * canvas. You can change x and y axis location by dragging them.
 *
 * By clicking any part of the canvas, a crazyOrb is created. CrazyOrb
 * shrinks and grows and changes color accordting to their locations.
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
    private static Character[][] Board = new Character[3][3];

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
        VertLine1 = new Line(ONE_THIRD_WIDTH, 0, ONE_THIRD_WIDTH, canvasHeight, canvas);
        VertLine2 = new Line(TWO_THIRD_WIDTH, 0, TWO_THIRD_WIDTH, canvasHeight, canvas);
        HoriLine1 = new Line(0, ONE_THIRD_HEIGHT, canvasWidth, ONE_THIRD_HEIGHT, canvas);
        HoriLine2 = new Line(0, TWO_THIRD_HEIGHT, canvasWidth, TWO_THIRD_HEIGHT, canvas);

        /* Initialize 2D array */
        for (int i = 0; i < Board.length; i++) {
            for (int j = 0; j < Board[i].length; j++) {
                Board[i][j] = null;
            }
        }
    }

    /**
     * When mouse is clicked, create a crazy orb.
     * @param point: point of mouse pointer.
     */
    public void onMouseClick(Location point) {
        int loc = checkLocation(point);
        if(turn == 'X' && loc != -1) {
            new Line(25 + 200 * (loc%3), 25 + 200 * (loc/3), 175 + 200 * (loc%3), 175 + 200 * (loc/3), canvas);
            new Line(175 + 200 * (loc%3), 25 + 200 * (loc/3), 25 + 200 * (loc%3), 175 + 200 * (loc/3), canvas);

            turn = 'O';
        } else if(turn == 'O' && loc != -1) {
            new FramedOval(25 + 200 * (loc%3), 25 + 200 * (loc/3), DIAMETER, DIAMETER, canvas);
            turn = 'X';
        }
        System.out.println(Arrays.deepToString(Board));
        checkWin();
    }


    /**
     * Check which block was clicked.
     * @param point
     * @return location of the block
     */
    public static int checkLocation(Location point) {
        double x = point.getX();
        double y = point.getY();

        int loc = 0;

        if(x > 0 && x < ONE_THIRD_WIDTH && y > 0 && y < ONE_THIRD_HEIGHT) {
            if(Board[0][0] == null) {
                Board[0][0] = turn;
                loc = 0;
            } else {
                loc = -1;
            }
        } else if(x > 0 && x < ONE_THIRD_WIDTH && y > ONE_THIRD_HEIGHT && y < TWO_THIRD_HEIGHT) {
            if(Board[1][0] == null) {
                Board[1][0] = turn;
                loc = 3;
            } else {
                loc = -1;
            }
        } else if(x > 0 && x < ONE_THIRD_WIDTH && y > TWO_THIRD_HEIGHT && y < canvasHeight) {
            if(Board[2][0] == null) {
                Board[2][0] = turn;
                loc = 6;
            } else {
                loc = -1;
            }
        } else if(x > ONE_THIRD_WIDTH && x < TWO_THIRD_WIDTH && y > 0 && y < ONE_THIRD_HEIGHT) {
            if(Board[0][1] == null) {
                Board[0][1] = turn;
                loc = 1;
            } else {
                loc = -1;
            }
        } else if(x > ONE_THIRD_WIDTH && x < TWO_THIRD_WIDTH && y > ONE_THIRD_HEIGHT && y < TWO_THIRD_HEIGHT) {
            if(Board[1][1] == null) {
                Board[1][1] = turn;
                loc = 4;
            } else {
                loc = -1;
            }
        } else if(x > ONE_THIRD_WIDTH && x < TWO_THIRD_WIDTH && y > TWO_THIRD_HEIGHT && y < canvasHeight) {
            if(Board[2][1] == null) {
                Board[2][1] = turn;
                loc = 7;
            } else {
                loc = -1;
            }
        } else if(x > TWO_THIRD_WIDTH && x < canvasWidth && y > 0 && y < ONE_THIRD_HEIGHT) {
            if(Board[0][2] == null) {
                Board[0][2] = turn;
                loc = 2;
            } else {
                loc = -1;
            }
        } else if(x > TWO_THIRD_WIDTH && x < canvasWidth && y > ONE_THIRD_HEIGHT && y < TWO_THIRD_HEIGHT) {
            if(Board[1][2] == null) {
                Board[1][2] = turn;
                loc = 5;
            } else {
                loc = -1;
            }
        } else if(x > TWO_THIRD_WIDTH && x < canvasWidth && y > TWO_THIRD_HEIGHT && y < canvasHeight){
            if(Board[2][2] == null) {
                Board[2][2] = turn;
                loc = 8;
            } else {
                loc = -1;
            }
        } else {
            loc = -1;
        }
        return loc;
    }

    /**
     * Check if someone has won
     * @return
     */
    public static void checkWin() {

        for(int i = 0; i < Board.length; i++) {
            if(Board[i][0] != null && Board[i][0] == Board[i][1] && Board[i][1] == Board[i][2]) {
                System.out.println(Board[i][0] + " Won!");
                System.exit(1);
            }
            if(Board[0][i] != null && Board[0][i] == Board[1][i] && Board[1][i] == Board[2][i]) {
                System.out.println(Board[0][i] + " Won!");
                System.exit(1);
            }
        }

        if(Board[0][0] != null && Board[0][0] == Board[1][1] && Board[1][1] == Board[2][2]) {
            System.out.println(Board[0][0] + " Won!");
            System.exit(1);
        }
        if(Board[0][2] != null && Board[0][2] == Board[1][1] && Board[1][1] == Board[2][0]) {
            System.out.println(Board[0][2] + " Won!");
            System.exit(1);
        }
    }

//    public static void displayWinMessage() {
//        new Text
//    }
} // End of public class TicTacToeGUI
