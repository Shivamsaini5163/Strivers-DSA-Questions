package Leetcode;
//leetcode 876
//Time and Space Complexity =>    O(N) O(1)
public class Middle_of_the_Linked_List {
    //Brute Force        O(N)
    public ListNode middleNode(ListNode head){
        // If the list is empty or has
        // only one element, return the head as
        // it's the middle.
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        int count = 0;
        // Count the number of nodes
        // in the linked list.
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        // Calculate the position of the middle node.
        int mid = count / 2 + 1;
        temp = head;

        while (temp != null) {
            mid = mid - 1;

            // Check if the middle
            // position is reached.
            if (mid == 0){
                // break out of the loop
                // to return temp
                break;
            }
            // Move temp ahead
            temp = temp.next;
        }
        // Return the middle node.
        return temp;
    }
    //Optimal Approach      O(N/2)
    public ListNode middleNode2(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}