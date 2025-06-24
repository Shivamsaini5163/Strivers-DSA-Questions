package Leetcode;
//leetcode 237
public class Delete_Node_in_a_Linked_List {
    public void deleteNode(ListNode node) {    // O(1)       O(1)
        //Given In Question:
        //The value of each node in the list is unique.
        //The node to be deleted is in the list and is not a tail node.

        // Copy data from next node to current node
        node.val = node.next.val;
        // Bypass the next node
        node.next = node.next.next;
    }
}
