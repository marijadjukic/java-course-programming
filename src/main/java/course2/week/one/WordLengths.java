package course2.week.one;

import edu.duke.FileResource;

public class WordLengths {

    public void countWordLengths(FileResource resource, int[] counts){
        int maxLength = 0;
        for(String word : resource.words()){
            int length = word.length();
            if(word.endsWith(",")==true){
                counts[length-1]++;
            } else if (word.endsWith(".")==true) {
                counts[length-1]++;
            } else {
                counts[length]++;
            }
            maxLength = Math.max(maxLength,length);
            if(length >= counts.length){
                counts[maxLength]++;
            }

        }

        for(int i = 1; i<=maxLength; i++){
            if(counts[i]!=0 && counts[i]==1){
                System.out.println(counts[i] + " word of length " + i);
            } else if(counts[i]!=0){
                System.out.println(counts[i] + " words of length " + i);
            }
        }
    }

    public int indexOfMax(int[] values){
        int maxDex = 0;
        for(int i = 0; i<values.length; i++){
            if(values[i]>values[maxDex]){
                maxDex = i;
            }
        }
        return maxDex;
    }
}
