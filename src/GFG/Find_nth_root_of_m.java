package GFG;

public class Find_nth_root_of_m {
    //Brute Force
    public int nthRoot(int n, int m) {
        for(int i=1;i<=m;i++){
            int res=1;
            for(int j=1;j<=n;j++){
                res*=i;
            }
            if(res==m){
                return i;
            }else if(res>m){
                return -1;
            }
        }
        return -1;
    }
    //Optimised Approach
    public int nthRoot2(int n, int m) {
        long l=0;
        long h=m;
        while(l<=h){
            long mid=l+(h-l)/2;
            long value=1;
            for(int i=1;i<=n;i++){
                value*=mid;
            }
            if(value==m){
                return (int)mid;
            }else if(value>m){
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return -1;
    }
}
