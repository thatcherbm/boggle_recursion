/* 
 * MyBoggle.java
 * 
 * Ben Thatcher
 * ITEC 2842
 * 8/17/15
 *
 * This program completes the MyBoggle Exercise from Ch13
 * Generates a Boggle game board which can be of any square size but for the 
 * purposes of this assignment the size is set in the code rather than user input.
 * This board is created using random numbers and a Character array of the letters
 * of the alphabet.  The board is displayed to the user, then the user is prompted
 * to guess a word found on the board according to the rules of Boggle. The 
 * program then recursively searches for the letters of the word on the board and
 * if found re-displays the board with the letters of their word shown in lower
 * case letters, then returns the board to its original configuration and prompts
 * for a new word.  Typing in the number 9 will exit the program.
 */

package myboggle;

/**
 *
 * @author thatcherb
 */

import java.util.Scanner;

public class MyBoggle {
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Board play = new Board(5);
        String guess;
        char[] guessLetters;
        Scanner input = new Scanner(System.in);
        play.displayBoard();
        System.out.print("Enter a word found on the board (9 to quit): ");
        guess = input.nextLine();
        guess = guess.toUpperCase();
        while (guess.compareTo("9") != 0) {
            guessLetters = guess.toCharArray();
            //debug
            //System.out.println(guessLetters.length);
            if (FindWord.search(0, Board.getSize() - 1, 0, Board.getSize() - 1, 
                    guessLetters, 0) == 1) {
                System.out.println(guess + " found, Way to go!");
                //debug
                //play.displayBoard();
            } else {
                System.out.println(guess + " not found, Try again");
            }
            
            System.out.print("\nEnter a word found on the board (9 to quit): ");
            guess = input.nextLine();
            guess = guess.toUpperCase();
            //System.out.println(guess);
        }
        
        
    }
    
}
