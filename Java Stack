import java.util.Stack;

public class StackOperations {
    public static void main(String[] args) {
        String input = "E A S * Y * Q U E * * * S T * * * I O * N * * *"; 
        Stack<Character> stack = new Stack<>();

        // Memproses setiap karakter dalam input
        for (String s : input.split(" ")) {
            if (s.equals("*")) {
                if (!stack.isEmpty()) {
                    System.out.print(stack.pop() + " ");
                }
            } else {
                stack.push(s.charAt(0)); // Push karakter ke stack
            }
        }
    }
}
