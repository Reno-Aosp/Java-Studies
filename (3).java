import java.util.Scanner;
import java.util.Stack;

public class StringReverser {
    // Metode untuk membalikkan string menggunakan stack
    public static String reverseString(String input) {
        Stack<Character> stack = new Stack<>();
        
        // Push setiap karakter ke dalam stack
        for (char c : input.toCharArray()) {
            stack.push(c);
        }
        
        // Pop karakter dari stack untuk mendapatkan urutan terbalik
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        
        return reversed.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan kalimat: ");
        String sentence = scanner.nextLine();
        
        String reversedSentence = reverseString(sentence);
        System.out.println("Hasil setelah dibalik: " + reversedSentence);
        
        scanner.close();
    }
}