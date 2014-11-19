package model;

//@author Armandi & Lukasz

public class WordPairs {
    
    private String danish;
    private String polish;
    
public WordPairs(String danish, String polish){
    this.danish = danish;
    this.polish = polish;
    
}
    @Override
    public String toString() {
        return danish + "," + polish;
    }

    public String getDanish() {
        return danish;
    }

    public void setDanish(String danish) {
        this.danish = danish;
    }

    public String getPolish() {
        return polish;
    }

    public void setPolish(String polish) {
        this.polish = polish;
    }
}
