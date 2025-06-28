package GFG;

import java.util.HashMap;
import java.util.Map;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Find_length_of_Loop {
    //Brute Force       O(N)       O(N)
    public int countNodesinLoop(ListNode head) {
        // code here.
        Map<ListNode,Integer> map=new HashMap<>();
        ListNode temp=head;
        int pos=1;
        while(temp!=null){
            if(map.containsKey(temp)){
                return pos-map.get(temp);
            }
            map.put(temp,pos);
            temp=temp.next;
            pos++;
        }
        return 0;
    }
    //Optimize Approach     O(N)       O(1)
    public int countNodesinLoop2(ListNode head) {
        // code here.
        ListNode fast=head;
        ListNode slow=head;
        int count=0;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return lengthOfCycle(slow,fast);
            }
        }
        return 0;   //no cycle
    }
    private int lengthOfCycle(ListNode slow,ListNode fast){
        int count=1;
        slow=slow.next;
        while(slow!=fast){
            //fast is fix at one position
            slow=slow.next;
            count++;
        }
        return count;
    }
}
