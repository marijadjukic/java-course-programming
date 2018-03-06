package course2.week.one;

public class CaesarBreaker {
    public int[] countLetters(String message){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int i = 0; i<message.length(); i++){
            char ch = Character.toLowerCase(message.charAt(i));
            int dex = alph.indexOf(ch);
            if (dex!=-1){
                counts[dex]++;
            }
        }
        return counts;
    }

    public int maxIndex(int[] vals){
        int maxDex = 0;
        for(int i = 0; i<vals.length; i++){
            if(vals[i]>vals[maxDex]){
                maxDex = i;
            }
        }
        return maxDex;
    }

    public String decrypt(String encrypted){
        CaesarCipher cc = new CaesarCipher();
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dKey = maxDex - 4;
        if (maxDex<4){
            dKey = 26 - (4-maxDex);
        }
        return cc.encrypt(encrypted, 26 - dKey);
    }

    public String halfOfString(String message, int start){
        StringBuilder newMessage = new StringBuilder();
        for(int i = start; i<message.length(); i+=2){
            char ch = message.charAt(i);
            newMessage.append(message.charAt(i));
        }
        return newMessage.toString();
    }
    public int getKey(String s){
        int[] freqs = countLetters(s);
        int maxDex = maxIndex(freqs);
        int key = maxDex - 4;
        if(maxDex<4){
            key = 26 - (4-maxDex);
        }
        return key;
    }
    public String decryptTwoKeys(String encrypted){
        CaesarCipher cc = new CaesarCipher();
        int key1 = getKey(halfOfString(encrypted,0));
        int key2 = getKey(halfOfString(encrypted,1));
        System.out.println(key1 + ", " + key2);
        return cc.encryptTwoKeys(encrypted,26-key1, 26-key2);
    }
}
