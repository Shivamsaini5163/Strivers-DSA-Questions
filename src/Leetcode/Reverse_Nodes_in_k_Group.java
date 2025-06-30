package Leetcode;
//leetcode 25
// O(N)        O(1)
public class Reverse_Nodes_in_k_Group {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode temp=head;
        ListNode prevNode=null;
        while(temp!=null){
            ListNode Kth=findKthNode(temp,k);
            if(Kth==null){
                if(prevNode!=null) prevNode.next=temp;  // prevNode can be null if k>list size
                break;
            }
            ListNode nextNode=Kth.next;
            Kth.next=null;
            reverse(temp);
            if(temp==head){ //means it is first group
                head=Kth;
            }else{
                prevNode.next=Kth;
            }
            prevNode=temp;
            temp=nextNode;
        }
        return head;
    }
    private ListNode findKthNode(ListNode temp,int k){
        for(int i=1;i<k&&temp!=null;i++){
            temp=temp.next;
        }
        return temp;
    }
    private ListNode reverse(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode p=null;
        ListNode q=head;
        while(q!=null){
            ListNode r=q.next;
            q.next=p;
            p=q;
            q=r;
        }
        head=p;
        return head;
    }
}
