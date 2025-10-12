package Leetcode;

import java.util.*;

//leetcode 987
public class Vertical_Order_Traversal_of_a_Binary_Tree {
    static class Tuple {
        TreeNode node;
        int row, col;

        Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<int[]>> map = new TreeMap<>(); // col -> [(row, val)]
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));
        while (!q.isEmpty()) {
            Tuple t = q.poll();
            if (!map.containsKey(t.col)) {
                map.put(t.col, new ArrayList<>());
            }
            map.get(t.col).add(new int[] { t.row, t.node.val });
            if (t.node.left != null)
                q.offer(new Tuple(t.node.left, t.row + 1, t.col - 1));
            if (t.node.right != null)
                q.offer(new Tuple(t.node.right, t.row + 1, t.col + 1));
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (List<int[]> list : map.values()) {
            list.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]); // if both element are on same horizontal level then sort them in increasing order otherwise sort on the basis of top to down vertical level
            List<Integer> colVals = new ArrayList<>();
            for (int[] x : list)
                colVals.add(x[1]);
            ans.add(colVals);
        }

        return ans;
    }
}
