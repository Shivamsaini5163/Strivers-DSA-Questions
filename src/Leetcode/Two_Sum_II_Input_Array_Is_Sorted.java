package Leetcode;

//leetcode 167
//Time and Space Complexity =>    O(N) O(1)
public class Two_Sum_II_Input_Array_Is_Sorted {
    public int[] twoSum(int[] numbers, int target) {
        int l=0;
        int r=numbers.length-1;
        while(l!=r){
            if(numbers[l]+numbers[r]==target){
                return new int[]{l+1,r+1};
            }
            else if(numbers[l]+numbers[r]<target){
                l++;
            }
            else{
                r--;
            }
        }
        return null;
    }
}
