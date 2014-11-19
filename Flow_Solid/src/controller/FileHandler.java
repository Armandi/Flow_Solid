package controller;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import model.WordPairs;

//@author Armandi & Lukasz

public class FileHandler {

//method which can read the text file.
    public boolean readFile(String filename, ArrayList<WordPairs> listWords,ArrayList<Integer> prob) {

        Scanner scan = null;
        try {
            scan = new Scanner(new File(filename));
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
        while (scan.hasNext()) {
            
            String str = scan.nextLine();
            String[] tokens = str.split(",");
            String danish = tokens[0].trim();
            String polish = tokens[1].trim();
            WordPairs wp = new WordPairs(danish, polish);
            prob.add(5);
            listWords.add(wp);
            
        }
        return true;
    }

    //method for overwriting the textfile.
    public boolean writeToFile(String filename, ArrayList<WordPairs> listWords) {

        FileWriter fw;
        try {
            fw = new FileWriter(filename);
            for (WordPairs w : listWords) {
                fw.append(w.getDanish() + "," + w.getPolish());
                fw.append("\n");
            }
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
