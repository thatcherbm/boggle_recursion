/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package myboggle;

/**
 *
 * @author thatcherb
 */

import java.lang.Math;

public class Board {
    private static char[][] gameBoard;
    private static int boardSize;
    
    /**
     * Constructor
     * creates a new square board with variable letters per side
     * pre: size is 4, 5, or 6 to match up with existing Boggle Formats
     * post: a board size by size is created.
     * @param size 
     */
    public Board(int size) {
        boardSize = size;
        gameBoard = new char[boardSize][boardSize];
        newBoard();
    }
    
    /**
     * Populates the board with letters
     * pre: none
     * post: the board has new letters in each array index
     */
    public static void newBoard() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] aphabetLetters = alphabet.toCharArray();
        //using meaningful indexes generate random numbers 0-25 and assign
        //a letter into the gameBoard array
        for(int i = 0; i < gameBoard.length; i++) {
            for(int j = 0; j < gameBoard.length; j++) {
                int random = (int)(25 * Math.random() + 0);
                gameBoard[i][j] = aphabetLetters[random];
            }
        }
    }
    
    /**
     * Displays the board for the user to see
     * pre: none
     * post: the board has been displayed.
     */
    public static void displayBoard() {
        for(int i = 0; i < gameBoard.length; i++) {
            for(int j = 0; j < gameBoard.length; j++) {
                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    /**
     * returns the letter at location i,j
     * pre: none
     * post: letter is returned
     * @param i
     * @param j
     * @return 
     */
    public static char getLetter(int i, int j) {
        return(gameBoard[i][j]);
    }
    
    /**
     * returns the boardSize
     * pre: none
     * post: boardSize is returned
     * @return 
     */
    public static int getSize() {
        return(boardSize);
    }
    
    /**
     * Saves the letter which has been found, converting it to lower case so that
     * later recursions will ignore this letter in the array since each letter on
     * the board can only be used once.
     * pre: none
     * post: letter is made lower case
     * @param i
     * @param j 
     */
    public static void save(int i, int j) {
        gameBoard[i][j] = Character.toLowerCase(gameBoard[i][j]);
    }
    
    /**
     * Un-saves a letter which was correct but was not adjacent to the next letter
     * in the word by converting it back to upper case.
     * pre: none
     * post: letter is made upper case.
     * @param i
     * @param j 
     */
    public static void unsave(int i, int j) {
        gameBoard[i][j] = Character.toUpperCase(gameBoard[i][j]);
    }
}
