package GFG;

import java.util.ArrayList;
import java.util.List;

//  O((M^V)*V)          O(V+E)
public class M_Coloring_Problem {
    boolean graphColoring(int v, int[][] edges, int m) {
        List<List<Integer>> adj=new ArrayList<>();
        //converting edges array into Arraylist to maintain trace of all adjacent vertices for each vertex
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return helper(0,v,adj,m,new int[v]);
    }
    boolean helper(int node, int v, List<List<Integer>> adj, int m, int[] color){
        if(node==v) return true;
        //check every color for particular node
        for(int c=1;c<=m;c++){
            if(isSafe(node,adj,color,c)){
                color[node]=c;
                if(helper(node+1,v,adj,m,color)) return true;
                color[node]=0;
            }
        }
        return false;
    }
    boolean isSafe(int node,List<List<Integer>> adj,int[] color,int c){
        for(int neighbor:adj.get(node)){
            if(color[neighbor]==c) return false;
        }
        return true;
    }
}
