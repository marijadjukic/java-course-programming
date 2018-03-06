package course2.week.one;

public class CaesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainKey1;
    private int mainKey2;

    public CaesarCipherTwo(int key1, int key2){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        mainKey1 = key1;
        mainKey2 = key2;
    }

    public String encrypt(String input){
        StringBuilder encrypted2 = new StringBuilder(input);
        for (int i = 0; i<encrypted2.length(); i++){
            if (i % 2 == 0){
                CaesarCipher1 cc1 = new CaesarCipher1(mainKey1);
                char newChar1 = cc1.encrypt(input).charAt(i);
                encrypted2.setCharAt(i, newChar1);
            } else {
                CaesarCipher1 cc1 = new CaesarCipher1(mainKey2);
                char newChar2 = cc1.encrypt(input).charAt(i);
                encrypted2.setCharAt(i, newChar2);
            }
        }
        return encrypted2.toString();
    }

    public String decrypt(String input){
        CaesarCipherTwo cc2 = new CaesarCipherTwo(26 - mainKey1,26-mainKey2);
        String decrypted = cc2.encrypt(input);
        return decrypted;
    }

}
