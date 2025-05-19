package GFG;

import java.util.ArrayList;

public class K_th_element_of_two_Arrays {
    //Brute Force   Time=> O(m+n)   Space=> O(m+n)
    public int kthElement(int[] a, int[] b, int k) {
        int m=a.length;
        int n=b.length;
        int i=0;
        int j=0;
        ArrayList<Integer> list=new ArrayList<>();
        while(i<m&&j<n){
            if(a[i]<b[j]){
                list.add(a[i]);
                i++;
            }else{
                list.add(b[j]);
                j++;
            }
        }
        while(i<m){
            list.add(a[i]);
            i++;
        }
        while(j<n){
            list.add(b[j]);
            j++;
        }
        return list.get(k-1);
    }
    //Better Approach   Time=> O(m+n)   Space=> O(1)
    public int kthElement2(int[] a, int[] b, int k) {
        int m=a.length;
        int n=b.length;
        int i=0;
        int j=0;
        int count=0;
        int ele=-1;
        while(i<m&&j<n){
            if(a[i]<b[j]){
                if(k-1==count) ele= a[i];
                i++;
                count++;
            }else{
                if(k-1==count) ele= b[j];
                j++;
                count++;
            }
        }
        while(i<m){
            if(k-1==count) ele= a[i];
            i++;
            count++;
        }
        while(j<n){
            if(k-1==count) ele= b[j];
            j++;
            count++;
        }
        return ele;
    }
    //Optimised Approach   Time=> O(log(min(m,n))   Space=> O(1)
    //This Question is same as leetcode 4 Median_of_Two_Sorted_Arrays
    public int kthElement3(int[] a, int[] b, int k) {
        int m=a.length;
        int n=b.length;
        if(m>n) return kthElement3(b,a,k);
        //Now n is larger
        int low = Math.max(0, k - n), high = Math.min(k, m);    //to ensure that index not get out of bound
        int left=k;
        while(low<=high){
            int mid1=low+(high-low)/2;
            int mid2=left-mid1; //mid2 become can become -ve so for that we use high = Math.min(k, m) instead of high=m
            int l1=(mid1>0)?a[mid1-1]:Integer.MIN_VALUE;
            int l2=(mid2>0)?b[mid2-1]:Integer.MIN_VALUE;
            int r1=(mid1<m)?a[mid1]:Integer.MAX_VALUE;
            int r2=(mid2<n)?b[mid2]:Integer.MAX_VALUE;
            if(l1<=r2&&l2<=r1){
                return Math.max(l1,l2);
            }else if(l1>r2){
                high=mid1-1;
            }else{
                low=mid1+1; //this is case of l2>r1 so we need to exclude l2 so increase l1
            }
        }
        return -1;
    }
}
