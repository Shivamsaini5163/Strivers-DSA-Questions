package Leetcode;

import java.util.HashSet;
//leetcode 1496
//Time and Space Complexity =>    O(N) O(N)
public class Path_Crossing {
    public static void main(String[] args) {
        String path="NES";
        System.out.println(isPathCrossing(path));
    }
    public static boolean isPathCrossing(String path) {
        int x=0;
        int y=0;
        HashSet<String> set=new HashSet<>();
        set.add("0"+","+"0");
        for(char ch:path.toCharArray()){
            if(ch=='N'){
                y++;
            }
            else if(ch=='E'){
                x++;
            }
            else if(ch=='W'){
                x--;
            }
            else{
                y--;
            }
            if(set.contains(x+","+y)){
                return true;
            }
            set.add(x+","+y);
        }
        return false;
    }
}
