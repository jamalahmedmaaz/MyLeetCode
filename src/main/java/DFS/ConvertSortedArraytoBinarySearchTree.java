package DFS;

public class ConvertSortedArraytoBinarySearchTree {
    public static void main(String[] args) {
        ConvertSortedArraytoBinarySearchTree convertSortedArraytoBinarySearchTree = new ConvertSortedArraytoBinarySearchTree();
        int[] array = new int[]{-10, -3, 0, 5, 9};
        TreeNode treeNode = null;
        treeNode = convertSortedArraytoBinarySearchTree.sortedArrayToBST(array);
        System.out.println(treeNode);

    }

    public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) {
            return null;
        }
        return recursion(num, 0, num.length - 1);
    }

    public TreeNode recursion(int[] nums, int i, int j) {
        if (i > j) {
            return null;
        }

        int mid = i + (j - i) / 2;

        System.out.println(nums[mid]);
        TreeNode t = new TreeNode(nums[mid]);
        t.left = recursion(nums, i, mid - 1);
        t.right = recursion(nums, mid + 1, j);
        return t;
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
