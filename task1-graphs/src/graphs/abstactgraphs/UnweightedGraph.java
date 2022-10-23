package graphs.abstactgraphs;

import graphs.algorithms.DepthFirstSearch;
import graphs.data.Node;
import graphs.data.UnweightedGraphData;

import java.util.ArrayList;
import java.util.List;

public abstract class UnweightedGraph {

    protected UnweightedGraphData graph = new UnweightedGraphData();

    protected void addNode(String label) {
        graph.data.putIfAbsent(new Node(label), new ArrayList<>());
    }

    protected void removeNode(String label) {
        Node node = new Node(label);
        graph.data.values().forEach(adjacencyNode -> adjacencyNode.remove(node));
        graph.data.remove(node);
    }

    protected void addEdge(String label1, String label2) {
        Node node1 = new Node(label1);
        Node node2 = new Node(label2);
        graph.data.get(node1).add(node2);
        graph.data.get(node2).add(node1);
    }

    protected void removeEdge(String label1, String label2) {
        Node node1 = new Node(label1);
        Node node2 = new Node(label2);
        List<Node> adjacencyNodesOfNode1 = graph.data.get(node1);
        List<Node> adjacencyNodesOfNode2 = graph.data.get(node2);
        if (adjacencyNodesOfNode1 != null)
            adjacencyNodesOfNode1.remove(node2);
        if (adjacencyNodesOfNode2 != null)
            adjacencyNodesOfNode2.remove(node1);
    }

    public void print() {
        graph.data.forEach((node, adjacencyNodes) -> {
            System.out.print("\n" + node.label + " --> ");
            adjacencyNodes.forEach(adjacencyNode -> System.out.print(adjacencyNode.label + ", "));
        });
        System.out.println();
    }

    protected Boolean depthFirstSearch(Node start, Node goal) {
        Node found = new DepthFirstSearch().depthFirstSearch(start, goal, graph);
        return found != null;
    }
}
