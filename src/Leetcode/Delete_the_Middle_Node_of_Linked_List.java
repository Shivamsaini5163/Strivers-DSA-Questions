package Leetcode;
//leetcode 2095
//Time and Space Complexity =>    O(N) O(1)
public class Delete_the_Middle_Node_of_Linked_List {
    public ListNode deleteMiddle(ListNode head) {
        if (head==null||head.next==null){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        ListNode prev=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            prev=slow;
            slow=slow.next;
        }
        prev.next=slow.next;
        return head;
    }
}
