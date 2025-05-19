package Leetcode;
//leetcode 917
//Time and Space Complexity =>  O(N) O(N)
public class Reverse_Only_Letters {
    public static void main(String[] args) {
        String s="Test1ng-Leet=code-Q!";
        int l=0;
        int r=s.length()-1;
        char[] arr=s.toCharArray();
        while(l<r){
            if (isEnglish(arr[l])&&isEnglish(arr[r])){
                char temp=arr[l];
                arr[l]=arr[r];
                arr[r]=temp;
                l++;
                r--;
            }
            else {
                if (!isEnglish(arr[l])){
                    l++;
                }
                else if((!isEnglish(arr[r]))) {
                    r--;
                }
            }
        }
        String str=String.valueOf(arr);
        System.out.println(str);
    }

    private static boolean isEnglish(char c) {
        if ((65<=c&&c<=90)||(97<=c&&c<=122)){
            return true;
        }
        return false;
    }
}