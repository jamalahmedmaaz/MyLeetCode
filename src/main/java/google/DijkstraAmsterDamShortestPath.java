package google;

// A Java program for Dijkstra's single source shortest path algorithm.
// The program is for adjacency matrix representation of the graph

import java.util.*;

public class DijkstraAmsterDamShortestPath {

    // A utility function to find the vertex with minimum distance value,
    // from the set of vertices not yet included in shortest path tree
    static final int V = 9;

    // Driver method
    public static void main(String[] args) {
        /* Let us create the example graph discussed above */
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        printRecOnePath(graph);


    }

    private static void printRecOnePath(int[][] graph) {
        Map<Integer, Map<Integer, Integer>> graphRep = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] > 0) {
                    if (graphRep.containsKey(i)) {
                        graphRep.get(i).put(j, graph[i][j]);
                    } else {
                        Map<Integer, Integer> connectionVsWeight = new HashMap<>();
                        connectionVsWeight.put(j, graph[i][j]);
                        graphRep.put(i, connectionVsWeight);
                    }
                }
            }
        }

        Set<Integer> alreadytraversed = new HashSet<>();
        Set<Integer> allNodes = new TreeSet<>();
        allNodes.addAll(graphRep.keySet());

        int nextNode = 0;

        Map<Integer, Map<Integer, Integer>> miniSpanningTree = new HashMap<>();

        /*while (!allNodes.isEmpty()) {
            if (alreadytraversed.size() == 0) {
                alreadytraversed.add(nextNode);
                allNodes.remove(nextNode);
                Map<Integer, Integer> minNode = findMinimunPathNode(graphRep.get(nextNode));
                miniSpanningTree.put(nextNode, minNode);
                updateGrapRepForMinTreeNodes(graphRep, minNode, nextNode);
                nextNode = minNode.entrySet().iterator().next().getKey();
            } else {

            }
        }*/

        int start = 0;

        LinkedList<Integer> levels = new LinkedList<>();

        levels.add(start);

        Set<Integer> visisted = new HashSet<>();
        while (!levels.isEmpty()) {
            int i = levels.pop();
            visisted.add(i);
            System.out.println(i);

            if (i != start) {
                Map<Integer, Integer> minNode = findMinimunPathNode(graphRep.get(i), visisted);
                miniSpanningTree.put(i, minNode);
                updateGrapRepForMinTreeNodes(graphRep, minNode, 0);
            }

            for (int i1 : graphRep.get(i).keySet()) {
                if (!visisted.contains(i1) && !levels.contains(i1)) {
                    levels.addLast(i1);
                }
            }
        }


        System.out.println(graphRep);
    }

    private static void updateGrapRepForMinTreeNodes(Map<Integer, Map<Integer, Integer>> graphRep, Map<Integer, Integer> minNode, int parent) {
        for (Map.Entry<Integer, Map<Integer, Integer>> instance : graphRep.entrySet()) {
            if (minNode.containsKey(instance.getKey())) {
                updateValues(instance, parent, minNode.get(instance.getKey()));
            }
            System.out.println();
        }
    }

    private static void updateValues(Map.Entry<Integer, Map<Integer, Integer>> instance, int parent, Integer valueToAdd) {
        instance.getValue().remove(parent);
        for (Map.Entry<Integer, Integer> k : instance.getValue().entrySet()) {
            instance.getValue().merge(k.getKey(), valueToAdd, Integer::sum);
        }
        System.out.println();
    }

    private static Map<Integer, Integer> findMinimunPathNode(Map<Integer, Integer> links, Set<Integer> visisted) {
        int local = Integer.MAX_VALUE;
        int localKey = -1;
        for (Map.Entry<Integer, Integer> instance : links.entrySet()) {
            if (!visisted.contains(instance.getKey()) && instance.getValue() < local) {
                local = instance.getValue();
                localKey = instance.getKey();
            }
        }


        /**
         * As everything is visisted at this instance,
         *
         * here is where removing logic should come,
         *
         * and new node should be considered if the distance is low.
         */
        if (localKey == -1) {
            System.out.println();
        }

        Map<Integer, Integer> instance = new HashMap<>();
        instance.put(localKey, local);
        return instance;
    }
    int minDistance(int dist[], Boolean sptSet[]) {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    // A utility function to print the constructed distance array
    void printSolution(int dist[], int n) {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " tt " + dist[i]);
    }

    // Funtion that implements Dijkstra's single source shortest path
    // algorithm for a graph represented using adjacency matrix
    // representation
    void dijkstra(int graph[][], int src) {
        int dist[] = new int[V]; // The output array. dist[i] will hold
        // the shortest distance from src to i

        // sptSet[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        Boolean sptSet[] = new Boolean[V];

        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        // Distance of source vertex from itself is always 0
        dist[src] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = minDistance(dist, sptSet);

            // Mark the picked vertex as processed
            sptSet[u] = true;

            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < V; v++)

                // Update dist[v] only if is not in sptSet, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v]
                if (!sptSet[v] && graph[u][v] != 0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }

        // print the constructed distance array
        printSolution(dist, V);
    }

}
