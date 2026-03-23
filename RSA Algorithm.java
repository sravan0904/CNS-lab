import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;
public class RSAUserInput {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
SecureRandom random = new SecureRandom();
// Generate two large prime numbers
BigInteger p = BigInteger.probablePrime(512, random);
BigInteger q = BigInteger.probablePrime(512, random);
// Compute n = p * q
BigInteger n = p.multiply(q);
// Compute phi(n)
BigInteger phi = p.subtract(BigInteger.ONE)
.multiply(q.subtract(BigInteger.ONE));
// Public key (commonly used value)
BigInteger e = BigInteger.valueOf(65537);
// Private key
BigInteger d = e.modInverse(phi);
// Take user input
System.out.print("Enter message to encrypt: ");
String message = sc.nextLine();
// Convert message to BigInteger
BigInteger messageInt = new BigInteger(message.getBytes());
// Encryption
BigInteger cipher = messageInt.modPow(e, n);
System.out.println("\nEncrypted Message: " + cipher);
// Decryption
BigInteger decrypted = cipher.modPow(d, n);
String decryptedMessage = new String(decrypted.toByteArray());
System.out.println("Decrypted Message: " + decryptedMessage);
sc.close();
}
}
