package course2.week.two;
import edu.duke.*;
import org.junit.Test;

import java.io.File;
import java.util.*;

public class WordsInFiles {
    private HashMap<String,ArrayList<String>> mapWord;

    public WordsInFiles(){
        mapWord = new HashMap<String, ArrayList<String>>();
    }

    private void addWordsFromFile(File f){
        String fileName = f.getName();
        FileResource fr = new FileResource(f);
        for(String word : fr.words()){
            if (!mapWord.containsKey(word)){
                ArrayList<String> newList = new ArrayList<String>();
                newList.add(fileName);
                mapWord.put(word,newList);
            }
            else {
                String currFileName = f.getName();
                ArrayList<String> list = mapWord.get(word);
                if(!list.contains(currFileName))
                    list.add(currFileName);
                    mapWord.put(word,list);
            }
        }
    }
    public void buildWordFileMap(){
        mapWord.clear();
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            addWordsFromFile(f);
        }
    }

    public int maxNumber(){
        int maxNumber = 0;
        for(ArrayList<String> values : mapWord.values()){
            int length = values.size();
            if (length>maxNumber){
                maxNumber=length;
            }
        }
        return maxNumber;
    }

    public ArrayList<String> wordsInNumFiles(int number){
        ArrayList<String> words = new ArrayList<String>();
        for(String word : mapWord.keySet()){
            ArrayList<String> values = mapWord.get(word);
            if(values.size()==number){
                words.add(word);
            }
        }
        System.out.println("There are " + words.size() + " words that appears in " + number + " files.");
        return words;
    }
    public void printFilesIn(String word){
        ArrayList<String> files = mapWord.get(word);
        for(int i=0; i<files.size(); i++){
            System.out.println(files.get(i));
        }
    }

    @Test
    public void tester(){
        buildWordFileMap();
        for(String word : mapWord.keySet()){
            System.out.println(word + "\t" + mapWord.get(word));
        }
        System.out.println("Words that occur in files: " + mapWord.size());
        int maxNumber = maxNumber();
        ArrayList<String> words = wordsInNumFiles(maxNumber);
        System.out.println("The greatest number of files a word appears in is " + maxNumber + ", and there are two such words: " + words);
        System.out.println(wordsInNumFiles(4));
        printFilesIn("sea");
    }
}
