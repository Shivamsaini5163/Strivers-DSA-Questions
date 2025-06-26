package Leetcode;
import java.util.Stack;
//leetcode 206
public class Reverse_Linked_List {
    //Brute Force using Stack but reverse in terms of data
    //Time and Space Complexity =>  O(2*N) O(N)
    public ListNode reverseList(ListNode head){
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        //changing data one by one, not changing links
        while (temp != null) {
            temp.val = stack.pop();
            temp = temp.next;
        }
        return head;
    }
    // using iteration and 3 pointers method
    public ListNode reverseList2(ListNode head) {
        //Time and Space Complexity =>  O(N) O(1)
        if(head==null||head.next==null){
            return head;
        }
        ListNode p=null;
        ListNode q=head;
        while(q!=null){
            ListNode r=q.next;
            q.next=p;
            p=q;
            q=r;
        }
        head=p;
        return head;
    }
    // using recursion
    public ListNode reverseList3(ListNode head) {
        //Time and Space Complexity =>  O(N) O(N)
        if(head==null||head.next==null){
            return head;
        }
        ListNode newHead=reverseList(head.next);
        ListNode front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }
}
