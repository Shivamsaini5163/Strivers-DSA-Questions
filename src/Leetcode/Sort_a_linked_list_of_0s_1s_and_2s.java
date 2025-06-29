package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sort_a_linked_list_of_0s_1s_and_2s {
//    Brute Force   O(N)       O(N)
    static ListNode segregate(ListNode head) {
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
    //Better Approach  O(N)       O(1)     Two pass solution     Counting Method
    static ListNode segregate2(ListNode head) {
        int[] count = new int[3]; // count[0] = count of 0s, etc.
        ListNode temp = head;
        while (temp != null) {
            count[temp.val]++;
            temp = temp.next;
        }
        temp = head;
        int i = 0;
        while (temp != null) {
            if (count[i] == 0) {
                i++; // move to next number
            } else {
                temp.val = i;
                count[i]--;
                temp = temp.next;
            }
        }
        return head;
    }
    //Optimize Approach  O(N)       O(1)
    static ListNode segregate3(ListNode head) {
        ListNode zeroHead=new ListNode(-1); //dummy node
        ListNode oneHead=new ListNode(-1);
        ListNode twoHead=new ListNode(-1);
        ListNode zero=zeroHead; //pointer for dummy node
        ListNode one=oneHead;
        ListNode two=twoHead;
        ListNode temp=head;
        while(temp!=null){
            if(temp.val==0){
                zero.next=temp;
                zero=zero.next;
            }else if(temp.val==1){
                one.next=temp;
                one=one.next;
            }else {
                two.next=temp;
                two=two.next;
            }
            temp=temp.next;
        }
        zero.next=(oneHead.next!=null)?oneHead.next:twoHead.next;
        one.next=twoHead.next;
        two.next=null;
        ListNode newHead=(zeroHead.next!=null)?zeroHead.next:twoHead.next;
        return newHead;
    }
}
