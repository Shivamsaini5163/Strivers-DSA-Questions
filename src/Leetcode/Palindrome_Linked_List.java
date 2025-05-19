package Leetcode;
//leetcode 234
public class Palindrome_Linked_List {
    //Method 1
    //Time and Space Complexity =>    O(N) O(1)
    public boolean isPalindrome(ListNode head) {
        ListNode mid=findMiddleNode(head);
        ListNode secondHead=reverseList(mid);
        ListNode a=head;
        ListNode b=secondHead;
        while(a!=null&&b!=null){
            if(a.val!=b.val){
                return false;
            }
            a=a.next;
            b=b.next;
        }
        reverseList(secondHead);
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
    //Method 2 using recursion
    //Time and Space Complexity =>    O(N) O(N)
    ListNode left;  //global instance because it is required in both methods
    public boolean isPalindrome2(ListNode head) {
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

