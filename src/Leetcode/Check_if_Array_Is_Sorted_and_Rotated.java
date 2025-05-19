package Leetcode;
//leetcode 1752
//Time and Space Complexity =>    O(N) O(1)
public class Check_if_Array_Is_Sorted_and_Rotated{
    //My Code
    public boolean check(int[] nums) {
        int i;
        int n=nums.length;
        for(i=1;i<n;i++){
            if(nums[i-1]>nums[i]){
                break;
            }
        }
        if(i==n){
            return true;
        }
        for(int j=0;j<n-1;j++){
            if(nums[i%n]>nums[(i+1)%n]){
                return false;
            }
            i++;
        }
        return true;
    }
    // ChatGPT code using less number of lines
    public boolean check2(int[] nums) {
        int n = nums.length;
        int count = 0; // This will count the number of breaks in the sorted order

        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) {
                count++;
            }
        }

        // If there is more than one break, it's not a valid rotation
        if (count > 1) {
            return false;
        }

        // If there is no break, or there is one break, we just need to check
        // if the last element is less than or equal to the first element (for rotation)
        return count == 0 || nums[n - 1] <= nums[0];
    }
}
