package Leetcode;

public class Remove_Nth_Node_From_End_of_List {
//leetcode 19
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) {
          this.val = val;
      }
      ListNode(int val, ListNode next) {
          this.val = val; this.next = next;
      }
  }
  //Brute Force      O(N) O(1)
  //But it takes two passes
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        int size=0;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        if(n==size){
            head=head.next;
            return head;
        }
        ListNode prev=head;
        temp=head;
        for(int i=1;i<=size-n;i++){
            prev=temp;
            temp=temp.next;
        }
        prev.next=temp.next;
        return head;
    }
    //Time and Space Complexity =>    O(N) O(1)
    //Optimize Approach =>  it takes only one pass
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode fast=head;
        ListNode slow=head;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        if(fast==null){ //  it means first element need to delete
            head=head.next;
            return head;
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return head;
    }
}
