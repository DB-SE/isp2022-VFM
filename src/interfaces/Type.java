package interfaces;

import data.GraphData;
import data.Node;

public interface Type {
	
	public void addEdge(Node node1, Node node2, Double weight, GraphData graph);
}