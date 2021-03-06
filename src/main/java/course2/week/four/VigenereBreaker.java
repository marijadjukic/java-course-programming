package course2.week.four;
import edu.duke.*;

import java.io.*;
import java.util.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder slice = new StringBuilder();
        for(int i = whichSlice; i<message.length(); i+=totalSlices){
            char c = message.charAt(i);
            slice.append(c);
        }
        return slice.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCracker cc = new CaesarCracker();
        for(int i = 0; i<klength;i++){
            int keys = cc.getKey(sliceString(encrypted,i,klength));
            key[i]=keys;
        }
        return key;
    }

    public void breakVigenere () {
        FileResource fr = new FileResource();
        String input = fr.asString();
        int[] key = tryKeyLength(input,4,'e');
        VigenereCipher vc = new VigenereCipher(key);
        System.out.println(vc.decrypt(input));
    }

    public HashSet<String> readDictionary(FileResource fr){
        HashSet<String> dictionary = new HashSet<String>();
        for(String line : fr.lines()){
            String word = line.toLowerCase();
            dictionary.add(word);
        }
        return dictionary;
    }

    public int countWords(String message, HashSet<String> dictionary){
        int count = 0;
        String[] output = message.split("\\W+");
        for(int i = 0; i<output.length; i++){
            String word = output[i].toLowerCase();
            if(dictionary.contains(word)){
                count++;
            }
        }
        return count;
    }

    public String breakForLanguage(String encrypted, HashSet<String> dictionary){
        int maxCount = 0;
        String answer = null;
        int[] rightKey = new int[100];
        char mostCommonLetter = mostCommonCharIn(dictionary);
        for (int i = 1; i<100; i++) {
            int[] key = tryKeyLength(encrypted, i, mostCommonLetter);
            VigenereCipher vc = new VigenereCipher(key);
            String decrypt = vc.decrypt(encrypted);
            int count = countWords(decrypt, dictionary);
            if (count > maxCount) {
                maxCount = count;
                rightKey = key;
                answer = decrypt;
            }
        }
        System.out.println("Right key is " + Arrays.toString(rightKey) + " with length " + rightKey.length);
        System.out.println("There are " + maxCount + " valid words.");
        return answer;
    }

    public void breakVigenereUnknownKeyLength(){
        FileResource fr = new FileResource();
        String input = fr.asString();
        FileResource dict = new FileResource("dictionaries/English");
        HashSet<String> dictionary = readDictionary(dict);
        String decrypted = breakForLanguage(input,dictionary);
        System.out.println(decrypted);

    }

    public char mostCommonCharIn(HashSet<String> dictionary){
        HashMap<Character, Integer> mapCountChar = new HashMap<Character, Integer>();
        int maxValue = 0;
        char mostCommonChar = ' ';
        for(String word : dictionary){
            for(int i = 0; i<word.length();i++){
                char c = word.charAt(i);
                if(!mapCountChar.containsKey(c)){
                    mapCountChar.put(c,1);
                }
                else{
                    mapCountChar.put(c,mapCountChar.get(c)+1);
                }
            }
        }
        for(char letter : mapCountChar.keySet()){
            int value = mapCountChar.get(letter);
            if(value > maxValue){
                maxValue = value;
                mostCommonChar = letter;
            }
        }
        return mostCommonChar;
    }

    public String breakForAllLangs(String encrypted,HashMap<String, HashSet<String>> languages){
        int maxCount = 0;
        String answer = null;
        String rightLanguage = null;
        for(String language : languages.keySet()){
            System.out.println(language);
            HashSet<String> dictionary = languages.get(language);
            String decrypt = breakForLanguage(encrypted,dictionary);
            int count = countWords(decrypt,dictionary);
            if(count > maxCount){
                maxCount = count;
                rightLanguage = language;
                answer = decrypt;
            }
        }
        System.out.println("Right language is " + rightLanguage);
        return answer;
    }

    public void breakVigenereUnkownLanguage(){
        HashMap<String, HashSet<String>> languages = new HashMap<String, HashSet<String>>();
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            String fileName = f.getName();
            FileResource fr = new FileResource(f);
            HashSet<String> dictionary = readDictionary(fr);
            languages.put(fileName,dictionary);
        }
        FileResource fr = new FileResource("vigenere/secretmessage4.txt");
        String input = fr.asString();
        System.out.println(breakForAllLangs(input,languages));
    }

}
