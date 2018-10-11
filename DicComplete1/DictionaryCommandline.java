/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;
import java.util.Scanner;
/**
 *
 * @author Admin
 */
public class DictionaryCommandline {
    public void showAllWords(Dictionary dictionary)
    {
        System.out.println("NO  | English   | Vietnamese");
        for(int i=0;i<dictionary.getArray().size();i++)
        {
            System.out.println(i+1+"   | "+dictionary.getArray().get(i).getWordTarget()+"  | "+dictionary.getArray().get(i).getWordExplain());
        }
    }
    public void dictionaryBasic()
    {
        DictionaryManagement input=new DictionaryManagement();
        Dictionary word=new Dictionary();
        word=input.insertFromFile();
        DictionaryCommandline output=new DictionaryCommandline();
        output.showAllWords(word);
    }
    public void dictionaryAdvanced()
    {
        DictionaryManagement DictionaryInput=new DictionaryManagement();
        Dictionary dictionary=new Dictionary();
        dictionary=DictionaryInput.insertFromFile();//nhap list word
        //show all
        DictionaryCommandline DictionaryOutput=new DictionaryCommandline();
        DictionaryOutput.showAllWords(dictionary);
        //look up
        String Word;
        if((Word=DictionaryInput.dictionaryLookup(dictionary))!=null)
        {
            System.out.println("This word mean: "+Word);
        }
        else
        {
            System.out.println("This word isn't in Dictionary");
        }
        //Fix Data
        dictionary=DictionaryInput.FixData(dictionary);
        DictionaryOutput.showAllWords(dictionary);
        //Search
        dictionarySearcher(dictionary);
        //Export to File
        DictionaryInput.dictionaryExportToFile(dictionary);
    }
    public void dictionarySearcher(Dictionary dictionary)
    {
       Scanner scanner=new Scanner(System.in);
       System.out.println("Input the word: ");
       String line = scanner.nextLine();
        
        for(int i=0;i<dictionary.getArray().size();i++)
        {
            if((dictionary.getArray().get(i).getWordTarget()).indexOf(line) > -1)
            {
                System.out.println(dictionary.getArray().get(i).getWordTarget());
            }
        }
    }
}
