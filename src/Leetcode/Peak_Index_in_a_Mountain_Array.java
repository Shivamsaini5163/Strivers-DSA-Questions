package Leetcode;

public class Peak_Index_in_a_Mountain_Array {
//leetcode 852
//Time and Space Complexity =>    O(N) O(1)
    public static void main(String[] args) {
        int[] arr={1,2,3,5,7,6,3,2};
        System.out.println(peakIndexInMountainArray(arr));
    }
    public static int peakIndexInMountainArray(int[] arr) {
        int l=0;
        int h=arr.length-1;
        while (l<h){
            int mid=l+(h-l)/2;
            if (arr[mid]>arr[mid+1]){
                h=mid;
            } else {
                l=mid+1;
            }
        }
        return h;
    }
}
