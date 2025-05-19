package Leetcode;
//leetcode 203
//Time and Space Complexity =>    O(N) O(1)
public class Remove_Linked_List_Elements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode curr=head;
        ListNode prev=null;
        while (curr!=null){
            if (curr.val==val){
                while (curr!=null&&curr.val==val){  // skip all matching nodes
                    curr=curr.next;
                }
                if (prev!=null){
                    prev.next=curr;
                }else { //  this means head value is also matching node then we need new head value
                    head=curr;
                }
            }else {
                prev=curr;
                curr=curr.next;
            }
        }
        return head;
    }
}
