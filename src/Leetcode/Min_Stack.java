package Leetcode;

import java.util.Stack;
//leetcode 155
//Time and Space Complexity =>    O(1) O(N)
public class Min_Stack {
    class MinStack {
        Stack<Integer> stack;
        Stack<Integer> minstack; // using a extra stack to maintain what is minimum in current scenario
        public MinStack() {
            stack=new Stack<>();
            minstack=new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            if(minstack.isEmpty()||minstack.peek()>=val){
                minstack.push(val);
            }
        }

        public void pop() {
            if(stack.peek().equals(minstack.peek())){
                minstack.pop();
            }
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }
        public int getMin() {
            return minstack.peek();
        }
    }
}
