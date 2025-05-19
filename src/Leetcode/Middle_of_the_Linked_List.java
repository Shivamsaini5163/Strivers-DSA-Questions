package Leetcode;
//leetcode 876
//Time and Space Complexity =>    O(N) O(1)
public class Middle_of_the_Linked_List {
    public ListNode middleNode(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}