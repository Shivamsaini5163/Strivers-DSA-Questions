package GFG;

import java.util.ArrayList;

public class Alternate_Positive_Negative {
    void rearrange(ArrayList<Integer> arr) {
        int n=arr.size();
        ArrayList<Integer> positive=new ArrayList<>();
        ArrayList<Integer> negative=new ArrayList<>();
        for(int num:arr){
            if(num>=0){
                positive.add(num);
            }else{
                negative.add(num);
            }
        }
        arr.clear();   // clear the original list to rewrite
        int i = 0, j = 0;
        while(i<positive.size()&&j<negative.size()){
            arr.add(positive.get(i++)); // add positive first
            arr.add(negative.get(j++)); // then negative
        }
        while (i < positive.size()) arr.add(positive.get(i++));
        while (j < negative.size()) arr.add(negative.get(j++));
    }
}
