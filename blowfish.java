import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;
public class BlowfishExample {
public static void main(String[] args) throws Exception {
Scanner sc = new Scanner(System.in);
// Input
System.out.print("Enter Plain Text: ");
String plainText = sc.nextLine();
System.out.print("Enter Secret Key: ");
String keyText = sc.nextLine();
// Create Blowfish key
SecretKey secretKey = new
SecretKeySpec(keyText.getBytes(), "Blowfish");
// Create cipher
Cipher cipher = Cipher.getInstance("Blowfish");
// Encryption
cipher.init(Cipher.ENCRYPT_MODE, secretKey);
byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
String encryptedText =
Base64.getEncoder().encodeToString(encryptedBytes);
// Decryption
cipher.init(Cipher.DECRYPT_MODE, secretKey);
byte[] decryptedBytes =
cipher.doFinal(Base64.getDecoder().decode(encryptedText));
String decryptedText = new String(decryptedBytes);
// Output
System.out.println("\n----- BLOWFISH OUTPUT -----");
System.out.println("Plain Text : " + plainText);
System.out.println("Secret Key : " + keyText);
System.out.println("Encrypted Text : " + encryptedText);
System.out.println("Decrypted Text : " + decryptedText);
sc.close();
}
}
