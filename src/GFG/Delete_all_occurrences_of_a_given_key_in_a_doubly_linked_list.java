package GFG;

class ListNodeD {
    int data;
    ListNodeD next;
    ListNodeD prev;

    ListNodeD(int data) {
        this.data = data;
        next = prev = null;
    }
}

//  O(N)        O(1)
public class Delete_all_occurrences_of_a_given_key_in_a_doubly_linked_list {
    static ListNodeD deleteAllOccurOfX(ListNodeD head, int x) {
        ListNodeD temp = head;
        while (temp != null) {
            ListNodeD nextNode = temp.next;
            if (temp.data == x) head = delete(head, temp);
            temp = nextNode;
        }
        return head;
    }

    static ListNodeD delete(ListNodeD head, ListNodeD temp) {
        if (temp.prev == null) {  //means head need to delete
            head = head.next;
            head.prev = null;
            return head;
        } else if (temp.next == null) {
            temp.prev.next = null;
            return head;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        return head;
    }
}
