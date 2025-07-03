package GFG;

import java.util.Stack;
// O(N^2)     O(N)
public class Sort_a_stack {
    public Stack<Integer> sort(Stack<Integer> s) {
        if(s.isEmpty()){
            return s;
        }
        int x=s.pop();
        sort(s);
        insertInOrder(s,x);
        return s;
    }
    public void insertInOrder(Stack<Integer> s, int x) {
        if (s.isEmpty() || s.peek() <= x) {
            s.push(x);
            return;
        }
        int temp = s.pop();
        insertInOrder(s, x);
        s.push(temp);
    }
}
