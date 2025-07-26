package GFG;

/*The structure of the node of the queue is*/
class QueueNode {
    int data;
    QueueNode next;

    QueueNode(int a) {
        data = a;
        next = null;
    }

    class MyQueue {
        QueueNode front, rear;
        int size = 0;

        //Function to push an element into the queue.
        void push(int a) {
            QueueNode node = new QueueNode(a);
            if (front == null) {
                front = node;
                rear = node;
            } else {
                rear.next = node;
                rear = rear.next;
            }
            size++;
        }

        //Function to pop front element from the queue.
        int pop() {
            if (front == null) {
                return -1;
            }
            QueueNode temp = front;
            front = front.next;
            if (front == null) {
                rear = null; // Fix: reset rear when queue becomes empty
            }
            temp.next = null;
            return temp.data;
        }
    }
}