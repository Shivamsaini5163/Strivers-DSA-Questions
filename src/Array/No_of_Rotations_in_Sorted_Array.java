package Array;

public class No_of_Rotations_in_Sorted_Array {
    public static void main(String[] args) {
        int[] arr={7,8,1,2,3,4,5,6};
        System.out.println(find(arr));
    }
    private static int find(int[] arr){
        int p=getPivot(arr);
        return (p+1)% arr.length;
    }
    private static int getPivot(int[] arr){
        int l=0;
        int h=arr.length-1;
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
}
