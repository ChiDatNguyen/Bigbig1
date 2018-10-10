/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;
import java.util.ArrayList;
import java.util.*;
/**
 *
 * @author Admin
 */
public class Dictionary
{
    ArrayList<Word> Words=new ArrayList<Word>();
    public void addWord(Word word)
    {
        this.Words.add(word);
    }
    public int getSize()
    {
        return this.Words.size();
    }
    public ArrayList<Word> getArray()
    {
        return this.Words;
    }
}

