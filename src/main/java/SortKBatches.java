import java.util.PriorityQueue;

public class SortKBatches {

    static LinkedListNode sort(int k, LinkedListNode list) {


        if (list == null || k <= 1) {
            return list;
        }

        PriorityQueue<Integer> kElements = new PriorityQueue<>();

        LinkedListNode tmp = list;
        LinkedListNode tmp1 = list;

        while (tmp != null) {
            if (kElements.size() == k) {
                while (!kElements.isEmpty()) {
                    tmp1.val = kElements.poll();
                    tmp1 = tmp1.next;
                }
            } else {
                kElements.add(list.val);
                tmp = tmp.next;
            }
        }

        while (!kElements.isEmpty()) {
            tmp1.val = kElements.poll();
            tmp1 = tmp1.next;
        }

        return list;
    }


    public static void main(String[] args) {

        LinkedListNode root = new LinkedListNode();
        root.val = 4;

        LinkedListNode tmp = root;
        for (int i = 3; i > 0; i--) {
            LinkedListNode linkedListNode = new LinkedListNode();
            linkedListNode.val = i;
            tmp.next = linkedListNode;
            tmp = tmp.next;
        }

        System.out.println();

        new SortKBatches().sort(3, root);
    }
}

class LinkedListNode {
    int val;
    LinkedListNode next;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }
}