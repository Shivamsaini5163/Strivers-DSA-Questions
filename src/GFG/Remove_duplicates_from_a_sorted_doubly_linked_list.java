package GFG;

public class Remove_duplicates_from_a_sorted_doubly_linked_list {
//    O(N)     O(1)
    ListNodeD removeDuplicates(ListNodeD head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNodeD l=head;
        ListNodeD h=head.next;
        while(h!=null){
            if(l.data==h.data){
                head=delete(head,l);
            }
            l=l.next;
            h=h.next;
        }
        return head;
    }
    ListNodeD delete(ListNodeD head, ListNodeD temp){
        if (temp.prev == null) {  //means head need to delete
            head = head.next;
            head.prev = null;
            return head;
        } else if (temp.next == null) { //means tail need to delete
            temp.prev.next = null;
            return head;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        return head;
    }
}
