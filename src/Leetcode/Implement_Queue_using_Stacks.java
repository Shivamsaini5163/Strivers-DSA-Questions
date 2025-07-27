package Leetcode;
import java.util.Stack;
//leetcode 232
//time and space complexity=> Amortized O(1)
public class  Implement_Queue_using_Stacks {
    //Method 1
    class MyQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public MyQueue() {
            stack1 = new Stack();
            stack2 = new Stack();
        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            peek();
            return stack2.pop();
        }

        public int peek() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }

        public boolean empty() {
            return stack2.isEmpty() && stack1.isEmpty();
        }
    }
    // Method 2 using Recursion
    class MyQueue2 {
        Stack<Integer> stack;
        public MyQueue2() {
            stack=new Stack<>();
        }

        public void push(int x) {
            if(stack.isEmpty()){
                stack.push(x);
                return;
            }
            int temp=stack.pop();
            push(x);
            stack.push(temp);
        }

        public int pop() {
            if (stack.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return stack.pop();
        }

        public int peek() {
            if (stack.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return stack.peek();
        }

        public boolean empty() {
            return stack.isEmpty();
        }
    }
}