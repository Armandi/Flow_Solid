/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import interfaces.WordPairControlInterface;
import model.WordPairs;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Armandi
 */
public class Control implements WordPairControlInterface {

     private ArrayList<WordPairs> words = new ArrayList();
     private int currentQuestion;
     
     Random rn = new Random();
     FileHandler fh = new FileHandler();
     
    /**
     * Pre: Post: A new word pair is added to the existing collection of word
     * pairs. This method does not save to file!
     */
    @Override
    public void add(String question, String answer) {
        
        words.add(new WordPairs(question, answer));
    }

    /**
     * Pre: Post: Returns the number of wordpairs in the collection (not the file).
     */
    @Override   
    public int size() {
        return words.size();
    }

    /**
     * Pre: At least one word pair must be present Post: Returns a question
     * randomly selected from the collection of word pairs.
     */
    @Override
    public String getRandomQuestion() {
    //System.out.println("chuj");
     currentQuestion = rn.nextInt(size());
       // System.out.println("cci w dupe");
        
     return words.get(currentQuestion).getDanish();
    }

    /**
     * Pre: Post: Returns true if (question, quess) exists as a word pair in the
     * collection, otherwise false.
     */
    @Override
    public boolean checkGuess(String question, String quess) 
    {
        if(words.get(currentQuestion).getDanish().equalsIgnoreCase(question))
        {
            if(words.get(currentQuestion).getPolish().equalsIgnoreCase(quess))
            {
            
                    
                    return true;
            }
        }
        return false;
    }
    

    /**
     * Pre: Post: Returns the answer corresponding to the question if this
     * exists in the collection. Otherwise it returns null.
     */
    @Override
    public String lookup(String question) {
        for (WordPairs wordPairs : words) {
            if( wordPairs.getDanish().equals(question) ){
                return wordPairs.getPolish();
            }
        }
        return null;
    }

    /**
     * Pre: Post: Word pairs are read from the file "filename" and added to the
     * collection of word pairs. Returns true if successfully done. Otherwise it
     * returns false.
     */
    @Override
    public boolean load(String filename) {
        return fh.readFile(filename, words);
    }

    /**
     * Pre: Post: All word pairs from the collection has been written to the
     * file "filename" Returns true if successfully done. Otherwise false.
     */
    @Override
    public boolean save(String filename) {
        return fh.writeToFile(filename, words);
    }

    /**
     * Pre: Post: The existing collection of word pairs is cleared
     */
    @Override
    public void clear() {
        words.clear();
    }

    
}
