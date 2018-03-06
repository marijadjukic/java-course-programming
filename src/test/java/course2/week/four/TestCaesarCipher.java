package course2.week.four;
import course2.week.four.CaesarCipher;
import edu.duke.*;
import org.junit.Test;

public class TestCaesarCipher {
    @Test
    public void testEncrypt(){
        CaesarCipher cc = new CaesarCipher(5);
        FileResource fr = new FileResource("vigenere/titus-small.txt");
        String input = fr.asString();
        System.out.println(cc.encrypt(input));
    }
}
