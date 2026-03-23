import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
public class SHA1UserInput {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.print("Enter the text: ");
String input = scanner.nextLine();
try {
// Create SHA-1 MessageDigest instance
MessageDigest md = MessageDigest.getInstance("SHA-1");
// Convert input string to bytes
byte[] messageDigest = md.digest(input.getBytes());
// Convert byte array into hexadecimal format
StringBuilder sb = new StringBuilder();
for (byte b : messageDigest) {
sb.append(String.format("%02x", b));
}
// Display SHA-1 Hash
System.out.println("SHA-1 Message Digest: " + sb.toString());
} catch (NoSuchAlgorithmException e) {
System.out.println("SHA-1 Algorithm not found.");
}
scanner.close();
}
}
