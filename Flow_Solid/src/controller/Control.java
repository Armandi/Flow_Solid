package controller;

import interfaces.WordPairControlInterface;
import model.WordPairs;
import java.util.ArrayList;
import java.util.Random;

//@author Armandi & Lukasz

public class Control implements WordPairControlInterface {

    private ArrayList<WordPairs> words = new ArrayList();
    private ArrayList<Integer> prob = new ArrayList();

    private int currentQuestion;

    FileHandler fh = new FileHandler();

    @Override
    public void add(String question, String answer) {
        words.add(new WordPairs(question, answer));
        prob.add(5);
    }

    @Override
    public int size() {
        return words.size();
    }

    @Override
    public String getRandomQuestion() {
         Random rn = new Random();
        int random = rn.nextInt(prob.size());
        int number = rn.nextInt(10) + 1;
        if (number > prob.get(random)) {
            return getRandomQuestion();
        } else {
            return words.get(random).getDanish();
        }
    }

    @Override
    public boolean checkGuess(String question, String guess) {
        String answer = null;
        int counter = 0;
        for (WordPairs list : words) {
            if (list.getDanish().equalsIgnoreCase(question)) {
                answer = list.getPolish();
                break;
            }
            counter++;
        }
        if (guess.equalsIgnoreCase(answer)) {
            prob.set(counter, prob.get(counter) - 1);
            return true;
        } else {
            prob.set(counter, prob.get(counter) + 1);
            return false;
        }
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
        return fh.readFile(filename, words,prob);
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
