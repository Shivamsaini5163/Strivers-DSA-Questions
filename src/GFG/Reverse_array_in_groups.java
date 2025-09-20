package GFG;

public class Reverse_array_in_groups {
    public void reverseInGroups(int[] arr, int k) {
        int n=arr.length;
        int i=0;
        while(i+k-1<n){
            reverseArray(arr,i,i+k-1);
            i+=k;
        }
        if(i<n){
            reverseArray(arr,i,n-1);
        }
    }
    public void reverseArray(int[] arr,int l,int r) {
        while(l<r){
            int temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            l++;
            r--;
        }
    }
}
