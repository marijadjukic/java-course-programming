package stringThirdAssignments;

import edu.duke.*;

/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    
    public double cgRatio(String dna){
        double length = dna.length();
        double count = 0.0;
        int startIndex = 0;
        for (startIndex = 0; startIndex < length; startIndex++){
            if(dna.charAt(startIndex) == 'C' || dna.charAt(startIndex) == 'G'){
                count++;
            }
        }
        double ratio = count/length;
        return ratio;
    }

    public int countCTG(String dna){
        int count = 0;
        int startIndex = dna.indexOf("CTG");
        while(startIndex < dna.length() && startIndex != -1) {
            startIndex = dna.indexOf("CTG",startIndex + 3);
            count++;
        }
        return count;
    }
    
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1){
            if((currIndex - startIndex) % 3 == 0){
                return currIndex;
            } else {
                currIndex = dna.indexOf(stopCodon, currIndex + 1);
            }
        }
        return dna.length(); // or return -1
    }
    
    public String findGene(String dna, int where){
        int startIndex = dna.indexOf("ATG", where);
        if (startIndex == -1){
            return "";
        }
        int indexTAA = findStopCodon(dna, startIndex, "TAA");
        int indexTAG = findStopCodon(dna, startIndex, "TAG");
        int indexTGA = findStopCodon(dna, startIndex, "TGA");
        int minIndex = Math.min(Math.min(indexTAA, indexTAG), indexTGA);
        // int minIndex = 0;
        // if(indexTAA == -1 || (indexTGA != -1 && indexTGA < indexTAA)){
        //     minIndex = indexTGA;
        // } else {
        //     minIndex = indexTAA;
        // }
        // if(minIndex == -1 || (indexTAG != -1 && indexTAG < minIndex)){
        //     minIndex = indexTAG;
        // }
        // if(minIndex == -1){
        //     return "";
        // }
        
        if (minIndex == dna.length()){
            return "";
        }
        return dna.substring(startIndex, minIndex + 3);
    }
    
    public StorageResource getAllGenes(String dna){
        StorageResource geneList = new StorageResource();
        int startIndex = 0;
        while (true){
            String currentGene = findGene(dna, startIndex);
            if (currentGene.isEmpty()){
                break;
            }
            geneList.add(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
        return geneList;
    }
    
    public void processGenes(StorageResource sr){
        int count1 = 0;
        int count2 = 0;
        int max = 0;
        for(String s : sr.data()){
            if (s.length() > 60){
                System.out.println("String with length grater than 60: " + s);
                count1++;
            }
            if (cgRatio(s) > 0.35){
                System.out.println("String with ratio grater than 0.35: " + s);
                count2++;
            }
            if(s.length() > max) {
                max = s.length();
            }
        }
        System.out.println("There are " + count1 + " strings with length > 60");
        System.out.println("There are " + count2 + " strings with ratio > 0.35");
        System.out.println("Length of longest gene is: " + max);
    }
    
}
