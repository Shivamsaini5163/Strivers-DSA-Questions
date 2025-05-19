package Leetcode;
//leetcode 82
//Time and Space Complexity =>    O(N) O(1)
public class Remove_Duplicates_from_Sorted_List_II {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr=head;
        ListNode prev=null;
        while (curr!=null&&curr.next!=null){
            if (curr.val==curr.next.val){
                int val= curr.val;
                while (curr!=null&&curr.val==val){  // skip all duplicates nodes
                    curr=curr.next;
                }
                if (prev!=null){
                    prev.next=curr;
                }else {     //  this means head value is also duplicate then we need new head value
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
