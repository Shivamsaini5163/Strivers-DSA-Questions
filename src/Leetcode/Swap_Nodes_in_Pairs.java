package Leetcode;
//leetcode 24
//Time and Space Complexity =>  O(N) O(1)
public class Swap_Nodes_in_Pairs {
    //  Using Recursion
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode ptr=swapPairs(head.next.next);
        head.next.next=head;
        ListNode newHead=head.next;
        head.next=ptr;   // to connect that two sets nodes group to each other but where to find ptr so that why we are storing it in newHead
        return newHead;
    }
    //  Using Iteration
    public ListNode swapPairs2(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode curr=head.next;
        ListNode prev=head;
        head=curr;
        while(curr!=null){
            prev.next=curr.next;
            curr.next=prev;
            curr=(prev.next!=null)?prev.next.next:null;
            ListNode temp=prev;//same reason as used in recursion method
            prev=prev.next;
            if(curr!=null){
                temp.next=curr;
            }
        }
        return head;
    }
}
