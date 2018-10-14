package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
        System.out.println("Welcome to my dictionary program!!!");

//      dictionaryCommandline.dictionaryBasic();
        while (true){
            dictionaryCommandline.dictionaryAdvance();
            System.out.println("Do you want to exit     1.Yes :(     2.No =))) ");
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            if(i==1) {
                System.out.println("Goodbye");
                break;
            }
            if (i!=1 && i!=2) {
                System.out.println("Invalid.Program will be exit right now\nGoodbye");
                break;
            }

        }

    }
}
