package GFG;

import java.util.ArrayList;
//  O(N)        O(1)
public class Find_pairs_with_given_sum_in_doubly_linked_list {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
                                                                      ListNodeD head) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        ListNodeD l=head;
        ListNodeD h=head;
        while(h.next!=null){
            h=h.next;
        }
        while(l.data<h.data){
            int sum=l.data+h.data;
            if(sum==target){
                ArrayList<Integer> inner=new ArrayList<>();
                inner.add(l.data);
                inner.add(h.data);
                list.add(inner);
                l=l.next;
                h=h.prev;
            }
            else if(sum>target){
                h=h.prev;
            }else {
                l=l.next;
            }
        }
        return list;
    }
}
