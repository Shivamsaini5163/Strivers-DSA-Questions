package GFG;

class MyQueue {
    int front, rear;
    int arr[] = new int[100005];
    int currsize;
    MyQueue() {
        front = -1;
        rear = -1;
        currsize = 0;
    }

    // Function to push an element x in a queue.
    void push(int x) {
        if(currsize==arr.length){
            return;
        }
        if(currsize==0){
            front=0;
            rear=0;
        }else{
            rear=(rear+1)%arr.length;
        }
        arr[rear]=x;
        currsize++;
    }

    // Function to pop an element from queue and return that element.
    int pop() {
        if(currsize==0){
            return -1;
        }
        int val=arr[front];
        if(currsize==1){
            front=-1;
            rear=-1;
        }else{
            front=(front+1)%arr.length;
        }
        currsize--;
        return val;
    }
}