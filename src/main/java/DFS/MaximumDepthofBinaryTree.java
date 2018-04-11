package DFS;

public class MaximumDepthofBinaryTree {
    public static void main(String[] args) {
        MaximumDepthofBinaryTree maximumDepthofBinaryTree = new MaximumDepthofBinaryTree();
        maximumDepthofBinaryTree.maxDepth(null);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
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
