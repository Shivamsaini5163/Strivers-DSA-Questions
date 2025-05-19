package Leetcode;
//leetcode 162
//Time and Space Complexity =>    O(NlogN) O(1)
public class find_Peak_Element {
    public int findPeakElement(int[] arr) {
        int s=0;
        int e=arr.length-1;
        while (s < e) {
            int m = s + (e - s) / 2;
            if (arr[m] > arr[m+1])
                e= m;
            else
                s = m+1;
        }
        //return s or e doesn't matter both are equal
        return e;
    }
    //more simple code use this one
    public int findPeakElement2(int[] arr) {
        int n=arr.length;
        if(n==1||arr[0]>arr[1]){    //if first index is ans
            return 0;
        }
        if(arr[n-1]>arr[n-2]){      //if last index is ans
            return n-1;
        }
        //exclude first and last index in range
        int l=1;
        int h=arr.length-2;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(arr[mid]>arr[mid-1]&&arr[mid]>arr[mid+1]){
                return mid;
            }else if(arr[mid]>arr[mid-1]){
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        return -1;
    }
}
