package Leetcode;
import java.util.*;
//leetcode 148
public class Sort_List {
    //Brute Force   O(NlogN)     O(N)
    public ListNode sortList(ListNode head) {
        List<Integer> list=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            list.add(temp.val);
            temp=temp.next;
        }
        Collections.sort(list);
        temp=head;
        for (Integer integer : list) {
            temp.val = integer;
            temp = temp.next;
        }
        return head;
    }
    //Optimize Approach    Time=> O(NlogN)     Space(stack) dut to recursion=> O(logN)    Extra Space=> O(1)
    public ListNode sortList2(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode mid=findMiddle(head);
        ListNode right=mid.next;
        mid.next=null;
        ListNode left=head;
        left=sortList(left);
        right=sortList(right);
        return merge(left,right);
    }
    private ListNode merge(ListNode list1,ListNode list2){
        ListNode dummyNode=new ListNode(-1);
        ListNode temp=dummyNode; //temp points to dummy node
        while(list1!=null&&list2!=null){
            if(list1.val<=list2.val){
                temp.next=list1;
                list1=list1.next;
            }else{
                temp.next=list2;
                list2=list2.next;
            }
            temp=temp.next;
        }
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }
        return dummyNode.next;
    }
    private ListNode findMiddle(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast=head.next;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}
