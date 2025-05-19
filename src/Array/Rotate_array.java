package Array;

import java.util.Arrays;

public class Rotate_array {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        rotate(arr,-1);
        System.out.println(Arrays.toString(arr));
    }
    private static void rotate(int[] arr, int k){
        if (k%arr.length==0){
            return;
        }
        int rotation=k%arr.length;
        if (k<0){
            rotation+=arr.length;
        }
        //right rotation
        reverse(arr,0,arr.length-1);
        reverse(arr,0,rotation-1);
        reverse(arr, rotation, arr.length-1 );

        //left rotation
//        reverse(arr,0,rotation-1);
//        reverse(arr, rotation, arr.length-1 );
//        reverse(arr,0,arr.length-1);
    }
    private static void reverse(int[] arr,int l,int h){
        while(l<h){
            int temp=arr[l];
            arr[l]=arr[h];
            arr[h]=temp;
            l++;
            h--;
        }
    }
}
