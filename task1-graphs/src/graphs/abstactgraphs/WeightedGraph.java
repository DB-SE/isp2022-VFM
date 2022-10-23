package graphs.abstactgraphs;

import graphs.algorithms.DepthFirstSearch;
import graphs.algorithms.MinimumSpanningTree;
import graphs.data.Node;
import graphs.data.WeightedGraphData;

import java.util.HashMap;
import java.util.Map;

public abstract class WeightedGraph {

    protected WeightedGraphData graph = new WeightedGraphData();

    protected void addNode(String label) {
        graph.data.putIfAbsent(new Node(label), new HashMap<>());
    }

    protected void removeNode(String label) {
        Node node = new Node(label);
        graph.data.values().forEach(adjacencyNode -> adjacencyNode.remove(node));
        graph.data.remove(node);
    }

    protected void addEdge(String label1, String label2, Double weight) {
        Node node1 = new Node(label1);
        Node node2 = new Node(label2);
        graph.data.get(node1).putIfAbsent(node2, weight);
        graph.data.get(node2).putIfAbsent(node1, weight);
    }

    protected void removeEdge(String label1, String label2) {
        Node node1 = new Node(label1);
        Node node2 = new Node(label2);
        Map<Node, Double> adjacencyNodesOfNode1 = graph.data.get(node1);
        Map<Node, Double> adjacencyNodesOfNode2 = graph.data.get(node2);
        if (adjacencyNodesOfNode1 != null)
            adjacencyNodesOfNode1.remove(node2);
        if (adjacencyNodesOfNode2 != null)
            adjacencyNodesOfNode2.remove(node1);
    }

    public void print() {
        graph.data.forEach((node, adjacencyNodes) -> {
            System.out.print("\n" + node.label + " --> ");
            adjacencyNodes.forEach((adjacencyNode, weight) -> System.out.print(adjacencyNode.label + "(" + weight + "), "));
        });
        System.out.println();
    }

    protected Boolean depthFirstSearch(Node start, Node goal) {
        Node found = new DepthFirstSearch().depthFirstSearch(start, goal, graph);
        return found != null;
    }

    public WeightedGraph getMinimumSpanningTree() {
        MinimumSpanningTree minimumSpanningTree = new MinimumSpanningTree();
        return minimumSpanningTree.calculate(graph.data);
    }
}
