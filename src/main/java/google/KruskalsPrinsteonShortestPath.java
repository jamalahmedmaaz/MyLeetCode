package google;


import java.util.*;

public class KruskalsPrinsteonShortestPath {


    public static void main(String[] args) {
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

        List<GraphPair<Integer, Integer, Integer>> sortedGrapNodesByWeight = new ArrayList<>();

        Set<String> pairString = new HashSet<>();

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] > 0) {
                    String pair = i + "" + j;
                    String pair1 = j + "" + i;
                    if (!pairString.contains(pair) || !pairString.contains(pair1)) {
                        sortedGrapNodesByWeight.add(new GraphPair<>(graph[i][j], i, j));
                        pairString.add(pair);
                        pairString.add(pair1);
                    }
                }
            }
        }

        sortedGrapNodesByWeight.sort(Comparator.comparing(p -> (p.getWeight())));


        int[] unionFind = new int[sortedGrapNodesByWeight.size()];
        int parent = -1;

        Arrays.fill(unionFind, -1);

        LinkedList<GraphPair> selectedNodes = new LinkedList<>();

        for (GraphPair<Integer, Integer, Integer> graphPair : sortedGrapNodesByWeight) {

            if (selectedNodes.size() == 0) {
                parent = graphPair.getSource();
            }

            isCycle(unionFind, graphPair, parent);

        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < unionFind.length; i++) {
            if (unionFind[i] != -1) {
                set.add(i);
                set.add(unionFind[i]);
            }
        }


        System.out.println(set);

    }

    private static boolean isCycle(int[] unionFind, GraphPair<Integer, Integer, Integer> selectedNodes, int originalParent) {

        int source = selectedNodes.getSource();
        int destination = selectedNodes.getDestination();

        if (unionFind[source] == destination || unionFind[destination] == source) {
            return true;
        } else {
            int parent = unionFind[source];
            if (parent == -1) {
                unionFind[destination] = source;
            } else {
                unionFind[destination] = parent;
            }

            for (int i = 0; i < unionFind.length; i++) {
                if (destination == unionFind[i]) {
                    unionFind[i] = unionFind[destination];
                }
            }
        }
        return false;
    }

    private static void updateParents(int[] unionFind, int destination) {

    }


    static class GraphPair<Weight, Source, Destination> {
        private Weight weight;
        private Source source;
        private Destination destination;

        public GraphPair(Weight weight, Source source, Destination destination) {
            this.weight = weight;
            this.source = source;
            this.destination = destination;
        }

        public GraphPair(Source i, Destination j) {
            this.source = i;
            this.destination = j;
        }

        public Weight getWeight() {
            return weight;
        }

        public void setWeight(Weight weight) {
            this.weight = weight;
        }

        /**
         * Getter for property 'source'.
         *
         * @return Value for property 'source'.
         */
        public Source getSource() {
            return source;
        }

        /**
         * Setter for property 'source'.
         *
         * @param source Value to set for property 'source'.
         */
        public void setSource(Source source) {
            this.source = source;
        }

        /**
         * Getter for property 'destination'.
         *
         * @return Value for property 'destination'.
         */
        public Destination getDestination() {
            return destination;
        }

        /**
         * Setter for property 'destination'.
         *
         * @param destination Value to set for property 'destination'.
         */
        public void setDestination(Destination destination) {
            this.destination = destination;
        }
    }

}


