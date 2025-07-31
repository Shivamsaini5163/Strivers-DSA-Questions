package Leetcode;

import java.util.Stack;
//leetcode 155
//Time and Space Complexity =>    O(1) O(N)
public class Min_Stack {
    class MinStack {
        Stack<Integer> stack;
        Stack<Integer> minstack; // using an extra stack to maintain what is minimum in current scenario
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
    //Using Pairs in Stack one to Store value and other to store minimum value up to that element
    class MinStack2 {
        Stack<int[]> stack;
        public MinStack2() {
            stack=new Stack<>();
        }

        public void push(int val) {
            if (stack.isEmpty()) {
                stack.push(new int[]{val, val});
            } else {
                int currentMin = stack.peek()[1];
                stack.push(new int[]{val, Math.min(val, currentMin)});
            }
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek()[0];
        }

        public int getMin() {
            return stack.peek()[1];
        }
    }
}
