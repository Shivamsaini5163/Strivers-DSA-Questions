package Leetcode;
//leetcode 37
//  O(9^81)
public class Sudoku_Solver {
    public void solveSudoku(char[][] board) {
        helper(board);
    }
    boolean helper(char[][] board){
        int n=board.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='.'){
                    for(char ch='1';ch<='9';ch++){
                        if(isSafe(board,ch,i,j)){
                            board[i][j]=ch;
                            if(helper(board)){
                                return true;
                            }else{
                                board[i][j]='.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    boolean isSafe(char[][] board,char ch,int row, int col){
        for(int i=0;i<9;i++){
            if(ch==board[row][i]){
                return false;
            }
            if(ch==board[i][col]){
                return false;
            }
            if(ch==board[3*(row/3)+i/3][3*(col/3)+i%3]){
                return false;
            }
        }
        return true;
    }
}
