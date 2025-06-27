package Leetcode;

import java.util.Stack;

//leetcode 234
public class Palindrome_Linked_List {
    //Brute Force       O(N)     O(N)    use Stack
    public boolean isPalindrome1(ListNode head) {
        Stack<Integer> st = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            st.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            if (temp.val != st.peek()) {
                return false;
            }
            st.pop();
            temp = temp.next;
        }
        return true;
    }
    //Method 2
    //Time and Space Complexity =>    O(N) O(1)
    public boolean isPalindrome2(ListNode head) {
        ListNode mid=findMiddleNode(head);
        ListNode secondHead=reverseList(mid);
        ListNode a=head;
        ListNode b=secondHead;
        while(b!=null){
            if(a.val!=b.val){
                reverseList(secondHead);    //make list again normal before leave
                return false;
            }
            a=a.next;
            b=b.next;
        }
        reverseList(secondHead);    //make list again normal before leave
        return true;
    }
    private static ListNode findMiddleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    private static ListNode reverseList(ListNode curr){
        ListNode prev=null;
        while(curr!=null){
            ListNode nxt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
        }
        return prev;
    }
    //Method 3 using recursion
    //Time and Space Complexity =>    O(N) O(N)
    ListNode left;  //global instance because it is required in both methods
    public boolean isPalindrome3(ListNode head) {
        left=head;
        return helper(head);
    }
    private boolean helper(ListNode node){
        if(node==null){
            return true;
        }
        boolean smallAns=helper(node.next);
        if(!smallAns){
            return false;
        }
        if(left.val!=node.val){
            return false;
        }
        left=left.next;
        return true;
    }
}

