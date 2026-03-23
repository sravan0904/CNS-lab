import java.util.Scanner;

public class HillCipherFull {

    // Multiply 2x2 matrix with 2x1 vector modulo 26
    public static int[] multiplyMatrix(int[][] key, int[] vector) {
        int[] result = new int[2];
        result[0] = (key[0][0] * vector[0] + key[0][1] * vector[1]) % 26;
        result[1] = (key[1][0] * vector[0] + key[1][1] * vector[1]) % 26;
        if (result[0] < 0) result[0] += 26;
        if (result[1] < 0) result[1] += 26;
        return result;
    }

    // Calculate determinant modulo 26
    public static int determinant(int[][] key) {
        return (key[0][0] * key[1][1] - key[0][1] * key[1][0] + 26) % 26;
    }

    // Modular multiplicative inverse of a modulo 26
    public static int modInverse(int a) {
        a = a % 26;
        for (int i = 1; i < 26; i++) {
            if ((a * i) % 26 == 1) return i;
        }
        throw new ArithmeticException("No modular inverse exists");
    }

    // Inverse of 2x2 key matrix modulo 26
    public static int[][] inverseKey(int[][] key) {
        int det = determinant(key);
        int detInv = modInverse(det);

        int[][] inv = new int[2][2];
        inv[0][0] = ( key[1][1] * detInv) % 26;
        inv[0][1] = (-key[0][1] * detInv + 26) % 26; // ensure positive
        inv[1][0] = (-key[1][0] * detInv + 26) % 26;
        inv[1][1] = ( key[0][0] * detInv) % 26;

        return inv;
    }

    // Encryption
    public static String encrypt(String plaintext, int[][] key) {
        plaintext = plaintext.toLowerCase().replaceAll("[^a-z]", "");
        if (plaintext.length() % 2 != 0) plaintext += "x"; // pad if odd

        StringBuilder cipher = new StringBuilder();

        for (int i = 0; i < plaintext.length(); i += 2) {
            int[] vector = { plaintext.charAt(i) - 'a', plaintext.charAt(i+1) - 'a' };
            int[] result = multiplyMatrix(key, vector);
            cipher.append((char)(result[0] + 'a'));
            cipher.append((char)(result[1] + 'a'));
        }

        return cipher.toString();
    }

    // Decryption
    public static String decrypt(String cipher, int[][] key) {
        int[][] invKey = inverseKey(key);
        StringBuilder plaintext = new StringBuilder();

        for (int i = 0; i < cipher.length(); i += 2) {
            int[] vector = { cipher.charAt(i) - 'a', cipher.charAt(i+1) - 'a' };
            int[] result = multiplyMatrix(invKey, vector);
            plaintext.append((char)(result[0] + 'a'));
            plaintext.append((char)(result[1] + 'a'));
        }

        // Remove trailing 'x' added for padding
        if (plaintext.charAt(plaintext.length() - 1) == 'x') {
            plaintext.deleteCharAt(plaintext.length() - 1);
        }

        return plaintext.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Example 2x2 key matrix (determinant must be coprime with 26)
        int[][] key = { {3, 3}, {2, 5} };

        System.out.print("Enter Plain Text: ");
        String plaintext = sc.nextLine();

        String cipher = encrypt(plaintext, key);
        System.out.println("Encrypted Text: " + cipher);

        String decrypted = decrypt(cipher, key);
        System.out.println("Decrypted Text: " + decrypted);
    }
}
