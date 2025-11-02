package GFG;

class StackNode {
    // Node class
    class Node {
        int data;
        Node next;

        Node(int new_data) {
            data = new_data;
            next = null;
        }
    }

    private Node top;   // top of stack
    private int count;  // number of elements

    public StackNode() {
        // Initialize your data members
        top = null;
        count = 0;
    }

    public boolean isEmpty() {
        // check if the stack is empty
        return top == null;
    }

    public void push(int x) {
        // Adds an element x at the rear of the stack.
        Node node = new Node(x);
        node.next = top; // point to previous top
        top = node;      // new node becomes top
        count++;
    }

    public void pop() {
        // Removes the front element of the stack.
        if (top == null) return; // nothing to pop
        top = top.next;
        count--;
    }

    public int peek() {
        // Returns the front element of the stack.
        // If stack is empty, return -1.
        if (top == null) return -1;
        return top.data;
    }

    public int size() {
        // Returns the current size of the stack.
        return count;
    }
}