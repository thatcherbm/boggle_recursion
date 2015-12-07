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
public class FindWord {
    
    
    /**
     * Looks for the word and returns a value
     * pre: none
     * post: if the word is found returns 1, if not found returns 0
     */
    public static int search(int iStart, int iEnd, int jStart, int jEnd, char[] word, int position) {
        int found = 0;
        if (position < (word.length)) {
            for (int i = iStart; i <= iEnd; i++) {
                for(int j = jStart; j <= jEnd; j++) {
                    char find = word[position];
                    char letter = Board.getLetter(i,j);
                    if (find == letter)  {
                        //we have found a matching letter so we need to
                        //determine boundaries of max 3x3 adjacent area to check 
                        //for next letter and pass it recursively
                        int iStartNext, iEndNext, jStartNext, jEndNext;
                        if (i == 0) {
                            iStartNext = 0;
                        } else {
                            iStartNext = i - 1;
                        }
                        if (i == (Board.getSize() - 1)) {
                            iEndNext = Board.getSize() - 1;
                        } else {
                            iEndNext = i + 1;
                        }
                        
                        if (j == 0) {
                            jStartNext = 0;
                        } else {
                            jStartNext = j - 1;
                        }
                        if (j == (Board.getSize() - 1)) {
                            jEndNext = Board.getSize() - 1;
                        } else {
                            jEndNext = j + 1;
                        }
                        /*save the letter we just found so it isn't found again
                          in a later recursion */
                        Board.save(i,j);
                        //Debug
                        //Board.displayBoard();
                        //System.out.println();
                        //call the recursion to look for the next letter
                        ;
                        if (search(iStartNext, iEndNext, jStartNext, jEndNext, word, (position + 1)) == 0) { 
                            //later recursions did not find the rest of the word
                            Board.unsave(i,j);
                        } else {
                            /*since we have found the whole word we need to back 
                              out of all the for loops without looking at 
                              additional letters, but we also need to reset the 
                              board for the next guess*/
                            Board.unsave(i,j);
                            i = Board.getSize();
                            j = Board.getSize();
                            found = 1;
                        }
                    }
                }
            }
        } else {
            found = 1;
            /* print out the board with the word letters in lower case so they 
               can see their word */
            Board.displayBoard();
        }
        
        
        
        return(found);
    }
}
