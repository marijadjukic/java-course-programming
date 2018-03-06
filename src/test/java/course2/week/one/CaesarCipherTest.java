package course2.week.one;
import edu.duke.*;
import org.junit.Test;


public class CaesarCipherTest {
    @Test
    public void testEncrypt(){
        CaesarCipher cc = new CaesarCipher();
        int key = 17;
        //FileResource fr = new FileResource();
        //String message = fr.asString();
        //String encrypted = cc.encrypt(message, key);
        //System.out.println("key is " + key + "\n" + encrypted);
        //System.out.println(message);
        System.out.println(cc.encrypt("First Legion", 23));
        System.out.println(cc.encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 15));
        System.out.println(cc.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?", 15));
        //String decrypted = cc.encrypt(encrypted, 26 - key);
        //System.out.println(decrypted);
    }
    @Test
    public void testEncryptTwoKeys(){
        CaesarCipher cc = new CaesarCipher();
        System.out.println(cc.encryptTwoKeys("Can you imagine life WITHOUT the internet AND computers in your pocket?", 21,8));
        System.out.println(cc.encryptTwoKeys("Hfs cpwewloj loks cd Hoto kyg Cyy.",12,2));
    }
}
