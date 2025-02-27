import java.util.Scanner;
import java.util.Stack;

public class PalindromeChecker {
    // Metode untuk mengecek apakah sebuah kalimat adalah palindrom
    public static boolean isPalindrome(String input) {
        Stack<Character> stack = new Stack<>();
        String cleanedInput = input.replaceAll("\\s+", "").toLowerCase(); // Menghilangkan spasi dan ubah ke huruf kecil
        
        // Push setiap karakter ke dalam stack
        for (char c : cleanedInput.toCharArray()) {
            stack.push(c);
        }
        
        // Pop karakter dan bandingkan dengan urutan awal
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        
        return cleanedInput.equals(reversed.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan kalimat: ");
        String sentence = scanner.nextLine();
        
        if (isPalindrome(sentence)) {
            System.out.println("Kalimat tersebut adalah palindrom");
        } else {
            System.out.println("Kalimat tersebut bukan palindrom");
        }
        
        scanner.close();
    }
}
