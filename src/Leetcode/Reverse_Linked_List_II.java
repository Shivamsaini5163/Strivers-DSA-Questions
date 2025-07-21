package Leetcode;

//leetcode 92
//Time and Space Complexity =>  O(N) O(1)
public class Reverse_Linked_List_II {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null||head.next==null||left==right){
            return head;
        }
        ListNode prevLeft=null;
        ListNode currLeft=head;
        int i;
        for(i=1;i<left;i++){
            prevLeft=currLeft;
            currLeft=currLeft.next;
        }
        ListNode prevRight=null;
        ListNode currRight=currLeft;
        while(i!=right+1){
            ListNode nxt=currRight.next;
            currRight.next=prevRight;
            prevRight=currRight;
            currRight=nxt;
            i++;
        }
        currLeft.next = currRight;
        if (prevLeft != null) {
            prevLeft.next = prevRight;
        } else {
            head = prevRight;
        }
        return head;
    }
}

