import javax.crypto.*;
import java.util.*;

public class DESExample {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        KeyGenerator kg = KeyGenerator.getInstance("DES");
        SecretKey key = kg.generateKey();

        Cipher c = Cipher.getInstance("DES");
        c.init(Cipher.ENCRYPT_MODE, key);

        byte[] enc = c.doFinal(text.getBytes());
        System.out.println("Encrypted: " + new String(enc));

        c.init(Cipher.DECRYPT_MODE, key);
        byte[] dec = c.doFinal(enc);
        System.out.println("Decrypted: " + new String(dec));
    }
}
