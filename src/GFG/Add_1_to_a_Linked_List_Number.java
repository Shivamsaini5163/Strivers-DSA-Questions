package GFG;

public class Add_1_to_a_Linked_List_Number{
//    Iterative Approach    O(N) but three passes   O(1)
    public ListNode addOne(ListNode head) {
        head=reverse(head);
        ListNode temp=head;
        int carry=1;
        while(temp!=null){
            int value=temp.val+carry;
            temp.val=value%10;
            carry=value/10;
            if(carry==0) break;
            temp=temp.next;
        }
        head=reverse(head);
        if(carry==1){
            ListNode node=new ListNode(1);
            node.next=head;
            head=node;
        }
        return head;
    }
    private ListNode reverse(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode nxt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
        }
        head=prev;
        return head;
    }
    //Recursive Approach        O(N)       O(N)
    public ListNode addOne2(ListNode head) {
        int carry=helper(head);
        if(carry!=0){
            ListNode node=new ListNode(carry);
            node.next=head;
            head=node;
        }
        return head;
    }
    private int helper(ListNode head){
        if(head==null){
            return 1;   //returning carry for last digit
        }
        int carry=helper(head.next);
        int value=head.val+carry;
        head.val=value%10;
        carry=value/10;
        return carry;
    }
}
