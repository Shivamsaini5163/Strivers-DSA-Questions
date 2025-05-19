package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//leetcode 933
class Number_of_Recent_Calls{
    public static void main(String[] args) {
        RecentCounter obj=new RecentCounter();
        //take arraylist as input
        //arraylist=???
        obj.ping(69);
    }
}
//Method 1 using queue
//Time and Space Complexity  => O(1) O(1)
class RecentCounter {
    Queue<Integer> queue;

    public RecentCounter() {
        queue=new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        while(!queue.isEmpty()&&t-3000>queue.peek()){
            queue.poll();
        }
        return queue.size();
    }
}
//Method 2 using sliding window
class RecentCounter2 {
    List<Integer> list;
    int i;
    int j;
    public RecentCounter2() {
        list=new ArrayList<>();
        i=0;
        j=-1;
    }

    public int ping(int t) {
        list.add(t);
        j++;
        while(i<j&&list.get(j)-3000>list.get(i)){
            i++;
        }
        return j-i+1;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
