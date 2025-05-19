package Array;

public class Search_in_an_infinite_sorted_array {
    public static void main(String[] args) {
        int[] arr = {9, 11, 17, 26, 37, 52, 89, 111, 129, 144, 198};
        int target=52;
        System.out.println(search(arr,target));
    }
    public static int search(int[] arr,int target){
        int s=0;
        int e=1;
        //Finding range by just doubling range every time
        while (target>arr[e]){
            int temp=e+1;
            e=e+2*(e-s+1);
            s=temp;
        }
        return binarySearch(arr,target,s,e);
    }
    public static int binarySearch(int[] nums,int target,int s,int e){
        while(s<=e){
            int mid=s+(e-s)/2;
            if (target==nums[mid]){
                return mid;
            } else if (target>nums[mid]) {
                s=mid+1;
            }else {
                e=mid-1;
            }
        }
        return -1;
    }
}
