package Leetcode;
//leetcode 1721
//Time and Space Complexity =>    O(N) O(1)
public class Swapping_Nodes_in_a_Linked_List {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode curr=head;
        for(int i=1;i<k;i++){
            curr=curr.next;
        }
        ListNode a=curr;    //reach to first end and store it
        ListNode b=head;
        while(curr.next!=null){ //it is like fast and slow pointer technique to find kth element from end
            curr=curr.next;
            b=b.next;
        }
        // swap node's values
        int temp=a.val;
        a.val=b.val;
        b.val=temp;
        return head;
    }
}
