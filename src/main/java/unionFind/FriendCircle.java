package unionFind;

import java.util.*;

public class FriendCircle {

    public static void main(String[] args) {
        FriendCircle friendCircle = new FriendCircle();
        System.out.println(friendCircle.findCircleNum(new int[][]
                {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}}));


        System.out.println(friendCircle.findCircleNum(new int[][]
                {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 1}}));


        System.out.println(friendCircle.findCircleNum(new int[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}}));
        System.out.println(friendCircle.findCircleNum(new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}}));

    }

    public int findCircleNum(int[][] M) {
        System.out.println(Arrays.deepToString(M));
        if (M.length == 0 || M[0].length == 0) {
            return 0;
        }

        Integer union[] = new Integer[Math.max(M.length, M[0].length)];

        for (int i = 0; i < union.length; i++) {
            union[i] = i;
        }


        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                if (i != j && M[i][j] == 1) {
                    markChildAndItsParentWithCurrentParent(union, i, j);
                }

            }
        }
//        System.out.println(Arrays.toString(union));

        HashSet<Integer> s = new HashSet<>(Arrays.asList(union));
        s.remove(-1);

//        for (int i : s) {
//            System.out.println(i);
//        }


        return s.size();
    }

    private void markChildAndItsParentWithCurrentParent(Integer[] union, int parentIndex, int childIndex) {
        if (union[childIndex] != childIndex) {
            int tmpChildIndex = childIndex;
            List<Integer> integers = new ArrayList<>();
            while (true) {
                integers.add(tmpChildIndex);
                if (tmpChildIndex != union[tmpChildIndex])
                    tmpChildIndex = union[tmpChildIndex];
                else
                    break;
            }

            for (int i : integers) {
                union[i] = union[parentIndex];
            }

        } else {
            union[childIndex] = parentIndex;
        }
    }

}
