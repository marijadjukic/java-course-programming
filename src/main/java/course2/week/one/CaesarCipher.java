package course2.week.one;

public class CaesarCipher {
    public String encrypt(String input, int key){
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
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

    public String encryptTwoKeys(String input, int key1, int key2){
        String input1 = encrypt(input, key1);
        String input2 = encrypt(input, key2);
        StringBuilder encrypted2 = new StringBuilder(input);
        for (int i = 0; i<encrypted2.length(); i++){
            if (i % 2 == 0){
                char newChar1 = input1.charAt(i);
                encrypted2.setCharAt(i, newChar1);
            } else {
                char newChar2 = input2.charAt(i);
                encrypted2.setCharAt(i, newChar2);
            }
        }
        return encrypted2.toString();
    }
}
