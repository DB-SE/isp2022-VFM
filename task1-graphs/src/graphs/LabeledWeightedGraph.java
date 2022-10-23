package graphs;

import graphs.abstactgraphs.WeightedGraph;
import graphs.data.Node;

import java.util.HashMap;

public class LabeledWeightedGraph extends WeightedGraph {

    public LabeledWeightedGraph() { graph.data = new HashMap<>(); }

    public void addNode(String label) { super.addNode(label); }

    public void removeNode(String label) { super.removeNode(label); }

    public void addEdge(String label1, String label2, Double weight) { super.addEdge(label1, label2, weight); }

    public void removeEdge(String label1, String label2) { super.removeEdge(label1, label2); }

    public void print() { super.print(); }

    public Boolean depthFirstSearch(String startLabel, String goalLabel) {
        return depthFirstSearch(new Node(startLabel), new Node(goalLabel));
    }
}
