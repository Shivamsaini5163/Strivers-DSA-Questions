package Array;

public class Rotated_Sorted_array_searching {
    public static void main(String[] args) {
        int[] arr={5,6,7,8,9,10,1,2,3};
        int ans=search(arr,0,arr.length-1,7);
        System.out.println(ans);
    }
    private static int search(int[] arr,int l,int h,int k){
        int p=getPivot(arr, l, h);  // pivot will be element 10 from the point where sudden decrease occur.
        int e=binarySearch(arr,0,p,k);  // searching from 5 to 10
        if (e==-1){
            e=binarySearch(arr,p+1,arr.length-1,k); // if not found then searching from 1 to 3
        }
        return e;
    }
    private static int getPivot(int[] arr,int l,int h){
        while(l<=h){
            int mid=l+(h-l)/2;
            if (arr[mid]>arr[mid+1]){   // like mid is 10 and mid+1 is 1
                return mid;
            } else if (arr[mid]<arr[mid-1]) {   // like mid is 1 and mid-1 is 10
                return mid-1;
            } else if (arr[mid] > arr[l]){      // like mid is 8 or 9 or 10 and l is 7 these elements are always greater than l
                l=mid+1;
            }else {                             // like mid is 2 or 3 and l is 7 these elements are always smaller or equal than l
                h=mid-1;
            }
        }
        return -1;
    }
    private static int binarySearch(int[] arr, int l, int h, int k){
        int mid=l+(h-l)/2;
        if (l>h||arr.length==0){
            return -1;
        }
        if (arr[mid]==k){
            return mid;
        } else if (arr[mid]<k) {
            return binarySearch(arr,mid+1,h,k);
        }else return binarySearch(arr,l,mid-1,k);
    }
}