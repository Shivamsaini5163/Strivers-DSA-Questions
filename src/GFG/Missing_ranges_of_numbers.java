package GFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Missing_ranges_of_numbers {
    public List<List<Integer>> missingRanges(int[] arr, int lower, int upper) {
        List<List<Integer>> res=new ArrayList<>();
        int prev=lower-1;
        for(int num:arr){
            if(prev+1<num){ //gap
                res.add(Arrays.asList(prev + 1, num - 1));
            }
            prev=num;
        }
        // Check gap between last element and upper
        if (upper > prev) {
            res.add(Arrays.asList(prev + 1, upper));
        }
        return res;
    }
}
