package dic;

import java.io.FileNotFoundException;

import java.util.Scanner;

public class DictionaryCommandline {
    DictionaryManagement dictionaryManagement = new DictionaryManagement();
    Dictionary dictionary = new Dictionary();
    public void showAllWords()
    {
        System.out.printf("|%-7s|%-110s|%-50s|\n","No","English","Vietnamese");
        int no = 1;
        for (Word element: dictionary.dictArr){
            System.out.printf("|%-7d|%-110s|%-50s|\n", no,element.getWord_target(),element.getWord_explain());
            no++;
        }
    }
    public void dictionarySeacher (){

        Scanner sc = new Scanner(System.in);
        System.out.println("insert the string you want to know what are words start with");
        String findWord = sc.nextLine();
        for (Word element : dictionary.dictArr) {
            if (element.getWord_target().startsWith(findWord)) {
                System.out.println(element.getWord_target()+" : "+ element.getWord_explain());
            }
        }

    }
    public void dictionaryBasic() {
        try {
            dictionaryManagement.insertFromFile(dictionary);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("What do you want to do? Choose: ");
        System.out.println("1.Insert from commandline");
        System.out.println("2.Show all words of this dictionary");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        switch (num){
            case 1 :
                dictionaryManagement.insertFromCommandline(dictionary);
                dictionaryManagement.dictionaryExportToFile(dictionary);
                break;

            case 2 :
                showAllWords();
                break;
            default:
                System.out.println("Invalid");

        }
    }
    public void dictionaryAdvance() {
        try {
            dictionaryManagement.insertFromFile(dictionary);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("What do you want to do? Choose: ");
        System.out.println("1.Insert from commandline");
        System.out.println("2.Show all words of this dictionary");
        System.out.println("3.Delete word");
        System.out.println("4.Look up word");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        switch (num){
            case 1 :
                dictionaryManagement.insertFromCommandline(dictionary);
                dictionaryManagement.dictionaryExportToFile(dictionary);
                break;
            case 2 :
                showAllWords();
                break;
            case 3 :
                dictionaryManagement.deleteWord(dictionary);
                dictionaryManagement.dictionaryExportToFile(dictionary);
                break;
            case 4 :
                System.out.println(dictionaryManagement.dictionaryLookup(dictionary.dictArr));
                break;
            default:
                System.out.println("Invalid");
        }

    }
}
