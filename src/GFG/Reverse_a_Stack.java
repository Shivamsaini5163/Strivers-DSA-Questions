package GFG;

import java.util.Stack;
// O(N^2)     O(N)
public class Reverse_a_Stack {
    static void reverse(Stack<Integer> s) {
        if(s.isEmpty()){
            return;
        }
        int x=s.pop();
        reverse(s);
        insertAtBottom(s,x);
    }
    static void insertAtBottom(Stack<Integer> s,int x){
        if(s.isEmpty()){
            s.push(x);
        }else{
            int a=s.pop();
            insertAtBottom(s,x);
            s.push(a);
        }
    }
}
