package GFG;

import java.util.*;

// leetcode 199
public class Binary_Tree_Right_Side_View {
    static class Tuple {
        TreeNode node;
        int row;

        Tuple(TreeNode node, int row) {
            this.node = node;
            this.row = row;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root==null) return result;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        Queue<Tuple> queue=new LinkedList<>();
        queue.add(new Tuple(root,0));
        while(!queue.isEmpty()){
            Tuple t=queue.poll();
            TreeNode curr=t.node;
            int row=t.row;
            map.put(row,curr.val);
            if(curr.left!=null) queue.add(new Tuple(curr.left,row+1));
            if(curr.right!=null) queue.add(new Tuple(curr.right,row+1));
        }
        for(int val:map.values()){
            result.add(val);
        }
        return result;
    }
    // Best and Simple Approach
    // Use BFS level by level traversal and add last node of each level in result
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root==null) return result;

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode curr=queue.poll();
                // last node in this level → rightmost node
                if(i==size-1){
                    result.add(curr.val);
                }
                if(curr.left!=null) queue.add(curr.left);
                if(curr.right!=null) queue.add(curr.right);
            }
        }

        return result;
    }
}
