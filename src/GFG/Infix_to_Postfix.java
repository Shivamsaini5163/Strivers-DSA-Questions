package GFG;

import java.util.*;
public class Infix_to_Postfix {
    public static String infixToPostfix(String exp) {
        StringBuilder result = new StringBuilder();
        Stack < Character > stack = new Stack <> ();
        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c))
                result.append(c);
            else if (c == '(')
                stack.push(c);
            else if (c == ')') {
                while (!stack.isEmpty()&&stack.peek() != '('){
                    result.append(stack.pop());
                }
                stack.pop();
            } else // an operator is encountered
            {
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {
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
        return result.toString();
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
