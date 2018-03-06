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
}
