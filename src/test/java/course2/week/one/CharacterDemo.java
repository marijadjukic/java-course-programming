package course2.week.one;
import edu.duke.*;
import org.junit.Test;

public class CharacterDemo {
    @Test
    public void digitTest(){
        String test = "ABCabc0123456789';#!";
        for (int i = 0; i < test.length(); i++){
            char ch = test.charAt(i);
            if(Character.isDigit(ch)){
                System.out.println(ch + " is a digit");
            }
            if(Character.isAlphabetic(ch)){
                System.out.println(ch + " is alphabetic");
            }
            if(ch == '#'){
                System.out.println(ch + " hashtag");
            }

        }
    }
    @Test
    public void conversionTest(){
        String test = "ABCabc0123456789';#!";
        for (int i = 0; i < test.length(); i++){
            char ch = test.charAt(i);
            char uch = Character.toUpperCase(ch);
            char lch = Character.toLowerCase(ch);
            System.out.println(ch + " " + uch + " " + lch);
        }
    }
}
