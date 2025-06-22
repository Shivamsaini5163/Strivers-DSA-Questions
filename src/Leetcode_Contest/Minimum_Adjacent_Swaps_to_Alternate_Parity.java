package Leetcode_Contest;
import java.util.*;
public class  Minimum_Adjacent_Swaps_to_Alternate_Parity {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        //count the no. of odds and evens

        List<Integer> evenIndices=new ArrayList<>();
        List<Integer> oddIndices=new ArrayList<>();

        for(int i=0;i<n;i++){
            if (nums[i]%2==0) evenIndices.add(i);
            else oddIndices.add(i);
        }
        if(Math.abs(oddIndices.size()-evenIndices.size())>1) return -1;

        int min=Integer.MAX_VALUE;

        //Case 1 : start with even
        if(evenIndices.size()>=oddIndices.size()){
            int swaps=0;
            for(int i=0;i<evenIndices.size();i++){
                swaps += Math.abs(evenIndices.get(i) - 2 * i);
            }
            min=Math.min(min,swaps);
        }

        //Case 2 : start with odd
        if(evenIndices.size()<=oddIndices.size()){
            int swaps=0;
            for(int i=0;i<oddIndices.size();i++){
                swaps += Math.abs(oddIndices.get(i) - 2 * i);
            }
            min=Math.min(min,swaps);
        }
        return min;
    }
}
