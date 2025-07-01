package Leetcode;

import java.util.HashMap;
import java.util.Map;
//leetcode 138
public class Copy_List_with_Random_Pointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    //Brute Force       O(2N)       O(2N)
    public Node copyRandomList(Node head) {
        Map<Node,Node> map=new HashMap<>();
        Node temp=head;
        while(temp!=null){
            Node copyNode=new Node(temp.val);
            map.put(temp,copyNode);
            temp=temp.next;
        }
        temp=head;
        while(temp!=null){
            Node copyNode=map.get(temp);
            copyNode.next=map.get(temp.next);
            copyNode.random=map.get(temp.random);
            temp=temp.next;
        }
        return map.get(head);
    }
    //Optimize Approach O(3N)           O(N)
    public Node copyRandomList2(Node head) {
        if(head==null) return null;
        insertCopyInBetween(head);
        connectRandomPointers(head);
        return getDeepCopyList(head);
    }
    void insertCopyInBetween(Node head){
        Node temp=head;
        while(temp!=null){
            Node copy=new Node(temp.val);
            copy.next=temp.next;
            temp.next=copy;
            temp=temp.next.next;
        }
    }
    void connectRandomPointers(Node head){
        Node temp=head;
        while(temp!=null){
            Node copy=temp.next;
            if(temp.random!=null){
                copy.random=temp.random.next;
            }else{
                copy.random=null;
            }
            temp=temp.next.next;
        }
    }
    Node getDeepCopyList(Node head){
        //Extract the deep copy list
        Node dummy=new Node(-1);
        Node temp=head;
        Node curr=dummy;
        while(temp!=null){
            curr.next=temp.next;
            curr=curr.next;
            temp.next=temp.next.next;
            temp=temp.next;
        }
        return dummy.next;
    }
}
