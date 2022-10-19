package graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Weightless {

    protected void addNode(String label, Map<Node, List<Node>> graph) {
        graph.putIfAbsent(new Node(label), new ArrayList<>());
    }

    protected void removeNode(String label, Map<Node, List<Node>> graph) {
        Node node = new Node(label);
        graph.values().forEach( adjacencyVertices -> adjacencyVertices.remove(node));
        graph.remove(node);
    }

    protected void addEdge(String label1, String label2, Map<Node, List<Node>> graph) {
        Node node1 = new Node(label1);
        Node node2 = new Node(label2);
        graph.get(node1).add(node2);
        graph.get(node2).add(node1);
    }

    protected void removeEdge(String label1, String label2, Map<Node, List<Node>> graph) {
        Node node1 = new Node(label1);
        Node node2 = new Node(label2);
        Collection<Node> adjacencyVerticesOfVertex1 = graph.get(node1);
        Collection<Node> adjacencyVerticesOfVertex2 = graph.get(node2);
        if (adjacencyVerticesOfVertex1 != null)
            adjacencyVerticesOfVertex1.remove(node2);
        if (adjacencyVerticesOfVertex2 != null)
            adjacencyVerticesOfVertex2.remove(node1);
    }

    protected void print(Map<Node, List<Node>> graph) {
        graph.forEach((node, adjacencyVertices) -> {
            System.out.print("\n" + node.label + " --> ");
            adjacencyVertices.forEach(adjacencyNode -> System.out.print(adjacencyNode.label + ", "));
        });
        System.out.println();
    }
}
