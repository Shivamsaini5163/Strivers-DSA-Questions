package GFG;
//Same as Allocate_Minimum_Pages(GFG)
public class The_Painter_Partition_Problem_II {
    public int minTime(int[] arr, int k) {
        int l=0;
        int h=0;
        for(int num:arr){
            l=Math.max(l,num);
            h+=num;
        }
        while(l<=h){
            int mid=l+(h-l)/2;
            if(count(mid,arr)<=k) h=mid-1;
            else l=mid+1;
        }
        return l;
    }
    private static int count(int pagesAllowed,int[] arr){
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
}
