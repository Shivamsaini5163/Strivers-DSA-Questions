package Leetcode;

import java.util.ArrayList;
import java.util.List;
//leetcode 118
public class Pascals_Triangle {
    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(generate1(4,3));
        System.out.println(generate2(5));
        System.out.println(generate3(numRows));
    }
    // Variation 1 print particular element
    //O(C)
    public static int generate1(int r,int c){
        int element = (int) nCr(r - 1, c - 1);
        return element;
    }
    private static long nCr(int n, int r) {
        long res = 1;
        // calculating nCr:
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }
    // Variation 2 print particular row
    //O(R)
    public static List<Integer> generate2(int r){
        int res=1;
        List<Integer> list=new ArrayList<>();
        list.add(res);
        for (int i = 1; i < r; i++) {
            res=res*(r-i);
            res=res/i;
            list.add(res);
        }
        return list;
    }
    // Variation 3 print Pascal's Triangle
    //O(R^2)
    public static List<List<Integer>> generate3(int numRows) {
        List<List<Integer>> list= new ArrayList<>();
        for (int r = 1; r <= numRows; r++) {
            int res=1;
            List<Integer> temp=new ArrayList<>();
            temp.add(res);
            for (int i = 1; i < r; i++) {
                res=res*(r-i);
                res=res/i;
                temp.add(res);
            }
            list.add(temp);
        }
        return list;
    }
}
