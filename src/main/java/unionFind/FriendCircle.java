package unionFind;

import java.util.*;

public class FriendCircle {

    public static void main(String[] args) {
        FriendCircle friendCircle = new FriendCircle();
        /*System.out.println(friendCircle.findCircleNum(new int[][]
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
                {0, 0, 1}}));*/


        System.out.println(friendCircle.bfsOnAdjMatrix(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));

        System.out.println(friendCircle.bfsOnAdjMatrix(new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}}));

        System.out.println(friendCircle.bfsOnAdjMatrix(new int[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}}));


    }


    public int bfsOnAdjMatrix(int[][] elements) {

        int union[] = new int[elements.length];
        Arrays.fill(union, -1);


        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {

                if (elements[i][j] == 1) {

                    if (union[j] == -1) {
                        union[j] = i;
                    } else if (union[j] != -1 && union[j] != j) {
                        findAndFill(union, i, j);
                    }

                }

            }
        }

        Set<Integer> uno = new HashSet<>();

        for (int i : union) {
            uno.add(i);
        }
        uno.remove(-1);

        return uno.size();
    }

    private void findAndFill(int[] union, int i, int j) {
        int currentIndexToCheckAndFill = j;

        List<Integer> integers = new ArrayList<>();
        integers.add(currentIndexToCheckAndFill);
        while (union[currentIndexToCheckAndFill] != currentIndexToCheckAndFill && union[currentIndexToCheckAndFill] != i) {
            currentIndexToCheckAndFill = union[currentIndexToCheckAndFill];
            integers.add(currentIndexToCheckAndFill);
        }

        for (int ins : integers) {
            union[ins] = i;
        }

    }

    private int findStartElement(int[][] elements) {

        for (int i = 0; i < elements.length; i++)
            for (int j = 0; j < elements[i].length; j++)
                if (elements[i][j] == 1 && i == j) {
                    return i;
                }

        return 0;
    }

    private int findCircleNum2(int[][] ints) {


        Map<Integer, Set<Integer>> sets = new HashMap<>();


        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {

                if (ints[i][j] == 1)
                    if (sets.containsKey(i)) {
                        sets.get(i).add(j);
                    } else {
                        Set<Integer> integers = new HashSet<>();
                        integers.add(j);
                        sets.put(i, integers);
                    }
            }
        }

        for (Integer integerSetEntry : sets.keySet()) {
            Set<Integer> map = sets.get(integerSetEntry);

            for (Map.Entry<Integer, Set<Integer>> i : sets.entrySet()) {
                if (i.getKey().equals(integerSetEntry)) {
                    i.getValue().removeAll(map);
                }
            }
        }

        sets.keySet().removeIf(str -> sets.get(str).size() == 0);


        return sets.size();
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
