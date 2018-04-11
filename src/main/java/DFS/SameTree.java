package DFS;

public class SameTree {
    public static void main(String[] args) {
        SameTree sameTree = new SameTree();
        sameTree.isSameTree(null, null);
    }


    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null && q != null) {
            return false;
        }

        if (q == null && p != null) {
            return false;
        }

        boolean left = isSameTree(p.left, q.left);
        if (p.val != q.val) {
            return false;
        }
        boolean right = isSameTree(p.right, q.right);

        return left && right;
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
