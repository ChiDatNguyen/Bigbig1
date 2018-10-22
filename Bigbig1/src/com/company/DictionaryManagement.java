package com.company;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class DictionaryManagement {

    public Dictionary insertFromCommandline(Dictionary dictionary) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many words do you want to insert");
        int num = sc.nextInt();
        sc.nextLine();
        for (int i=0; i<num; i++){
            System.out.println("insert English word "+ (i+1) );
            String en = sc.nextLine();
            System.out.println("insert Vietnamese word "+ (i+1));
            String vn = sc.nextLine();
            en = en.toLowerCase();
            vn = vn.toLowerCase();
            dictionary.dictArr.add(new Word(en, vn));
            System.out.println("added");
        }

        return dictionary;
    }

    public Dictionary insertFromFile(Dictionary dictionary) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("Data/VN-EN Dict.txt")).useDelimiter("\\s*:\\s*");

        while (sc.hasNext()) {
            String vn = sc.next();
            String en = sc.nextLine();
            en = en.substring(3);
            vn = vn.toLowerCase();
            en = en.toLowerCase();
            dictionary.dictArr.add(new Word(en, vn));
        }
       // sc.close();
        Collections.sort(dictionary.dictArr, new Word());
        return dictionary;
    }

    public void dictionaryLookup(ArrayList<Word> arr) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("insert the word you want to know its meaning");
//        String findWord = sc.nextLine();
//        for (Word element : arr) {
//            if (element.getWord_target().equals(findWord)) {
//                System.out.println(element.getWord_explain());
//                return;
//            }
//
//        }
//        System.out.println("Can not find this word");
        //sc.close();
        Scanner sc = new Scanner(System.in);
        System.out.println("insert the word you want to know its meaning");
        String findWord = sc.nextLine();
        int stIndex = 0;
        int endIndex = arr.size();
        int index = (stIndex + endIndex)/2;
        while ((index != stIndex && index != endIndex)){
            if (arr.get(index).getWord_target().compareTo(findWord) > 0){
                endIndex = index;
                index = (stIndex + endIndex)/2;
            }
            else {
                stIndex = index;
                index = (stIndex + endIndex)/2;
            }
        }
        if( !findWord.equalsIgnoreCase(arr.get(index).getWord_target()))
            System.out.println("Can not find this word");
        else
            System.out.println(arr.get(index).getWord_explain());
    }
    public void dictionaryExportToFile(Dictionary dictionary)
    {
        try
        {
            File file=new File("Data/VN-EN Dict.txt");
            FileWriter fw= new FileWriter(file);

            for(int i=0;i<dictionary.dictArr.size();i++)
            {
                fw.write(dictionary.dictArr.get(i).getWord_explain()+" : "+dictionary.dictArr.get(i).getWord_target()+"\n");
            }
            fw.close();
        }
        catch(Exception ex){
            System.out.println("Error: " +ex);
        }
    }
    public void deleteWord (Dictionary dictionary){
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("insert the word you want to delete in English");
            String word = sc.nextLine();
            for(Word element : dictionary.dictArr){
                if (element.getWord_target().equals(word)) {
                    dictionary.dictArr.remove(dictionary.dictArr.indexOf(element));

                }
            }
        }
        catch (Exception ex){
            System.out.println("removed");;
        }
        //sc.close();
    }
}
