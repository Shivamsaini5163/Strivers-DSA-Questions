package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//leetcode 51
//  Time=>  O(N!)   	Space(Board)=> O(n²)   Space (Call Stack)=> O(n)    Space(Output)=> O(k*n²)
//Brute Force
public class N_Queens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list=new ArrayList<>();
        char[][] board = new char[n][n];
        // Initialize board with '.'
        for (int i = 0; i < n; i++)
            Arrays.fill(board[i], '.');

        helper(n,list,board,0);
        return list;
    }
    void helper(int n,List<List<String>> list,char[][] board,int col){
        if(col==n){
            list.add(construct(board));
            return;
        }
        for(int row=0;row<n;row++){
            if(isSafe(board,row,col,n)){
                board[row][col]='Q';
                helper(n,list,board,col+1);
                board[row][col]='.';
            }
        }
    }
    List<String> construct(char[][] board){
        List<String> ans=new ArrayList<>();
        for(char[] row:board){
            ans.add(new String(row));
        }
        return ans;
    }
    boolean isSafe(char[][] board,int row,int col,int n){
        //check row
        for (int i = 0; i < col; i++)
            if (board[row][i] == 'Q') return false;
        // check upper-left diagonal
        for (int i = row,j=col; i>=0&&j>=0; i--,j--)
            if (board[i][j] == 'Q') return false;
        // check lower-left diagonal
        for (int i = row,j=col; i<n&&j>=0; i++,j--)
            if (board[i][j] == 'Q') return false;
        return true;
    }
    //Optimized Approach
    //Using Hash Storages to trace the occupied position
    public List<List<String>> solveNQueens2(int n) {
        List<List<String>> list=new ArrayList<>();
        char[][] board = new char[n][n];
        // Initialize board with '.'
        for (int i = 0; i < n; i++)
            Arrays.fill(board[i], '.');
        helper(n,list,board);
        return list;
    }
    void helper(int n,List<List<String>> list,char[][] board){
        int[] leftRow=new int[n];
        int[] upperDiagonal=new int[2*n-1];
        int[] lowerDiagonal=new int[2*n-1];
        solve(board,list,0,leftRow,upperDiagonal,lowerDiagonal);
    }
    void solve(char[][] board,List<List<String>> list,int col,int[] leftRow,int[] upperDiagonal,int[] lowerDiagonal){
        if(col==board.length){
            list.add(construct(board));
            return;
        }
        for(int row=0;row<board.length;row++){
            if(leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[board.length - 1 + col - row] == 0){
                board[row][col]='Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[board.length - 1 + col - row] = 1;
                solve(board,list,col+1,leftRow,upperDiagonal,lowerDiagonal);
                board[row][col]='.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[board.length - 1 + col - row] = 0;
            }
        }
    }
}
