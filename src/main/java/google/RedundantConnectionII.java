package google;

import java.util.*;

public class RedundantConnectionII {
    public static void main(String[] args) {
        int[][] e = {
                {2, 1},
                {3, 1},
                {4, 2},
                {1, 4}
        };
        System.out.println(Arrays.toString(new RedundantConnectionII().findRedundantDirectedConnection(e)));
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] array = new int[1000000];

        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            int[] element = edges[i];
            int parent = element[0];
            int child = element[1];

            if (array[parent] != child && array[parent] != array[child]) {
                if (array[child] == child) {
                    array[child] = array[parent];
                } else {
                    return element;
                }
            } else {
                return element;
            }
        }


        return null;
    }
}
