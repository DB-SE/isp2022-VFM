package graph;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LabelessWeightGraph extends Weight {

    private final Map<Node, Map<Node, Double>> graph;

    public LabelessWeightGraph() { graph = new HashMap<>(); }

    /**returns node id*/
    public String addNode(){ String id = UUID.randomUUID().toString(); addNode(id, graph); return id; }

    public void removeNode(String id) { removeNode(id, graph); }

    public void addEdge(String id1, String id2, Double weight) { addEdge(id1, id2, weight, graph); }

    public void removeEdge(String id1, String id2) { removeEdge(id1, id2, graph); }

    public void print() { print(graph); }
}
