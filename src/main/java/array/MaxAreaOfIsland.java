package array;

/**
 * Created by jamal on 8/4/18.
 */

/**
 * If we see the problem from a birds eye view.
 * <p>
 * It looks like a graph,
 * <p>
 * The solution can be achieve using Depth-First-Search.
 */
public class MaxAreaOfIsland {


    static boolean[][] visited;
    static int island[][];


    public static void main(String[] args) {
        island = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

        visited = new boolean[island.length][island[0].length];

        int area = 0;

        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                area = Math.max(area, findMaxArea(i, j));
            }
        }
        System.out.println("Max aread is " + area);
    }

    private static int findMaxArea(int i, int j) {
        //Base condition on index.
        //Check if i is under the island boundaries.
        //Check if j is under the island boundaries.
        //Check if the current node not already visited.
        //Check if island of the current position is zero.
        if (i < 0 || i >= island.length || j < 0 || j >= island[i].length || visited[i][j] || island[i][j] == 0) {
            return 0;
        }


        //Mark visited for i, j as true.
        visited[i][j] = true;


        return (1 + findMaxArea(i + 1, j) + findMaxArea(i - 1, j) + findMaxArea(i, j - 1) + findMaxArea(i, j + 1));
    }

}
