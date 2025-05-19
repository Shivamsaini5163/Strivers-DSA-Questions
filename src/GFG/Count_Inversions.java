package GFG;
import java.util.*;
public class Count_Inversions {
    //Brute Force   O(N^2)  O(1)
    static int inversionCount(int[] arr) {
        int cnt=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(arr[i]>arr[j]){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    //Optimized Approach    O(NlogN)   O(N)
    static int inversionCount2(int[] arr) {
        return merge_sort(arr,0,arr.length-1);
    }
    private static int merge_sort(int[] arr,int l,int h){
        int cnt=0;
        if(l<h){
            int mid=l+(h-l)/2;
            cnt+=merge_sort(arr,l,mid);
            cnt+=merge_sort(arr,mid+1,h);
            cnt+=merge(arr,l,mid,h);
        }
        return cnt;
    }
    private static int merge(int[] arr,int l,int mid,int h){
        ArrayList<Integer> temp=new ArrayList<>();
        int left=l;
        int right=mid+1;
        int cnt = 0;
        while(left<=mid&&right<=h){
            if(arr[left]<=arr[right]){
                temp.add(arr[left]);
                left++;
            }else{
                temp.add(arr[right]);
                cnt+=mid-left+1;
                right++;
            }
        }
        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }
        while(right<=h){
            temp.add(arr[right]);
            right++;
        }
        for (int i = l; i <= h; i++) {
            arr[i] = temp.get(i - l);
        }
        return cnt;
    }
}
