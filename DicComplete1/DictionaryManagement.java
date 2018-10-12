/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;


/**
 *
 * @author Admin
 */
public class DictionaryManagement {
    public Word setNewWord()
    {
        Scanner scanner=new Scanner(System.in);
        Word NewWord=new Word();
        System.out.println("Input word: ");
        NewWord.setWordTarget(scanner.nextLine());
        System.out.println("Input mean: ");
        NewWord.setWordExplain(scanner.nextLine());
        return NewWord;
    }
    public Dictionary insertFromCommandline(Dictionary dictionary)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Input the number of word want to add: ");
        int num= scanner.nextInt();
        for(int i=0;i<num;i++)
        {
            dictionary.addWord(setNewWord());
        }
        return dictionary;
    }
    public Dictionary insertFromFile() 
    {
        try
        {
            Dictionary Word=new Dictionary();
            File file= new File("D:\\dic.txt");
            FileReader Reader = new FileReader(file);
            BufferedReader Buffer= new BufferedReader(Reader);
            String count=Buffer.readLine();
            while(count != null)
            {
                Word NewWord= new Word();
                int i= count.lastIndexOf(9);//tab=9
                NewWord.setWordTarget(count.substring(0,i));
                NewWord.setWordExplain(count.substring(i));
                Word.addWord(NewWord);
                count=Buffer.readLine();
            }
            Reader.close();
            Buffer.close();
            return Word;
        }
        catch(Exception ex)
        {
            System.out.println("Error: " +ex);
        }
        return null;
    }
    public String dictionaryLookup(Dictionary dictionary)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Input word: ");
        String line=scanner.nextLine();
        for(int i=0;i<dictionary.getArray().size();i++)
        {
            if(line.equals(dictionary.getArray().get(i).getWordTarget()))
            {
                return dictionary.getArray().get(i).getWordExplain();
            }
        }
        return null;
    }
    
    public Dictionary FixData(Dictionary dictionary)
    {
        System.out.println("Select function:\n 1.Add\n 2.Delete\n 3.Fix");
        Scanner scanner=new Scanner(System.in);
        int select=scanner.nextInt();
        if(select==1)
        {
            return addWord(dictionary);
        }
        else if(select==2)
        {
            return deleteWord(dictionary);
        }
        else if(select==3)
        {
            return fixWord(dictionary);
        }
        return null;
    }
    
    public Dictionary addWord(Dictionary dictionary)
    {
        return insertFromCommandline(dictionary);
    }
    public Dictionary deleteWord(Dictionary dictionary) 
    {
        System.out.println("Delete word: ");
        Scanner scanner=new Scanner(System.in);
        String delete=scanner.nextLine();
        for(int i=0;i<dictionary.getArray().size();i++)
        {
            if(delete.equals(dictionary.getArray().get(i).getWordTarget()))
            {
                dictionary.getArray().remove(dictionary.getArray().get(i));
            }
        }
        return dictionary;
    }
    public Dictionary fixWord(Dictionary dictionary)
    {
        System.out.println("The word that you want to fix: ");
        Scanner scanner= new Scanner(System.in);
        String editWord = scanner.nextLine();
        for(int i=0;i<dictionary.getArray().size();i++){
            if(editWord.equals(dictionary.getArray().get(i).getWordTarget()))
            {
                System.out.println("Fix word: ");
                dictionary.getArray().get(i).setWordTarget(scanner.nextLine());
                System.out.println("Fix word mean: ");
                dictionary.getArray().get(i).setWordExplain(scanner.nextLine());
            }
        }
        return dictionary;
    }
    
    public void dictionaryExportToFile(Dictionary dictionary)
    {
        try
        {
            File file=new File("D:\\dic.txt");
            FileWriter fw= new FileWriter(file);
            for(int i=0;i<dictionary.getArray().size();i++)
            {
                fw.write(dictionary.getArray().get(i).getWordTarget()+(char)(9)+dictionary.getArray().get(i).getWordExplain()+"\n");
            }
            fw.close();
        } 
        catch(Exception ex){
            System.out.println("Error: " +ex);
        }
    }
}
