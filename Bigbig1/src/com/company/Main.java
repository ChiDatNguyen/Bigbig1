package com.company;


import java.util.ArrayList;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {


        DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();


//      dictionaryCommandline.dictionaryBasic();

        dictionaryCommandline.dictionaryAdvance();
        dictionaryCommandline.dictionarySeacher();
//        String s = "abcdefg";
//        System.out.println( s.charAt(1 ));

    }
}
///////////////////////////////////////////////////////////////////////////////
//public void Lookup(ArrayList<Word> arr) {
//    Scanner sc = new Scanner(System.in);
//    System.out.println("insert the word you want to know its meaning");
//    String findWord = sc.nextLine();
//    int stIndex = 0;
//    int endIndex = arr.size();
//    int index = (stIndex + endIndex)/2;
//    while (!findWord.equalsIgnoreCase(arr.get(index).getWord_target())){
//        if (arr.get(index).getWord_target().compareTo(findWord) > 0){
//            endIndex = index;
//            index = (stIndex + endIndex)/2;
//        }
//        else {
//            stIndex = index;
//            index = (stIndex + endIndex)/2;
//        }
//    }
//    if((index == stIndex || index == endIndex) && !findWord.equalsIgnoreCase(arr.get(index).getWord_target()))
//        System.out.println("Can not find this word");
//    else
//        System.out.println(arr.get(index).getWord_explain());
//
//}