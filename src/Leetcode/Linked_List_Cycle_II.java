package Leetcode;

import java.util.HashSet;
import java.util.Set;
//leetcode 142
public class Linked_List_Cycle_II {
    //Brute Force       O(N)      O(N)
    public ListNode detectCycle(ListNode head) {
        ListNode temp = head;
        Set<ListNode> nodeMap = new HashSet<>();
        while (temp != null) {
            if (nodeMap.contains(temp)) {
                return temp;
            }
            nodeMap.add(temp);
            temp = temp.next;
        }
        return null;
    }
    //Optimize Approach     O(N)       O(1)
    public ListNode detectCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast)                break;
        }
        if(fast == null || fast.next == null)
            return null;
        slow = head;
        while(slow!=fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
