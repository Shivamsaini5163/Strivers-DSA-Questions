package GFG;

import java.util.ArrayList;
import java.util.Collections;
//Time and Space Complexity =>    O(N) O(N)
public class Array_Leaders {
    public static void main(String[] args) {
        int[] arr={16,17,4,3,5,2};
        System.out.println(leaders(arr));
    }
    //Optimal Solution
    static ArrayList<Integer> leaders(int[] arr) {
        ArrayList<Integer> list=new ArrayList<>();
        int max=Integer.MIN_VALUE;
        int n=arr.length;
        for (int i = n-1; i >=0 ; i--) {
            if (arr[i]>=max){
                list.add(arr[i]);
                max=arr[i];
            }
        }
        Collections.reverse(list);
        return list;
    }
    //Brute Force O(N^2)
    static ArrayList<Integer> leaders2(int[] arr) {
        int n=arr.length;
        ArrayList<Integer> list=new ArrayList<>();
        int j;
        for (int i = 0; i < n-1; i++) {
            for (j = i+1; j < n; j++) {
                if (arr[i]<arr[j]) {
                    break;
                }
            }
            if (j==n){
                list.add(arr[i]);
            }
        }
        list.add(arr[n-1]);
        return list;
    }
}
