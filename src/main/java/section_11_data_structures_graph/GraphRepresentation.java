package section_11_data_structures_graph;

public class GraphRepresentation {

    public static void main(String[] args) {
        // Edge list
        int[][] graph = {{0, 2}, {2, 3}, {2, 1}, {1, 3}};

        // Adjacent List
        /**
         * {
         *     0: {2},
         *     1: {2, 3},
         *     2: {0, 1, 3},
         *     3: {1, 2},
         * }
         */
        int[][] adjacentGraph = {{2}, {2, 3}, {0, 1, 3}, {1, 2}};

        // Adjacent Matrix
        /**
         * {
         *     0: {0, 0, 1, 0},
         *     1: {0, 0, 1, 1},
         *     2: {1, 1, 0, 1},
         *     3: {0, 1, 1, 0},
         * }
         */
        int[][] adjacentMatrix = {
                {0, 0, 1, 0},
                {0, 0, 1, 1},
                {1, 1, 0, 1},
                {0, 1, 1, 0},
        };
    }


}

