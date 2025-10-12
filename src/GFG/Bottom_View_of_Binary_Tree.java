package GFG;

import java.util.*;

// almost same as top view of binary tree
public class Bottom_View_of_Binary_Tree {
    class Node {
        int data;
        Node left, right;

        Node(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }
    private class Tuple {
        Node node;
        int col;

        Tuple(Node node, int col) {
            this.node = node;
            this.col = col;
        }
    }
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        // TreeMap keeps keys sorted
        Map<Integer, Integer> map = new TreeMap<>(); // col -> node.data
        Queue<Tuple> queue = new LinkedList<>();

        queue.add(new Tuple(root, 0));
        while(!queue.isEmpty()){
            Tuple t=queue.poll();
            Node curr=t.node;
            int col=t.col;
            // For bottom view, keep updating value for each col
            map.put(col,curr.data);
            // Left and right children with updated col
            if(curr.left!=null) queue.add(new Tuple(curr.left,col-1));
            if(curr.right!=null) queue.add(new Tuple(curr.right,col+1));
        }
        // Collect result from leftmost to rightmost col
        // Since it is TreeMap so keys are stored in sorted order
        for(int val:map.values()){
            result.add(val);
        }
        return result;
    }
}
