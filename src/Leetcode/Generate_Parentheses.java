package Leetcode;

import java.util.ArrayList;
import java.util.List;
//leetcode 22
public class Generate_Parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        generate(n,n,list,"");
        return list;
    }
    void generate(int open,int closed,List<String> list,String ans){
        if(open==0&&closed==0){
            list.add(ans);
            return;
        }
        if(open>0){
            //one open bracket used
            generate(open-1,closed,list,ans+"(");
        }
        if(closed>0&&closed>open){
            //one closed bracket used
            //and closed used when more open bracket already used
            generate(open,closed-1,list,ans+")");
        }
    }
}
