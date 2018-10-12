package com.company;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryManagement {

    public Dictionary insertFromCommandline(Dictionary dictionary) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        for (int i=0; i<num; i++){
            String en = sc.nextLine();
            String vn = sc.nextLine();
            dictionary.dictArr.add(new Word(en, vn));
        }
        return dictionary;
    }

    public Dictionary insertFromFile() throws FileNotFoundException {
        Dictionary dictionary = new Dictionary();
        Scanner sc = new Scanner(new File("Data/VN-EN Dict.txt")).useDelimiter("\\s*:\\s*");
        while (sc.hasNext()) {
            String vn = sc.next();
            String en = sc.nextLine();
            en = en.substring(3);
            dictionary.dictArr.add(new Word(en, vn));
        }
        return dictionary;
    }

    public void dictionaryLookup(ArrayList<Word> arr) { // nham sang Func Searcher
        Scanner sc = new Scanner(System.in);
        String findWord = sc.nextLine();
        for (Word element : arr) {
            if (element.getWord_target().equals(findWord)) {
                System.out.println(element.getWord_explain());
            }
        }

    }
    public void dictionaryExportToFile(Dictionary dictionary)
    {
        try
        {
            File file=new File("Data/VN-EN Dict.txt");
            FileWriter fw= new FileWriter(file);
            for(int i=0;i<dictionary.dictArr.size();i++)
            {
                fw.write(dictionary.dictArr.get(i).getWord_target()+" : "+dictionary.dictArr.get(i).getWord_explain()+"\n");
            }
            fw.close();
        }
        catch(Exception ex){
            System.out.println("Error: " +ex);
        }
    }
}
