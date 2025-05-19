package Leetcode;
//leetcode 1512
//Time and Space Complexity =>    O(N) O(N)
public class Number_of_Good_Pairs {
    public static void main(String[] args) {
        int[] nums={1,2,3,1,1,3};
        System.out.println(numIdenticalPairs(nums));
    }
    public static int numIdenticalPairs(int[] nums) {
        int[] arr=new int[101];
        int sum=0;
        for(int i=0;i<nums.length;i++){
            arr[nums[i]]++;
        }
        for(int i=0;i<arr.length;i++){
            sum+=(arr[i]*(arr[i]-1))/2;
        }
        return sum;
    }
}
