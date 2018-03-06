package course2.week.one;
import edu.duke.*;

public class WordPlay {
    public boolean isVowel(char ch){
        String vowel = "AEIOU";
        boolean result = false;
        for (int i = 0; i < vowel.length(); i++){
            char currChar = vowel.charAt(i);
            if(currChar == Character.toUpperCase(ch)){
                result = true;
            }
        }
        return result;
    }

    public String replaceVowels(String phrase, char ch){
        StringBuilder newPhrase = new StringBuilder(phrase);
        for(int i=0; i < phrase.length();i++){
            char currChar = phrase.charAt(i);
            boolean vowel = isVowel(currChar);
            int idx = phrase.indexOf(currChar);
            if(idx != -1 && vowel==true){
                newPhrase.setCharAt(i, ch);
            }
        }
        return newPhrase.toString();
    }

    public String emphasize(String phrase, char ch){
        StringBuilder newPhrase = new StringBuilder(phrase);
        for(int i=0; i<phrase.length(); i++){
            char currChar = phrase.charAt(i);

            if (currChar == ch || currChar == Character.toUpperCase(ch)){
                if(i % 2 == 0){
                    newPhrase.setCharAt(i,'*');
                } else {
                    newPhrase.setCharAt(i,'+');
                }
            }
        }
        return newPhrase.toString();
    }
}
