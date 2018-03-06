package course2.week.one;

public class CaesarCipher1 {
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;

    public CaesarCipher1(int key){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        mainKey = key;
    }

    public String encrypt(String input){
        StringBuilder encrypted = new StringBuilder(input);
        String encryptedUpper = input.toUpperCase();
        for(int i = 0; i < encrypted.length(); i++){
            char currChar = encryptedUpper.charAt(i);
            int idx = alphabet.indexOf(currChar);
            if(idx != -1){
                char newChar = shiftedAlphabet.charAt(idx);
                char newCharLower = Character.toLowerCase(newChar);
                if(input.charAt(i) == input.toLowerCase().charAt(i)){
                    encrypted.setCharAt(i, newCharLower);
                } else {
                    encrypted.setCharAt(i, newChar);
                }
            }
        }
        return encrypted.toString();
    }

    public String decrypt(String input){
        CaesarCipher1 cc1 = new CaesarCipher1(26 - mainKey);
        String decrypted = cc1.encrypt(input);
        return decrypted;
    }
}
