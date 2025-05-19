package Leetcode;

import java.util.Stack;

//leetcode 1063
//Time and Space Complexity => O(N) O(N)
public class Number_of_Valid_Subarrays {
    public static void main(String[] args) {
        int[] nums={0,3,4,1,5};
        System.out.println(validSubarrays2(nums));
    }
    //Brute force with time complexity O(N^2)
    public static int validSubarrays(int[] nums) {
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length ; j++) {
                if (nums[i]<=nums[j]){
                    res++;
                }else {
                    break;
                }
            }
        }
        return res;
    }
    //Optimized method O(N)
    //using increasing monotonic stack
    //this question is inspired by next greater element I question
    public static int validSubarrays2(int[] nums) {
        int res=0;
        Stack<Integer> stack=new Stack<>();
        int n=nums.length;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty()&&nums[stack.peek()]>nums[i]){
                res+=i-stack.pop(); // add those sub arrays which are starting with this pop element
            }
            stack.push(i);  //push index so we acn find no. of sub arrays forming
        }
        while (!stack.isEmpty()){
            res+=n-stack.pop(); //those elements which are remaining in thew stack will form sub arrays to the end so calculate and add that in res
        }
        return res;
    }
}


