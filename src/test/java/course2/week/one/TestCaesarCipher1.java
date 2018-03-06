package course2.week.one;

import edu.duke.FileResource;
import org.junit.Test;

public class TestCaesarCipher1 {
    private int[] countLetters(String message){
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
        CaesarCipher1 cc1 = new CaesarCipher1(18);
        String encrypted = cc1.encrypt(file);
        //String decrypted = cc1.decrypt(encrypted);
        System.out.println(encrypted);
        System.out.println(breakCaesarCipher(encrypted));
    }

    public String breakCaesarCipher(String input){
        int[] freqs = countLetters(input);
        int maxDex = maxIndex(freqs);
        int dKey = maxDex - 4;
        if (maxDex<4){
            dKey = 26 - (4-maxDex);
        }
        CaesarCipher1 cc1 = new CaesarCipher1(dKey);
        return cc1.decrypt(input);
    }

}
