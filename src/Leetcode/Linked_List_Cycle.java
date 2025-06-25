package Leetcode;

import java.util.HashMap;
import java.util.Map;

//leetcode 141
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
}
public class Linked_List_Cycle {
//    Brute Force
//    Time and Space Complexity =>    O(N * 2 * log(N)) O(N)
    public static boolean detectLoop(ListNode head) {
        ListNode temp = head;
        Map<ListNode, Integer> nodeMap = new HashMap<>();
        while (temp != null) {
            if (nodeMap.containsKey(temp)) {
                return true;
            }
            nodeMap.put(temp, 1);
            temp = temp.next;
        }
        return false;
    }
    //Optimal Approach
    //Time and Space Complexity =>    O(N) O(1)
    public boolean hasCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
}