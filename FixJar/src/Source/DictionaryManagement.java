package Source;


import java.io.*;
import java.util.ArrayList;
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

        /*Scanner sc = new Scanner(new File("src\\Source\\data\\VN-ENDict.txt")).useDelimiter("\\s*:\\s*");

        while (sc.hasNext()) {
            String vn = sc.next();
            String en = sc.nextLine();
            en = en.substring(3);
            vn = vn.toLowerCase();
            en = en.toLowerCase();
            dictionary.dictArr.add(new Word(en, vn));
        }

        Collections.sort(dictionary.dictArr, new Word());
        return dictionary;*/

        /*FileReader reader = new FileReader("E:\\IntelliJ IDEA\\IdeaProjects\\FixJar\\src\\Source\\VN-ENDict.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        try {
            String string = bufferedReader.readLine();
            while (string != null)
            {
                int i = string.lastIndexOf(58);
                String vn = string.substring(0,i).trim().toLowerCase();
                String en = string.substring(i).trim().toLowerCase();
                dictionary.dictArr.add(new Word(en,vn));
            }
            reader.close();
            bufferedReader.close();
            return dictionary;
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(dictionary.dictArr, new Word());
        return null;
    }*/
        try {
            InputStream inputStream = this.getClass().getResourceAsStream("\\data\\VN-ENDict.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            try (BufferedReader br = new BufferedReader(inputStreamReader)) {
                String lineData=br.readLine();                                      //lay du lieu cua mot tu
                while (lineData!=null){
                    String[] elements;
                    elements = lineData.split("::");                                        //tach du lieu goc thanh tu tieng anh va nghia tieng viet
//                    word newWord;                      //tao tu moi
//                    newWord = new word(elements[0],elements[1]);
//                    Dictionary.arrayWord.add(newWord);                                  //them tu moi vao mang luu tru
                   // dictionary.dictArr.add(new Word(elements[1],elements[0]));
                    Word newWord = new Word();
                    newWord.setWord_target(elements[0]);
                    newWord.setWord_explain(elements[1]);

                    dictionary.dictArr.add(newWord);
                    lineData=br.readLine();
                }
            }
        } catch (IOException e) {                                     //bao loi neu khong tim thay file
            System.out.println("Error");
        }
        Collections.sort(dictionary.dictArr, new Word());
        return dictionary;
    }
    public void dictionaryLookup(ArrayList<Word> arr) {

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
            File file=new File("\\data\\VN-ENDict.txt");
            FileWriter fw= new FileWriter(file);

            for(int i=0;i<dictionary.dictArr.size();i++)
            {
                fw.write(dictionary.dictArr.get(i).getWord_target()+"::"+dictionary.dictArr.get(i).getWord_explain()+"\n");
            }
            fw.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
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
            System.out.println("removed");
        }
    }
    public void fixWord (Dictionary dictionary){
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("insert the word you want to fix in English");
            String word = sc.nextLine();
            int stIndex = 0;
            int endIndex = dictionary.dictArr.size();
            int index = (stIndex + endIndex)/2;
            while ((index != stIndex && index != endIndex)){
                if (dictionary.dictArr.get(index).getWord_target().compareTo(word) > 0){
                    endIndex = index;
                    index = (stIndex + endIndex)/2;
                }
                else {
                    stIndex = index;
                    index = (stIndex + endIndex)/2;
                }
            }
            if( !word.equalsIgnoreCase(dictionary.dictArr.get(index).getWord_target()))
                System.out.println("Can not find this word");
            else
            {
                System.out.println("Found!"+dictionary.dictArr.get(index).getWord_target()+"::"+dictionary.dictArr.get(index).getWord_explain());
                System.out.println("Fix the English word: " );
                String en = sc.nextLine();
                System.out.println("Fix the Vietnamese word: " );
                String vn = sc.nextLine();
                Word fixWord = new Word(en,vn);
                dictionary.dictArr.set(index,fixWord);

            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
