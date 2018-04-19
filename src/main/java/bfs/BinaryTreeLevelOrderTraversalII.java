package bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {
    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversalII binaryTreeLevelOrderTraversalII = new BinaryTreeLevelOrderTraversalII();
        binaryTreeLevelOrderTraversalII.levelOrderBottom(null);
    }


    //Actually this is not a good solution, we need to find the height of the tree,
    // Then create the outer list with that size.
    // And then during execution add elements in reverse order to the inner list.
    //Will try later


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, 0, result);
        Collections.reverse(result);
        return result;
    }

    public void helper(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        level = level + 1;

        if (result.size() < level) {
            result.add(new ArrayList<>());
        }

        if (root.left != null) {
            helper(root.left, level, result);
        }

        if (root.right != null)
            helper(root.right, level, result);

        if (result.get(level - 1) == null) {
            List<Integer> tlevel = new ArrayList<>();
            tlevel.add(root.val);
            result.set(level - 1, tlevel);
        } else {
            result.get(level - 1).add(root.val);
        }

    }


    public class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;


        TreeNode(int x) {
            val = x;
        }

    }
}
