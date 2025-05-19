package Leetcode;
//leetcode 2074
//Time and Space Complexity =>  O(N) O(1)
public class Reverse_Nodes_in_Even_Length_Groups {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int gn=0,elementsInPreviousGroup=0;
        ListNode curr=head;
        ListNode lastOfPrevGrp=null;
        ListNode lastOfEvenGrp=null;    //this will help in last group when last grp is odd with even elements so have reference
        while (curr!=null){
            gn++;
            if(gn%2==0){
                elementsInPreviousGroup=rev(lastOfPrevGrp,curr,gn);
                lastOfEvenGrp=curr;
                curr=curr.next;
            }else {
                int k=gn;
                elementsInPreviousGroup=0;
                while (curr!=null&&k>0){
                    lastOfPrevGrp=curr; //also act as lastOfOddGrp means this will help in last group when last grp is even with odd elements so have reference
                    curr=curr.next;
                    k--;
                    elementsInPreviousGroup++;
                }
            }
        }
        //check last group
        if (gn%2==1&&elementsInPreviousGroup%2==0){//Means grp is odd but with even elements so reverse it
            rev(lastOfEvenGrp,lastOfEvenGrp.next,elementsInPreviousGroup);
        } else if (gn%2==0&&elementsInPreviousGroup%2==1) {//Means group is even but with odd elements so should not reverse so we re-reverse it
            rev(lastOfPrevGrp,lastOfPrevGrp.next,elementsInPreviousGroup);
        }
        return head;
    }
    private static int rev(ListNode last,ListNode headOfGroup,int n){
        ListNode prev=null;
        int count=0;
        ListNode curr=headOfGroup;
        ListNode nxt=curr.next;
        while (curr!=null&&n>0){
            nxt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
            n--;
            count++;
        }
        headOfGroup.next=nxt;
        last.next=prev;
        return count;
    }
}
