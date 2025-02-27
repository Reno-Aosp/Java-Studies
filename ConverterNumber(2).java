import java.util.Scanner;
import java.util.Stack;

public class NumberConverter {

    public static String convertToBase(int Decimal, int Base, String Digits) {
        Stack<Character> stack = new Stack<>();

        if (Decimal == 0) {
            return "0";
        }
        while (Decimal > 0) {
            stack.push(Digits.charAt(Decimal % Base));
            Decimal /= Base;
        }
        
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Input your number here: ");
        int Decimal = scanner.nextInt();
        
        String Binary = convertToBase(Decimal, 2, "01");
        String Octal = convertToBase(Decimal, 8, "01234567");
        String HexaDecimal = convertToBase(Decimal, 16, "0123456789ABCDEF");

        System.out.println("Binary: " + Binary);
        System.out.println("Octal: " + Octal);
        System.out.println("HexaDecimal: " + HexaDecimal);

        scanner.close();
    }
}
