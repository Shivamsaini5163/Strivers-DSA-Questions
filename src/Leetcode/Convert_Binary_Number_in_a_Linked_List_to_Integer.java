package Leetcode;
//leetcode 1290
//Time and Space Complexity =>    O(N) O(1)
public class Convert_Binary_Number_in_a_Linked_List_to_Integer {
    //Method 1
    public int getDecimalValue(ListNode head) {
        ListNode ptr=head;
        int size=0;
        while(ptr!=null){
            ptr=ptr.next;
            size++;
        }
        ListNode curr=head;
        int ans=0;
        while(curr!=null){
            ans+=curr.val*Math.pow(2,size-1);
            curr=curr.next;
            size--;
        }
        return ans;
    }
    //Method 2
    public int getDecimalValue2(ListNode head) {
        int ans=0;
        ListNode curr=head;
        while(curr!=null){
            ans=ans*2+curr.val;
            curr=curr.next;
        }
        return ans;
    }
}
