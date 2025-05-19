package Leetcode;

import java.util.*;
//leetcode 4
public class Median_of_Two_Sorted_Arrays {
    //Brute Force   Time O(n1+n2)   Space O(n1+n2)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        List<Integer> list=new ArrayList<>();
        int i=0,j=0;
        //merge both list
        while(i<m&&j<n){
            if(nums1[i]<nums2[j]){
                list.add(nums1[i]);
                i++;
            }
            else{
                list.add(nums2[j]);
                j++;
            }
        }
        while(i<m){
            list.add(nums1[i]);
            i++;
        }
        while(j<n){
            list.add(nums2[j]);
            j++;
        }
        if(list.size()%2==1){
            return (double)list.get(list.size()/2);
        }
        int a=list.get(list.size()/2-1);
        int b=list.get(list.size()/2);
        return (double)(a+b)/2;
    }
    //Better Approach Without Space Complexity but still time complexity is O(n1+n2)
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int total=m+n;
        int i=0,j=0,cnt=0;
        int idx1OG=total/2;
        int idx2OG=idx1OG-1;
        int idx1=-1;
        int idx2=-1;
        //merge both list imaginary using pointer and find x and x-1 position elements to find median in the last
        while(i<m&&j<n){
            if(nums1[i]<nums2[j]){
                if(idx1OG==cnt) idx1=nums1[i];
                if(idx2OG==cnt) idx2=nums1[i];
                cnt++;
                i++;
            }
            else{
                if(idx1OG==cnt) idx1=nums2[j];
                if(idx2OG==cnt) idx2=nums2[j];
                cnt++;
                j++;
            }
        }
        while(i<m){
            if(idx1OG==cnt) idx1=nums1[i];
            if(idx2OG==cnt) idx2=nums1[i];
            cnt++;
            i++;
        }
        while(j<n){
            if(idx1OG==cnt) idx1=nums2[j];
            if(idx2OG==cnt) idx2=nums2[j];
            cnt++;
            j++;
        }
        if(total%2==1){
            return (double) idx1;
        }
        return (double) ((idx1+idx2))/2.0;
    }
    //Optimal Approach  O(log N)
    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        if(m>n) return findMedianSortedArrays3(nums2,nums1);    // we need to make sure that binary search applied on shorter array
        int low=0;//means include no element include from nums1
        int high=m;//means include all element include from nums1
        int left=(m+n+1)/2; //means what we need in left no. of elements of nums1 and nums2
        while(low<=high){
            int mid1=low+(high-low)/2;  //no. of elements pick from nums1
            int mid2=left-mid1;         //no. of elements pick from nums2
            int l1=(mid1>0)?nums1[mid1-1]:Integer.MIN_VALUE;
            int l2=(mid2>0)?nums2[mid2-1]:Integer.MIN_VALUE;
            int r1=(mid1<m)?nums1[mid1]:Integer.MAX_VALUE;
            int r2=(mid2<n)?nums2[mid2]:Integer.MAX_VALUE;
            if(l1<=r2&&l2<=r1){
                if((m+n)%2==1)  return Math.max(l1,l2);
                return (double)(Math.max(l1,l2)+Math.min(r1,r2))/2.0;
            }else if(l1>r2){
                high=mid1-1;
            }else{
                low=mid1+1; //this is case of l2>r1 so we need to exclude l2 so increase l1
            }
        }
        return -1;
    }
}
