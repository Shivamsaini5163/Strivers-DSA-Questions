package Leetcode;

import java.util.ArrayList;
import java.util.List;

//leetcode 257
public class Binary_Tree_Paths {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> allPaths=new ArrayList<>();
        getPaths(root,"",allPaths);
        return allPaths;
    }
    static void getPaths(TreeNode root, String path, ArrayList<String> allPaths){
        if(root==null) return;
        // Add current node
        path+=root.val;
        // If leaf node → add to result
        if(root.left==null && root.right==null){
            allPaths.add(path);
        }
        else{
            // Recurse left and right
            // Otherwise, continue exploring children
            path += "->";
            getPaths(root.left, path, allPaths);
            getPaths(root.right, path, allPaths);
        }
        // no Backtrack step needed because string is immutable each call have its own string value
    }
}
