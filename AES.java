import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Scanner;
public class RijndaelAES {
public static void main(String[] args) throws Exception {
Scanner sc = new Scanner(System.in);
// Read input from user
System.out.print("Enter Plain Text: ");
String plaintext = sc.nextLine();
// Generate AES key
KeyGenerator keyGen = KeyGenerator.getInstance("AES");
keyGen.init(128);
SecretKey key = keyGen.generateKey();
// Encryption
Cipher cipher = Cipher.getInstance("AES");
cipher.init(Cipher.ENCRYPT_MODE, key);
byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());
String encryptedText =
Base64.getEncoder().encodeToString(encryptedBytes);
// Decryption
cipher.init(Cipher.DECRYPT_MODE, key);
byte[] decryptedBytes =
cipher.doFinal(Base64.getDecoder().decode(encryptedText));
String decryptedText = new String(decryptedBytes);
// Output
System.out.println("\n--- Output ---");
System.out.println("Plain Text : " + plaintext);
System.out.println("Encrypted : " + encryptedText);
System.out.println("Decrypted : " + decryptedText);
sc.close();
}
}
