/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

/**
 *
 * @author Admin
 */
public class Word {
    String word_target, word_explain;
    public void setWordTarget(String n)
    {
        this.word_target=n;
    }
    public void setWordExplain(String n)
    {
        this.word_explain=n;
    }
    public String getWordTarget()
    {
        return this.word_target;
    }
    public String getWordExplain()
    {
        return this.word_explain;
    }

    void getWordTarget(String trim) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void getWordExplain(String trim) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
