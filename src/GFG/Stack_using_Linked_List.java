package GFG;

class StackNode {
    int data;
    StackNode next;

    StackNode(int a) {
        data = a;
        next = null;
    }

    StackNode top;
    int size = 0;

    // Function to push an integer into the stack.
    void push(int a) {
        // Add your code here
        StackNode node = new StackNode(a);
        node.next = top;
        top = node;
        size++;
    }

    // Function to remove an item from top of the stack.
    int pop() {
        // Add your code here
        if (top == null) {
            return -1;
        }
        StackNode temp = top;
        top = top.next;
        temp.next = null;
        size--;
        return temp.data;
    }
}