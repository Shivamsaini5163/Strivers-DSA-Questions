package GFG;

import java.util.ArrayList;

public class Sort_the_given_array_after_applying_the_given_equation {
    public ArrayList<Integer> sortArray(int[] arr, int A, int B, int C) {
        // Case 1: A > 0 – Convex parabola (opens upwards) → Has a valley (minimum point)
        // The largest transformed values lie at the ends of the array.
        // We fill the result array from end to start using two pointers.

        // Case 2: A < 0 – Concave parabola (opens downwards) → Has a peak (maximum point)
        // The smallest transformed values lie at the ends.
        // We fill the result array from start to end using two pointers.
        int n=arr.length;
        int l=0;
        int r=n-1;
        int[] newArr = new int[n];
        int index = A >= 0 ? n - 1 : 0; // Fill from end if A >= 0, else from start
        while(l<=r){
            int leftValue=evaluate(arr[l],A,B,C);
            int rightValue=evaluate(arr[r],A,B,C);
            if(A>=0){
                if(leftValue>rightValue){
                    newArr[index--]=leftValue;
                    l++;
                }else{
                    newArr[index--]=rightValue;
                    r--;
                }
            }else{
                if(leftValue<rightValue){
                    newArr[index++]=leftValue;
                    l++;
                }else{
                    newArr[index++]=rightValue;
                    r--;
                }
            }
        }
        // Convert array to ArrayList and return
        ArrayList<Integer> result = new ArrayList<>();
        for (int val : newArr) {
            result.add(val);
        }

        return result;
    }
    public int evaluate(int x, int A, int B, int C){
        return A*x*x+B*x+C;
    }
}
