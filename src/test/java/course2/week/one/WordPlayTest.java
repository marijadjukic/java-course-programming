package course2.week.one;
import edu.duke.*;
import org.junit.Test;

public class WordPlayTest {
    @Test
    public void testIsVowel(){
        WordPlay wp = new WordPlay();
        boolean result = wp.isVowel('T');
        System.out.println(result);

    }
    @Test
    public void testReplaceVowels(){
        WordPlay wp = new WordPlay();
        String newPhrase = wp.replaceVowels("Hello World", '*');
        System.out.println(newPhrase);
    }
    @Test
    public void testEmphasize(){
        WordPlay wp = new WordPlay();
        String newPhrase = wp.emphasize("dna ctgaaactga", 'a');
        System.out.println(newPhrase);
        newPhrase = wp.emphasize("Mary Bella Abracadabra", 'a');
        System.out.println(newPhrase);
    }
}
