package Leetcode;
//leetcode 61
public class Rotate_List {
    //Brute Force   O(k % n × n) (worst case: O(n²))    O(1)
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null){
            return head;
        }
        int length=length(head);
        int rotations=k%length;
        while(rotations!=0){
            ListNode last=head;
            ListNode prev=head;
            while(last.next!=null){
                prev=last;
                last=last.next;
            }
            prev.next=null;
            last.next=head;
            head=last;
            rotations--;
        }
        return head;
    }
    private int length(ListNode head){
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
    //Optimized Approach    O(N)    O(1)
    public ListNode rotateRight2(ListNode head, int k) {
        if(head==null||head.next==null){
            return head;
        }
        int length=length(head);
        int rotations=k%length;
        int x=length-rotations;
        ListNode last=head;
        while(last.next!=null){
            last=last.next;
        }
        last.next=head; //make it circular linked list
        ListNode prev=head;
        while(x!=0){
            prev=head;
            head=head.next;
            x--;
        }
        prev.next=null;     //break the circular list
        return head;
    }
}
