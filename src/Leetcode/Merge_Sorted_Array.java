package Leetcode;
//leetcode 88
public class Merge_Sorted_Array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;  // k maintains index to put in array
        //start from last and put greater one in the end
        while (i >= 0 && j >= 0) {
            if (nums2[j] > nums1[i]) {
                nums1[k--] = nums2[j];
                j--;
            } else {
                nums1[k--] = nums1[i];
                i--;
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j];
            j--;
        }
    }
}
