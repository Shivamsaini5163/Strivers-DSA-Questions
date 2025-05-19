package Leetcode;

import java.util.Arrays;
//leetcode 2090
//Time and Space Complexity =>  O(N) O(1)

//Space Complexity:
//        Result Array (res):O(n) space.
//        Auxiliary Variables (win, kk, etc.): Constant space O(1).
public class K_Radius_Subarray_Averages {
    public static void main(String[] args) {
        int[] arr={7,4,3,9,1,8,5,2,6};
        System.out.println(Arrays.toString(getAverages(arr,3)));
    }
    //Question=>
//    The k-radius average for a subarray of nums centered at some index i with the radius k is the average of
//    all elements in nums between the indices i - k and i + k (inclusive). If there are less than k elements
//    before or after the index i, then the k-radius average is -1.
    //here use sliding window approach
    public static int[] getAverages(int[] nums, int k) {
        int[] res=new int[nums.length];
        Arrays.fill(res,-1);
        long win=0; //using long, not int because in int sum will go out of range
        int kk=k;
        int idx=2*k+1;
        //To prevent out of bound index
        //because if nums.length=2 and k=3 then for loop run from i=0 to idx<7 and nums[i] gets out of bound
        if(idx>nums.length){
            return res;
        }
        for (int i = 0; i < idx; i++) {
            win+=nums[i];
        }
        res[kk]=(int)(win/idx);
        for (int i = idx; i < nums.length ; i++) {
            win=win-nums[i-idx]+nums[i];
            res[++kk]=(int)(win/idx);
        }
        return res;
    }
    //Don't you this one having very bad time complexity
//    public int[] getAverages2(int[] nums, int k) {
//        int[] res=new int[nums.length];
//        for (int i = 0; i < res.length; i++) {
//            if (i-k<0||i+k>= res.length){
//                res[i]=-1;
//            }
//            else {
//                long avg=0;
//                for (int j = i-k; j <=i+k ; j++) {
//                    avg+=nums[j];
//                }
//                res[i]=(int)(avg/(2*k+1));
//            }
//        }
//        return res;
//    }
}
