package course2.week.one;
import course2.week.four.CaesarCracker;
import edu.duke.*;
import org.junit.Test;

public class TestCaesarCracker {
    @Test
    public void testDecrypt(){
        CaesarCracker cc = new CaesarCracker();
        FileResource fr = new FileResource("vigenere/titus-small_key5.txt");
        String input = fr.asString();
        System.out.println(cc.decrypt(input));
    }
}
