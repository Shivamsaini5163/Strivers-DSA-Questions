package GFG;

import java.util.Stack;

public class Postfix_to_Infix_Conversion {
    static String postToInfix(String exp) {
        Stack<String> stack=new Stack<>();
        // Process from left to right
        for(int i=0;i<exp.length();i++){
            char ch=exp.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                stack.push(Character.toString(ch)); //operand
            }else{  //operator
                String op1=stack.pop();
                String op2=stack.pop();
                String newexp="(" + op2 + ch + op1 + ")";
                stack.push(newexp);
            }
        }
        return stack.pop(); // final infix expression
    }
}
