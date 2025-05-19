package Leetcode;
//leetcode 1539
public class Kth_Missing_Positive_Number {
    //Brute Force O(N)
    public int findKthPositive(int[] arr, int k) {
        for(int i=0;i<arr.length;i++){
            if(arr[i]>k){
                return k;
            }
            k++;
        }
        return k;
    }
    //Optimal Approach
    public int findKthPositive2(int[] arr, int k) {
        int l=0;
        int h=arr.length-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            long missing=arr[mid]-mid-1;
            if(missing>=k){
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return k+h+1;   // arr[h]+(k-missing)       and missing will be arr[h]-h-1 after simplify we get this formula
    }
}
