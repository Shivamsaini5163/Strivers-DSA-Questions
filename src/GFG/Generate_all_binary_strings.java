package GFG;


import java.util.ArrayList;
import java.util.List;

public class Generate_all_binary_strings {
    //  O(2^N)       O(N)
    public static List<String> generateBinaryStrings(int n) {
        List<String> list=new ArrayList<>();
        generate(list,n,"",false);
        return list;
    }
    public static void generate(List<String> list,int n,String ans,boolean lastOne){
        if(n==ans.length()){
            list.add(ans);
            return;
        }
        //Adding 0 in the String
        generate(list,n,ans+"0",false);
        //Adding 1 in the String
        //And prevent consecutive ones
        if(!lastOne){
            generate(list,n,ans+"1",true);
        }
    }
}