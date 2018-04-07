package google;

public class MakeTreefromInorderAndPreorder {
    public static int pIndex = 0;

    public static void main(String[] args) throws java.lang.Exception {
        int[] inOrder = {13, 5, 43, 11, 41, 2, 23, 17, 29, 47, 37, 3, 7, 31, 19};
        int[] preOrder = {37, 41, 43, 13, 5, 11, 29, 23, 2, 17, 47, 7, 3, 19, 31};
        MakeTreefromInorderAndPreorder i = new MakeTreefromInorderAndPreorder();
        Node x = i.makeBTree(inOrder, preOrder, 0, inOrder.length - 1);
        System.out.println("Constructed Tree : ");
        i.printINORDER(x);
    }

    public Node makeBTree(int[] inOrder, int[] preOrder, int iStart, int iEnd) {
        if (iStart > iEnd) {
            return null;
        }
        Node root = new Node(preOrder[pIndex]);
        pIndex++;

        if (iStart == iEnd) {
            return root;
        }
        int index = getInorderIndex(inOrder, iStart, iEnd, root.data);
        root.left = makeBTree(inOrder, preOrder, iStart, index - 1);
        root.right = makeBTree(inOrder, preOrder, index + 1, iEnd);
        //}
        return root;
    }

    public int getInorderIndex(int[] inOrder, int start, int end, int data) {
        for (int i = start; i <= end; i++) {
            if (inOrder[i] == data) {
                return i;
            }
        }
        return -1;
    }

    public void printINORDER(Node root) {
        if (root != null) {
            printINORDER(root.left);
            printINORDER(root.right);
            System.out.print("  " + root.data);
        }
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}