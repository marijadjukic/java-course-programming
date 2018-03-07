package course2.week.four;
import edu.duke.*;
import org.junit.Test;

import java.util.*;

public class TestVigenereBreaker {
    @Test
    public void testSliceString(){
        VigenereBreaker vb = new VigenereBreaker();
        System.out.println(vb.sliceString("abcdefghijklm",0,3));
        System.out.println(vb.sliceString("abcdefghijklm",1,3));
        System.out.println(vb.sliceString("abcdefghijklm",2,3));

        System.out.println(vb.sliceString("abcdefghijklm",0,4));
        System.out.println(vb.sliceString("abcdefghijklm",1,4));
        System.out.println(vb.sliceString("abcdefghijklm",2,4));
        System.out.println(vb.sliceString("abcdefghijklm",3,4));

        System.out.println(vb.sliceString("abcdefghijklm",0,5));
        System.out.println(vb.sliceString("abcdefghijklm",1,5));
        System.out.println(vb.sliceString("abcdefghijklm",2,5));
        System.out.println(vb.sliceString("abcdefghijklm",3,5));
        System.out.println(vb.sliceString("abcdefghijklm",4,5));
    }
    @Test
    public void testTryKeyLength(){
        VigenereBreaker vb = new VigenereBreaker();
        FileResource fr = new FileResource("vigenere/secretmessage1.txt");
        String encrypted = fr.asString();
        int[] key = vb.tryKeyLength(encrypted,4,'e');
        System.out.println(Arrays.toString(key));
    }
    @Test
    public void testBreakVigenere(){
        VigenereBreaker vb = new VigenereBreaker();
        vb.breakVigenere();
    }
    @Test
    public void testReadDictionary(){
        VigenereBreaker vb = new VigenereBreaker();
        FileResource fr = new FileResource("dictionaries/English");
        System.out.println(vb.readDictionary(fr));
    }
    @Test
    public void testCountWords(){
        VigenereBreaker vb = new VigenereBreaker();
        FileResource fr = new FileResource("vigenere/athens.txt");
        FileResource dict = new FileResource("dictionaries/English");
        String message = fr.asString();
        HashSet<String> dictionary = vb.readDictionary(dict);
        System.out.println(vb.countWords(message,dictionary));
    }
    @Test
    public void testBreakVigenereUnknownKeyLength(){
        VigenereBreaker vb = new VigenereBreaker();
        vb.breakVigenereUnknownKeyLength();
    }
}
