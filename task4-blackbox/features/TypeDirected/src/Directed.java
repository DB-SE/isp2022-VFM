import java.util.AbstractMap;

import data.GraphData;
import data.Node;
import interfaces.Type;

public class Directed implements Type {

	@Override
	public void addEdge(Node node1, Node node2, Double weight, GraphData graph) {
		graph.graphData.get(node1.id).getValue().add(new AbstractMap.SimpleEntry<>(node2, weight));
	}

}
