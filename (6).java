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

    // Metode untuk mengecek apakah notasi infix benar atau tidak
    public static String checkInfixNotation(String input) {
        Stack<Character> stack = new Stack<>();
        String[] tokens = input.split(" ");
        String operators = "+-*/";
        boolean lastWasOperator = false;
        boolean lastWasOperand = false;
        boolean lastWasOpenParen = false;
        
        for (String token : tokens) {
            if (token.equals("(")) {
                stack.push('(');
                lastWasOpenParen = true;
                lastWasOperator = false;
            } else if (token.equals(")")) {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return "Notasi infix salah, kurung tidak lengkap";
                }
                lastWasOperator = false;
                lastWasOperand = true;
            } else if (operators.contains(token)) {
                if (lastWasOperator || lastWasOpenParen) {
                    return "Notasi infix salah, operand tidak lengkap";
                }
                lastWasOperator = true;
                lastWasOperand = false;
            } else {
                lastWasOperand = true;
                lastWasOperator = false;
                lastWasOpenParen = false;
            }
        }
        
        if (!stack.isEmpty()) {
            return "Notasi infix salah, kurung tidak lengkap";
        }
        if (lastWasOperator) {
            return "Notasi infix salah, operand tidak lengkap";
        }
        
        return "Notasi infix benar";
    }

    // Metode untuk mengonversi infix ke postfix
    public static String infixToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        String operators = "-+*/";
        
        for (char c : infix.replaceAll(" ", "").toCharArray()) {
            if (Character.isDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            } else if (operators.indexOf(c) != -1) {
                while (!stack.isEmpty() && operators.indexOf(stack.peek()) >= operators.indexOf(c)) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }
        
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        
        return postfix.toString();
    }

    // Metode untuk menghitung hasil dari notasi postfix
    public static int evaluatePostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();
        
        for (char c : postfix.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int b = stack.pop();
                int a = stack.pop();
                switch (c) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                }
            }
        }
        
        return stack.pop();
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
        
        System.out.print("Masukkan notasi infix: ");
        String infix = scanner.nextLine();
        
        System.out.println(checkInfixNotation(infix));
        
        if (checkInfixNotation(infix).equals("Notasi infix benar")) {
            String postfix = infixToPostfix(infix);
            System.out.println("Postfix: " + postfix);
            System.out.println("Hasil: " + evaluatePostfix(postfix));
        }
        
        scanner.close();
    }
}