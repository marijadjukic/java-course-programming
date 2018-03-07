package course2.week.four;
import edu.duke.*;
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
        for (int i = 1; i<100; i++) {
            int[] key = tryKeyLength(encrypted, i, 'e');
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
}
