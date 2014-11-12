/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flow_solid;

/**
 *
 * @author Armandi
 */
public class WordPairs {
    private String danish;
    private String english;
    
public WordPairs(String danish, String english){
    this.danish = danish;
    this.english = english;
    
}
    @Override
    public String toString() {
        return danish + "," + english;
    }

    public String getDanish() {
        return danish;
    }

    public void setDanish(String danish) {
        this.danish = danish;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }
}
