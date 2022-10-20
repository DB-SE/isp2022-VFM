package graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LabelWeightlessGraph extends Weightless {

    private final Map<Node, List<Node>> graph;

    public LabelWeightlessGraph() { graph = new HashMap<>(); }

    public void addNode(String label) { addNode(label, graph); }

    public void removeNode(String label) { removeNode(label, graph); }

    public void addEdge(String label1, String label2) { addEdge(label1, label2, graph); }

    public void removeEdge(String label1, String label2) { removeEdge(label1, label2, graph); }

    public void print() { print(graph); }

    public Node search_DFS(String name) {
        return search(graph, new Node(name));
    }
}
