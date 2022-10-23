package graphs;

import graphs.abstactgraphs.WeightedGraph;
import graphs.data.Node;

import java.util.HashMap;
import java.util.UUID;

public class UnlabeledWeightedGraph extends WeightedGraph {

    public UnlabeledWeightedGraph() { graph.data = new HashMap<>(); }

    /**returns node id*/
    public String addNode(){ String id = UUID.randomUUID().toString(); addNode(id); return id; }

    public void removeNode(String id) { super.removeNode(id); }

    public void addEdge(String id1, String id2, Double weight) { super.addEdge(id1, id2, weight); }

    public void removeEdge(String id1, String id2) { super.removeEdge(id1, id2); }

    public Boolean depthFirstSearch(String startId, String goalId) {
        return depthFirstSearch(new Node(startId), new Node(goalId));
    }
}
