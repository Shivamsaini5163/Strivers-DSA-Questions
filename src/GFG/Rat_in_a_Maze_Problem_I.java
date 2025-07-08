package GFG;

import java.util.ArrayList;

public class Rat_in_a_Maze_Problem_I{
    //  O(4^(m*n))      O(m*n)
    //Brute Force
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> list=new ArrayList<>();
        int n=maze.length;
        int[][] visited=new int[n][n];
        helper(maze,visited,0,0,list,"",n);
        return list;
    }
    void helper(int[][] maze,int[][] visited,int row,int col,ArrayList<String> list,String ans,int n){
        if(row==n-1&&col==n-1){
            list.add(ans);
            return;
        }
        if(row+1<n&&maze[row+1][col]!=0&&visited[row+1][col]==0){
            visited[row][col]=1;
            helper(maze,visited,row+1,col,list,ans+"D",n);    //Down
            visited[row][col]=0;
        }
        if(0<=col-1&&maze[row][col-1]!=0&&visited[row][col-1]==0){
            visited[row][col]=1;
            helper(maze,visited,row,col-1,list,ans+"L",n);    //Left
            visited[row][col]=0;
        }
        if(col+1<n&&maze[row][col+1]!=0&&visited[row][col+1]==0){
            visited[row][col]=1;
            helper(maze,visited,row,col+1,list,ans+"R",n);    //Right
            visited[row][col]=0;
        }
        if(row-1>=0&&maze[row-1][col]!=0&&visited[row-1][col]==0){
            visited[row][col]=1;
            helper(maze,visited,row-1,col,list,ans+"U",n);    //Up
            visited[row][col]=0;
        }
    }

}
