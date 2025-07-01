package GFG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Flattening_a_Linked_List {
    // just defined linked list for question
    static class Node{
        int data;
        Node next;
        Node bottom;
        Node(int data){
            this.data=data;
            this.next=null;
            this.bottom=null;
        }
    }
    //Brute force    O(N*M log(N*M))        O(N*M)
    Node flatten(Node root) {
        Node temp=root;
        List<Integer> list=new ArrayList<>();
        while(temp!=null){
            Node t1=temp;
            while(t1!=null){
                list.add(t1.data);
                t1=t1.bottom;
            }
            temp=temp.next;
        }
        Collections.sort(list);
        return convertIntoLL(list,root);
    }
    Node convertIntoLL(List<Integer> list,Node root){
        Node node=new Node(list.get(0));
        root=node;
        Node curr=node;
        for(int i=1;i<list.size();i++){
            node=new Node(list.get(i));
            curr.bottom=node;
            curr=node;
        }
        return root;
    }
    //Optimize Approach  (Recursive)   	O(M * N)    O(N) (recursion stack)
    Node flatten2(Node root) {
        if(root==null||root.next==null){
            return root;
        }
        Node nextNode=flatten(root.next);
        root=mergeTwoList(nextNode,root);
        return root;

    }
    Node mergeTwoList(Node l1,Node l2){
        Node dummy=new Node(-1);
        Node curr=dummy;
        while(l1!=null&&l2!=null){
            if(l1.data<l2.data){
                curr.bottom=l1;
                l1=l1.bottom;
            }else{
                curr.bottom=l2;
                l2=l2.bottom;
            }
            curr=curr.bottom;
        }
        if(l1!=null){
            curr.bottom=l1;
        }else{
            curr.bottom=l2;
        }
        return dummy.bottom;
    }
    //Optimize Approach     (Iterative)   	O(M * N)    O(1)
    Node flatten3(Node root) {
        if (root == null || root.next == null) return root;
        Node l=root.next;
        while(l!=null){
            Node upcoming=l.next;
            root=mergeTwoList(root,l);
            l=upcoming;
        }
        return root;
    }
}
