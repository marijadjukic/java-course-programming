package course2.week.one;

import edu.duke.FileResource;
import org.junit.Test;

public class TestCaesarCipherTwo {

    private String halfOfString(String message, int start){
        StringBuilder newMessage = new StringBuilder();
        for(int i = start; i<message.length(); i+=2){
            char ch = message.charAt(i);
            newMessage.append(message.charAt(i));
        }
        return newMessage.toString();
    }

    public int[] countLetters(String message){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int i = 0; i<message.length(); i++){
            char ch = Character.toLowerCase(message.charAt(i));
            int dex = alph.indexOf(ch);
            if (dex!=-1){
                counts[dex]++;
            }
        }
        return counts;
    }

    public int maxIndex(int[] vals){
        int maxDex = 0;
        for(int i = 0; i<vals.length; i++){
            if(vals[i]>vals[maxDex]){
                maxDex = i;
            }
        }
        return maxDex;
    }
    @Test
    public void simpleTests(){
        FileResource fr = new FileResource();
        String file = fr.asString();
        //CaesarCipherTwo cc2 = new CaesarCipherTwo(17,3);
        //String encrypted = cc2.encrypt(file);
        //String decrypted = cc2.decrypt(encrypted);
        //System.out.println(encrypted);
        //System.out.println(decrypted);
        System.out.println(breakCaesarCipher(file));
    }

    public int getKey(String s){
        int[] freqs = countLetters(s);
        int maxDex = maxIndex(freqs);
        int key = maxDex - 4;
        if(maxDex<4){
            key = 26 - (4-maxDex);
        }
        return key;
    }

    public String breakCaesarCipher(String input){
        int key1 = getKey(halfOfString(input,0));
        int key2 = getKey(halfOfString(input,1));
        System.out.println(key1 + ", " + key2);
        CaesarCipherTwo cc2 = new CaesarCipherTwo(key1,key2);
        return cc2.decrypt(input);
    }
}
