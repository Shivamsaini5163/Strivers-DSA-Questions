package GFG;

public class Allocate_Minimum_Pages {
    //Brute Force   O(n*(sum - maxVal))  O(1)
    public static int findPages(int[] arr, int k) {
        if(k>arr.length){
            return -1;
        }
        int l=0;
        int h=0;
        for(int num:arr){
            l=Math.max(l,num);
            h+=num;
        }
        for(int i=l;i<=h;i++){
            if(countStudents(i,arr)<=k) return i;   //we can further split those student if counting students less than k so this is also valid condition
        }
        return -1;
    }
    private static int countStudents(int pagesAllowed,int[] arr){
        int pagesUsed=0;
        int student=1;
        for(int num:arr){
            pagesUsed+=num;
            if(pagesUsed>pagesAllowed){
                student++;
                pagesUsed=num;
            }
        }
        return student;
    }
    //Optimized Approach    O(n*log(sum - maxVal)))  O(1)
    public static int findPages2(int[] arr, int k) {
        if(k>arr.length){
            return -1;
        }
        int l=0;
        int h=0;
        for(int num:arr){
            l=Math.max(l,num);
            h+=num;
        }
        while(l<=h){
            int mid=l+(h-l)/2;
            if(countStudents(mid,arr)<=k) h=mid-1;
            else l=mid+1;
        }
        return l;
    }
}
