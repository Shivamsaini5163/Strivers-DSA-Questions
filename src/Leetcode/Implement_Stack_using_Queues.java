package Leetcode;
import java.util.*;
//leetcode 225
public class Implement_Stack_using_Queues {
    //Method 1 using two Queue
    class MyStack1 {
        Queue<Integer> queue1;
        Queue<Integer> queue2;
        public MyStack1() {
            queue1=new LinkedList<>();
            queue2=new LinkedList<>();
        }

        public void push(int x) {
            while(!queue2.isEmpty()){
                queue1.add(queue2.poll());
            }
            queue2.add(x);
            while(!queue1.isEmpty()){
                queue2.add(queue1.poll());
            }
        }

        public int pop() {
            return queue2.poll();
        }

        public int top() {
            return queue2.peek();
        }

        public boolean empty() {
            return queue2.isEmpty();
        }
    }
    //Method 2 using one Queue
    class MyStack2 {
        Queue<Integer> queue;
        public MyStack2() {
            queue=new LinkedList<>();
        }

        public void push(int x) {
            queue.add(x);
            for(int i=1;i<queue.size();i++){
                queue.add(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
