package section_11_data_structures_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {

    int numberOfNodes = 0;
    HashMap<Integer, List<Integer>> adjacentList;

    public Graph() {
        numberOfNodes = 0;
        adjacentList = new HashMap<>();
    }

    public static void main(String[] args) {
        Graph myGraph = new Graph();

        myGraph.addVertex(0);
        myGraph.addVertex(1);
        myGraph.addVertex(2);
        myGraph.addVertex(3);
        myGraph.addVertex(4);
        myGraph.addVertex(5);
        myGraph.addVertex(6);

        myGraph.addEdge(3, 1);
        myGraph.addEdge(3, 4);
        myGraph.addEdge(4, 2);
        myGraph.addEdge(4, 5);
        myGraph.addEdge(1, 2);
        myGraph.addEdge(1, 0);
        myGraph.addEdge(0, 2);
        myGraph.addEdge(6, 5);

        myGraph.showConnections();
    }

    public void addVertex(Integer node1) {
        adjacentList.put(node1, new ArrayList<>());
        numberOfNodes++;
    }

    public void addEdge(Integer node1, Integer node2) {
        // Fail-safe measure
        adjacentList.putIfAbsent(node1, new ArrayList<>());
        adjacentList.putIfAbsent(node2, new ArrayList<>());

        // Get the arrays
        var mList1 = adjacentList.get(node1);
        var mList2 = adjacentList.get(node2);

        // Insert the nodes
        mList1.add(node2);
        mList2.add(node1);
    }

    public void showConnections() {
        System.out.println("{");
        for (var key : adjacentList.keySet()) {
            System.out.printf("    %d: %s\n", key, adjacentList.get(key));
        }
        System.out.println("}");
    }
}
