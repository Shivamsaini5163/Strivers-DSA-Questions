package Leetcode;

//leetcode 92
//Time and Space Complexity =>  O(N) O(1)
public class Reverse_Linked_List_II {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null||head.next==null||left==right){
            return head;
        }
        ListNode curr=head;
        ListNode prev=null;
        int i;
        for (i = 1; i <left&&curr!=null; i++) {     //skipping (n-1) nodes initially
            prev=curr;
            curr=curr.next;
        }
        ListNode pointerToStart=prev;       // stores 2 points to remember and connect them further
        ListNode start=curr;
        prev=null;      //fresh start to reverse that sub linked list
        while(curr!=null&&i!=right+1){
            ListNode nxt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
            i++;
        }
        start.next=curr;
        if (pointerToStart!=null){
            pointerToStart.next=prev;
        }
        else {
            return prev;    //if left index is 0 it will become new head
        }
        return head;
    }
}

