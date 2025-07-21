package Leetcode;
//leetcode 79
//  O(m*n*4^k)      O(k)
public class Word_Search {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        return helper(board,m,n,word);
    }
    boolean helper(char[][] board,int m,int n, String word){
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                //linear search for starting symbol
                if(word.charAt(0)==board[row][col]){
                    if(solveNext(board,row,col,m,n,word,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    boolean solveNext(char[][] board,int row,int col,int m,int n, String word,int idx){
        if(idx==word.length()){
            return true;
        }
        if(row<0||col<0||row==m||col==n||board[row][col]!=word.charAt(idx)||board[row][col]=='!'){
            return false;
        }
        //check in all four direction
        char c=board[row][col];
        board[row][col]='!';    //means this block already visited so can't reuses it
        //top direction
        boolean top=solveNext(board,row-1,col,m,n,word,idx+1);
        //right direction
        boolean right=solveNext(board,row,col+1,m,n,word,idx+1);
        //bottom direction
        boolean bottom=solveNext(board,row+1,col,m,n,word,idx+1);
        //left direction
        boolean left=solveNext(board,row,col-1,m,n,word,idx+1);
        //undo change
        board[row][col]=c;
        //check if any one direction works or not in last
        return top || right || bottom || left;
    }
}
