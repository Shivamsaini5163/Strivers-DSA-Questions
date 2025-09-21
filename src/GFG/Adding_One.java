package GFG;

import java.util.Collections;
import java.util.Vector;

public class Adding_One {
    Vector<Integer> addOne(int[] arr) {
        int n=arr.length;
        Vector<Integer> vec=new Vector<>();
        int carry=1;
        for(int i=n-1;i>=0;i--){
            int val=arr[i]+carry;
            vec.add(val%10);
            carry=val/10;
        }
        if(carry!=0){
            vec.add(carry);
        }
        Collections.reverse(vec);
        return vec;
    }
}
