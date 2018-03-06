package course2.week.two;

import edu.duke.*;
import org.junit.Test;

import java.util.*;

public class CodonCount {
    private HashMap<String,Integer> mapDNA;

    public CodonCount(){
        mapDNA = new HashMap<String, Integer>();
    }

    public void  buildCodonMap(String dna, int start){
        mapDNA.clear();
        for (int i = start; i < dna.length()-3; i+=3) {
            String codon = dna.substring(i, i + 3);
            if (!mapDNA.containsKey(codon)) {
                mapDNA.put(codon, 1);
            } else {
                mapDNA.put(codon, mapDNA.get(codon) + 1);
            }
        }
    }

    public String getMostCommonCodon(){
        String mostComonCodon="";
        int value = 0;
        for(String codon : mapDNA.keySet()){
            int currValue = mapDNA.get(codon);
            if(currValue>value){
                value = currValue;
                mostComonCodon = codon;
            }
        }
        return mostComonCodon;
    }

    public void printCodonCounts(int start, int end){
        System.out.println("Counts of codons between " + start + " and " + end + " inclusive are ");
        for(String codon : mapDNA.keySet()){
            if (mapDNA.get(codon)>=start && mapDNA.get(codon)<=end){
                System.out.println(codon + "\t" + mapDNA.get(codon));
            }
        }
    }

    @Test
    public void tester(){
        FileResource fr = new FileResource();
        buildCodonMap(fr.asString().toUpperCase(),0);
        for (String codon : mapDNA.keySet()){
            int value = mapDNA.get(codon);
            System.out.println(codon + "\t" + value);
        }
        System.out.println("Number of unique codons is: " + mapDNA.size());
        String mostComonCodon = getMostCommonCodon();
        System.out.println("The most comon codon is: " + mostComonCodon + " with count " + mapDNA.get(mostComonCodon));
        printCodonCounts(6, 7);
    }
}
