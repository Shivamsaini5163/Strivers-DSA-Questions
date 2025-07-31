package GFG;

import java.util.Stack;

public class Prefix_to_Postfix_Conversion {
    static String preToPost(String exp) {
        Stack<String> stack=new Stack<>();
        // Process from right to left
        for(int i=exp.length()-1;i>=0;i--){
            char ch=exp.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                stack.push(Character.toString(ch)); //operand
            }else{  //operator
                String op1=stack.pop();
                String op2=stack.pop();
                String newexp= op1 + op2 + ch;
                stack.push(newexp);
            }
        }
        return stack.pop(); // final postfix expression
    }
}
