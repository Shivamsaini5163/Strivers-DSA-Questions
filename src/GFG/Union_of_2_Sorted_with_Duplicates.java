package GFG;
import java.util.*;
public class Union_of_2_Sorted_with_Duplicates{
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> list=new ArrayList<>();
        int i=0;
        int j=0;
        int m=a.length;
        int n=b.length;
        while(i<m&&j<n){
            int last=list.size()-1;
            if(a[i]==b[j]){
                if(list.isEmpty()||list.get(last)!=a[i]){   // checking isEmpty because if not then .get(last) give exception
                    list.add(a[i]);
                }
                i++;
                j++;
            }else if(a[i]>b[j]){
                if(list.isEmpty()||list.get(last)!=b[j]){
                    list.add(b[j]);
                }
                j++;
            }else{
                if(list.isEmpty()||list.get(last)!=a[i]){
                    list.add(a[i]);
                }
                i++;
            }
        }
        // include remaining elements
        while(i<m){
            int last=list.size()-1;
            if(list.get(last)!=a[i]){
                list.add(a[i]);
            }
            i++;
        }
        while(j<n){
            int last=list.size()-1;
            if(list.get(last)!=b[j]){
                list.add(b[j]);
            }
            j++;
        }
        return list;
    }
}
