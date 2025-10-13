package GFG;

import java.util.ArrayList;

public class Root_to_Leaf_Paths {
    class Node
    {
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> allPaths=new ArrayList<>();
        getPaths(root,new ArrayList<>(),allPaths);
        return allPaths;
    }
    static void getPaths(Node root, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> allPaths){
        if(root==null) return;
        // Add current node
        path.add(root.data);
        // If leaf node → add to result
        if(root.left==null && root.right==null){
            allPaths.add(new ArrayList<>(path));
        }else{
            // Recurse left and right
            getPaths(root.left, path, allPaths);
            getPaths(root.right, path, allPaths);
        }
        // Backtrack
        path.remove(path.size()-1);
    }
}
