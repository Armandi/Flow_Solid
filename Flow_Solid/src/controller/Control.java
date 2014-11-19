package controller;

import interfaces.WordPairControlInterface;
import model.WordPairs;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//@author Armandi & Lukasz

public class Control implements WordPairControlInterface {

    private ArrayList<WordPairs> words = new ArrayList();
    private int currentQuestion;

    Random rn = new Random();
    FileHandler fh = new FileHandler();

    @Override
    public void add(String question, String answer) {

        words.add(new WordPairs(question, answer));
    }

    @Override
    public int size() {
        return words.size();
    }

    @Override
    public String getRandomQuestion() {
        currentQuestion = rn.nextInt(size());
        return words.get(currentQuestion).getDanish();
    }

    @Override
    public boolean checkGuess(String question, String quess) {
        if (words.get(currentQuestion).getDanish().equalsIgnoreCase(question)) {
            if (words.get(currentQuestion).getPolish().equalsIgnoreCase(quess)) {

                return true;
            }
        }
        return false;
    }

    @Override
    public String lookup(String question) {
        for (WordPairs wordPairs : words) {
            if (wordPairs.getDanish().equals(question)) {
                return wordPairs.getPolish();
            }
        }
        return null;
    }

    @Override
    public boolean load(String filename) {
        return fh.readFile(filename, words);
    }

    @Override
    public boolean save(String filename) {
        return fh.writeToFile(filename, words);
    }

    @Override
    public void clear() {
        words.clear();
    }

}
