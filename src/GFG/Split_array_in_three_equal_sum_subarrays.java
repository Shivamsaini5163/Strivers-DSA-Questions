package GFG;

import java.util.ArrayList;
import java.util.List;

public class Split_array_in_three_equal_sum_subarrays {
    public List<Integer> findSplit(int[] arr) {
        long sum=0;
        int n=arr.length;
        for(int num:arr){
            sum+=num;
        }
        // Note: only positive elements are allowed in question here
        // if negative element allow then see leetcode 1013
        if(sum%3!=0) return List.of(-1, -1);;
        long target=sum/3;
        long currsum=0;
        int first = -1, second = -1;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            currsum+=arr[i];
            if (currsum == target && first == -1) {
                first = i; // first split
                currsum=0;
            } else if (currsum == target && first != -1) {
                second = i; // second split
                break;
            }
        }
        if (first != -1 && second != -1) {
            return List.of(first, second);
        }

        return List.of(-1, -1);
    }
}
