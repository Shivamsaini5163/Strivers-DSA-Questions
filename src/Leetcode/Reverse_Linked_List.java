package Leetcode;
//leetcode 206
//Time and Space Complexity =>  O(N) O(1)
public class Reverse_Linked_List {
    // using iteration and 3 pointers method
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode p=null;
        ListNode q=head;
        ListNode r=head.next;
        while(q!=null){
            q.next=p;
            p=q;
            q=r;
            if(r!=null)
                r=r.next;
        }
        head=p;
        return head;
    }
    // using recursion
    public ListNode reverseList2(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode tail=reverseList2(head.next);
        head.next.next=head;
        head.next=null;
        return tail;    //this is new head of our list after reversal that is last node of original list
    }
}
