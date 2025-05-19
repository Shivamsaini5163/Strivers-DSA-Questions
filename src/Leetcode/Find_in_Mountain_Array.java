package Leetcode;

//leetcode 1095
//Time and Space complexity => O(logN) O(1)
public class Find_in_Mountain_Array {
    public static int findInMountainArray(int target, MountainArray mountainArr){
        int peak=peakIndexInMountainArray(mountainArr);
        int idx=orderAgnosticBS(mountainArr,target,0,peak);
        if (idx!=-1){
            return idx;
        }
        return orderAgnosticBS(mountainArr,target,peak+1,mountainArr.length()-1);
    }
    private static int peakIndexInMountainArray(MountainArray mountainArr) {
        int l=0;
        int h=mountainArr.length()-1;
        while (l<h){
            int mid=l+(h-l)/2;
            if (mountainArr.get(mid)>mountainArr.get(mid+1)){
                h=mid;
            } else {
                l=mid+1;
            }
        }
        return h;
    }
    private static int orderAgnosticBS(MountainArray mountainArr, int target,int start,int end) {

        // find whether the array is sorted in ascending or descending
        boolean isAsc = mountainArr.get(start) < mountainArr.get(end);

        while(start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if (mountainArr.get(mid) == target) {
                return mid;
            }

            if (isAsc) {
                if (target < mountainArr.get(mid)) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > mountainArr.get(mid)) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
//dont include this in ans it is provide already in build in question
interface MountainArray {
    public int get(int index);
    public int length();
}
