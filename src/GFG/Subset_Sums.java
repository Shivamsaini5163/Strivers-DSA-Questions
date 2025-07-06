package GFG;
import java.util.*;
public class Subset_Sums {
    //Optimized Approach   O((2^N)*(log2^N))=> O((2^N)*N) because of sorting 2^N elements           O(2^N)
    public ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> list=new ArrayList<>();
        helper(arr,list,0,0);
        Collections.sort(list);
        return list;
    }
    void helper(int[] arr,ArrayList<Integer> list,int sum,int i){
        if(arr.length==i){
            list.add(sum);
            return;
        }
        helper(arr,list,sum+arr[i],i+1);
        helper(arr,list,sum,i+1);
    }
}
