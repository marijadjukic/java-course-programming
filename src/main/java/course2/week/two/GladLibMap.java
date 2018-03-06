package course2.week.two;
import edu.duke.*;

import java.util.*;

public class GladLibMap {
    private HashMap<String, ArrayList<String>> myMap;

    private ArrayList<String> usedWords;
    private Random myRandom;

    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";

    public GladLibMap(){
        myMap = new HashMap<String, ArrayList<String>>();
        myRandom = new Random();
        usedWords = new ArrayList<String>();
        initializeFromSource(dataSourceDirectory);
    }

    /*public GladLibMap(String source){
        initializeFromSource(source);
        myRandom = new Random();
        myMap = new HashMap<String, ArrayList<String>>();
    }*/

    private void initializeFromSource(String source) {
        String[] labels = {"country", "noun", "animal", "adjective", "name", "color", "verb", "timeframe", "fruit"};
        for(String s : labels){
            ArrayList<String> list = readIt(source + "/" + s + ".txt");
            myMap.put(s,list);
        }
    }

    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }

    private String getSubstitute(String label) {
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        } else {
            return randomFrom(myMap.get(label));
        }
    }

    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub;
        while(true){
            sub = getSubstitute(w.substring(first+1,last));
            if (!usedWords.contains(sub)) {
                usedWords.add(sub);
                break;
            }
        }

        return prefix+sub+suffix;
    }

    public void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }

    public String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }

    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }
    public int totalWordsInMap(){
        int totalWords = 0;
        for(ArrayList<String> values : myMap.values()){
            int arrayListSize = values.size();
            totalWords = totalWords + arrayListSize;
        }
        return totalWords;
    }

    public int totalWordsConsidered(){
        return usedWords.size();
    }

    public void clear(){
        myMap.clear();
        usedWords.clear();
    }
    public ArrayList<String> getUsedWords(){
        return usedWords;
    }
}
