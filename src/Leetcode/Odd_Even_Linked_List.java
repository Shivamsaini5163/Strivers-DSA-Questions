package Leetcode;
//leetcode 328
//Time and Space Complexity =>  O(N) O(1)
public class Odd_Even_Linked_List {
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null||head.next.next==null){
            return head;
        }
        ListNode odd=head;
        ListNode even=head.next;
        ListNode evenHead=head.next;
        while(even!=null&&even.next!=null){
            odd.next=even.next;
            odd=even.next;
            even.next=odd.next;
            even=odd.next;
        }
        odd.next=evenHead;
        return head;
    }
}
