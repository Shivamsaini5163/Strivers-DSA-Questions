package Leetcode;
//leetcode 2181
//Time and Space Complexity =>    O(N) O(1)
public class Merge_Nodes_in_Between_Zeros {
    public ListNode mergeNodes(ListNode head) {
        ListNode originalHead=head;
        ListNode curr=head.next;
        int sum=0;
        while(curr!=null){
            if(curr.val==0){
                head.val=sum;
                sum=0;
                if(curr.next!=null){
                    head=head.next;
                }
            }
            sum+=curr.val;
            curr=curr.next;
        }
        head.next=null;
        return originalHead;
    }
}
