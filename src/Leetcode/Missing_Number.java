package Leetcode;
//leetcode 268
//Time and Space Complexity =>  O(N)   O(1)
public class Missing_Number {
    public static void main(String[] args) {
        int[] arr={3,0,1};
        System.out.println(missingNumber(arr));
    }
    //Method 1 using cyclic sort
    public static int missingNumber(int[] arr) {
        int i=0;
        while (i<arr.length){
            int correctIdx=arr[i];
            if (arr[i]<arr.length&&arr[i]!=arr[correctIdx]){    //arr[i] should be less than arr.length because if it is out of range then we have to skip it
                swap(arr,i,correctIdx);
            }else {
                i++;
            }
        }
        for(i=0;i<arr.length;i++){
            if(arr[i]!=i){
                return i;
            }
        }
        return arr.length;
    }
    private static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    //Method 2 using Summation Approach
    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }
}