package course2.week.two;
import edu.duke.*;
import org.junit.Test;

import java.util.*;

public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;

    public WordFrequencies(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }

    public void findUnique(){
        myWords.clear();
        myFreqs.clear();
        FileResource resource = new FileResource();
        for (String s : resource.words()){
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if (index == -1){
                myWords.add(s);
                myFreqs.add(1);
            } else {
                int value = myFreqs.get(index);
                myFreqs.set(index, value+1);
            }
        }
    }

    public int findIndexOfMax(){
        int indexOfMax = myFreqs.indexOf(1);
        for(int i=0; i<myFreqs.size();i++){
            if(myFreqs.get(i)>myFreqs.get(indexOfMax)){
                indexOfMax = i;
            }
        }
        return indexOfMax;
    }

    @Test
    public void tester(){
        findUnique();
        int indexOfMax = findIndexOfMax();
        System.out.println("# unique words " + myWords.size());
        for(int i = 0; i < myWords.size(); i++){
            System.out.println(myFreqs.get(i) + "\t" + myWords.get(i));
        }
        System.out.println("The word that occurs most often and its count are: " + myWords.get(indexOfMax) + "\t" + myFreqs.get(indexOfMax));
    }
}
