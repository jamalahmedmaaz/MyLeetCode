package google;

import java.util.Random;


/***
 *
 *
 * HAVE SUBMITTED IN LEET CODE SAME SOLUTION BUT ONE WITH OPTIMIZATION
 *
 * CHECK SUBMISSION 1 AND OTHER SUBMISSIONS.
 *
 */

/**
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 */
public class MergeSortedLinkedList {

    public static void main(String[] args) {
        ListNode[] lists = createNNodes();
        ListNode node = new MergeSortedLinkedList().mergeKLists(lists);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    private static ListNode[] createNNodes() {
        ListNode l = new MergeSortedLinkedList().createNodes(1, 10);
        ListNode l1 = new MergeSortedLinkedList().createNodes(11, 20);


        ListNode[] listNodes = new ListNode[2];
        listNodes[0] = l;
        listNodes[1] = l1;

        return listNodes;
    }

    private ListNode createNodes(int min, int max) {
        ListNode root = null;
        ListNode tmp = null;
        for (int i = min; i < max; i++) {
            ListNode newNode = new ListNode(i);
            if (root == null) {
                tmp = newNode;
                root = tmp;
            } else {
                tmp.next = newNode;
                tmp = tmp.next;
            }
        }
        return root;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode newList = null;
        ListNode currentNode = null;
        while (true) {
            ListNode lowestValueNode = getLowestValueNode(lists);
            if (lowestValueNode == null) {
                break;
            }
            System.out.println(lowestValueNode.val);
            if (newList == null) {
                newList = lowestValueNode;
                currentNode = lowestValueNode;
            } else {
                currentNode.next = lowestValueNode;
                currentNode = currentNode.next;
            }
        }
        return newList;
    }

    private ListNode getLowestValueNode(ListNode[] lists) {
        ListNode tmpNode = null;
        int location = -1;
        for (int i = 0; i < lists.length + 1; i++) {
            if (tmpNode == null) {
                if (lists[i] != null) {
                    tmpNode = lists[i];
                    location = i;
                }
            } else {
                if (i == lists.length) {
                    lists[location] = lists[location].next;
                } else if (lists[i] != null && tmpNode.val > lists[i].val) {
                    tmpNode = lists[i];
                    location = i;
                }
            }
        }
        return tmpNode;
    }

    private boolean checkIfElementExists(ListNode[] lists) {
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                return true;
            }
        }
        return false;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
