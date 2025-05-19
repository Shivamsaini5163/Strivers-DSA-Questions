package Leetcode;
//leetcode 83
//Time and Space Complexity =>  O(N) O(1)
public class Remove_Duplicates_from_Sorted_List {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ptr=head;
        while(ptr!=null&&ptr.next!=null){
            if(ptr.val==ptr.next.val){
                ptr.next=ptr.next.next;
            }
            else{
                ptr=ptr.next;
            }
        }
        return head;
    }
}
