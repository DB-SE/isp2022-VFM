package graphs;

import graphs.abstactgraphs.UnweightedGraph;
import graphs.data.Node;

import java.util.HashMap;
import java.util.UUID;

public class UnlabeledUnweightedGraph extends UnweightedGraph {

    public UnlabeledUnweightedGraph() { graph.data = new HashMap<>(); }

    /**returns node id*/
    public String addNode(){ String id = UUID.randomUUID().toString(); addNode(id); return id; }

    public void removeNode(String id) { super.removeNode(id); }

    public void addEdge(String id1, String id2) { super.addEdge(id1, id2); }

    public void removeEdge(String id1, String id2) { super.removeEdge(id1, id2); }

    public Boolean depthFirstSearch(String startId, String goalId) {
        return super.depthFirstSearch(new Node(startId), new Node(goalId));
    }
}