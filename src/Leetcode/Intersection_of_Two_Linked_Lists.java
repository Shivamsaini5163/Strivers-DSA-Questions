package Leetcode;

import java.util.HashSet;
import java.util.Set;
//leetcode 160
public class Intersection_of_Two_Linked_Lists {
    //Brute Force       O(M × N)        O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA=headA;
        ListNode tempB=headB;
        while(tempA!=null){
            while(tempB!=null){
                if(tempA==tempB){
                    return tempA;
                }
                tempB=tempB.next;
            }
            tempB=headB;
            tempA=tempA.next;
        }
        return null;
    }
    //Better Approach       O(M + N)        O(N)
    // using Hashing
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode temp=headA;
        Set<ListNode> set=new HashSet<>();
        while(temp!=null){
            set.add(temp);
            temp=temp.next;
        }
        temp=headB;
        while(temp!=null){
            if(set.contains(temp)){
                return temp;
            }
            temp=temp.next;
        }
        return null;
    }
    //Optimize Approach     O(M + N)           O(1)
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        int diff=getDifference(headA,headB);
        if(diff>0) while(diff--!=0) headA=headA.next;
        else while(diff++!=0) headB=headB.next;
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
    private static int getDifference(ListNode headA,ListNode headB){
        ListNode temp=headA;
        int lengthA=0;
        int lengthB=0;
        while(temp!=null){
            lengthA++;
            temp=temp.next;
        }
        temp=headB;
        while(temp!=null){
            lengthB++;
            temp=temp.next;
        }
        return lengthA-lengthB;
    }
}
