package graph;

import java.util.Arrays;

/**
 * Created by jamal on 8/4/18.
 */
public class RedundantConnection {
    public static void main(String[] args) {
        int[][] graph = {{1, 4}, {3, 4}, {1, 3}, {1, 2}, {4, 5}};

        int largest = 2000;

        int[] loopFinder = new int[largest + 1];
        for (int i = 0; i < loopFinder.length; i++) {
            loopFinder[i] = i;
        }


        int result[] = new int[2];
        for (int i = 0; i < graph.length; i++) {
            int from = graph[i][0];
            int to = graph[i][1];


            if (findParent(loopFinder, to) == findParent(loopFinder, from)) {
                result[0] = from;
                result[1] = to;
                System.out.println(Arrays.toString(result));
                return;
            } else {
                loopFinder[findParent(loopFinder, from)] = loopFinder[to];

            }
        }

        System.out.println(Arrays.toString(loopFinder));
        System.out.println(Arrays.toString(result));

    }

    private static int findParent(int[] loopFinder, int from) {
        if (from != loopFinder[from]) {
            loopFinder[from] = findParent(loopFinder, loopFinder[from]);
        }
        return loopFinder[from];
    }
}
