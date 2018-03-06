package course2.week.one;

import edu.duke.FileResource;
import org.junit.Test;
import sun.security.tools.keytool.CertAndKeyGen;

public class CaeserBreakerTest {
    @Test
    public void testDecrypt(){
        CaesarBreaker cb = new CaesarBreaker();
        CaesarCipher cc = new CaesarCipher();
        String encrypted = cc.encrypt("Just a test string with lots of eeeeeeeeeeeeeeeees ",23);
        String decrypted = cb.decrypt(encrypted);
        System.out.println(encrypted);
        System.out.println(decrypted);

    }
    @Test
    public void testHalfOfString(){
        CaesarBreaker cb = new CaesarBreaker();
        String newMessage = cb.halfOfString("Qbkm Zgis",1);
        System.out.println(newMessage);
    }
    @Test
    public void testGetKey(){
        CaesarBreaker cb = new CaesarBreaker();
        int key = cb.getKey("Zkij q juij ijhydw myjx beji ev uuuuuuuuuuuuuuuuui");
        System.out.println(key);
    }
    @Test
    public void testDecryptTwoKeys(){
        FileResource fr = new FileResource();
        String file = fr.asString();
        CaesarBreaker cb = new CaesarBreaker();
        CaesarCipher cc = new CaesarCipher();
        //String encrypted = cc.encryptTwoKeys("Just a test string with lots of eeeeeeeeeeeeeeeees",23,2);
        String decrypted = cb.decryptTwoKeys(file);
        //System.out.println(encrypted);
        System.out.println(decrypted);
        //decrypted = cb.decryptTwoKeys("Akag tjw Xibhr awoa aoee xakex znxag xwko");
        //System.out.println(decrypted);
    }
}
