package controller;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import model.WordPairs;


/**
 *
 * @author Armandi
 */
public class FileHandler {
    //Firstly we will make an ArrayList for the text file.
    ArrayList<WordPairs> words = new ArrayList();
    
    /*
    We will make a method which can read the text file.
    */
    
    public ArrayList<WordPairs> readFile(){        
        //We'll make a scanner to the text file. We set the scanner to read from file source.
        Scanner scan = null;
        try {
<<<<<<< HEAD
<<<<<<< HEAD
        scan = new Scanner(new File("savedFile.txt"));  
=======
        scan = new Scanner(new File(filename));  
>>>>>>> origin/master
=======
        scan = new Scanner(new File("Word.txt"));  
>>>>>>> parent of 1631628... THE 100% Test done
        } catch (Exception e) {
            e.printStackTrace();
        }
        while(scan.hasNext()){
            String str = scan.nextLine();
            //System.out.println(str);
            //just checking if it reads the file.
            String[] tokens = str.split(",");
            //System.out.println(tokens[0]);
            //Parsing the data to int's. Then adding them to the ArrayList created in the beginning.
            String danish = tokens[0].trim();
            String polish = tokens[1].trim();
            
            WordPairs w = new WordPairs(danish, polish);
            //Now add the data to the ArrayList we created in the beginning.
            words.add(w);
        }
        
        return words;
    }
    
    /*
    method for overwriting the textfile.
    */
    public void writeToFile(){
    
    FileWriter fw;
        try {
    fw = new FileWriter("Word.txt");
            for (WordPairs w : words) {
                fw.append(w.getDanish()+","+w.getPolish());
                fw.append("\n");
            }
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
    
    

