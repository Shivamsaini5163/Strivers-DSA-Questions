package GFG;

import java.util.Stack;

public class Infix_To_Prefix {
    public static void main(String[] args) {
        System.out.println(infixToPrefix("(a-b/c)*(a/k-l)"));
    }
    public static String infixToPrefix(String exp) {
        StringBuilder result = new StringBuilder();
        Stack< Character > stack = new Stack <> ();
        StringBuilder reversed = new StringBuilder(exp).reverse();
        for (int i = 0; i < reversed.length(); i++) {
            char c = reversed.charAt(i);
            if (c == '(')
                reversed.setCharAt(i, ')');
            else if (c == ')')
                reversed.setCharAt(i, '(');
        }
        for (int i = 0; i < reversed.length(); ++i) {
            char c = reversed.charAt(i);
            if (Character.isLetterOrDigit(c))
                result.append(c);
            else if (c == '(')
                stack.push(c);
            else if (c == ')') {
                while (!stack.isEmpty()&&stack.peek() != '('){
                    result.append(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop(); // remove '('
                }
            } else // an operator is encountered
            {
                while (!stack.isEmpty() && Prec(c) < Prec(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }

        }

        // pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
    static int Prec(char ch) {
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }
}