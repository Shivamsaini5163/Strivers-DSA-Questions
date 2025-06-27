package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
        Set<ListNode> nodeMap = new HashSet<>();
        while (temp != null) {
            if (nodeMap.contains(temp)) {
                return true;
            }
            nodeMap.add(temp);
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