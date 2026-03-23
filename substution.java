import java.util.*;

public class SubstitutionCipher {

    // Encryption
    public static String encrypt(String text, String key) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        text = text.toLowerCase();
        String cipher = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                int index = alphabet.indexOf(ch);
                cipher += key.charAt(index);
            } else {
                cipher += ch;
            }
        }
        return cipher;
    }

    // Decryption
    public static String decrypt(String cipher, String key) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String text = "";

        for (int i = 0; i < cipher.length(); i++) {
            char ch = cipher.charAt(i);

            if (Character.isLetter(ch)) {
                int index = key.indexOf(ch);
                text += alphabet.charAt(index);
            } else {
                text += ch;
            }
        }
        return text;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Example substitution key (must be 26 unique letters)
        String key = "qwertyuiopasdfghjklzxcvbnm";

        System.out.print("Enter Plain Text: ");
        String plaintext = sc.nextLine();

        String cipher = encrypt(plaintext, key);
        System.out.println("Encrypted Text: " + cipher);

        String decrypted = decrypt(cipher, key);
        System.out.println("Decrypted Text: " + decrypted);
    }
}
