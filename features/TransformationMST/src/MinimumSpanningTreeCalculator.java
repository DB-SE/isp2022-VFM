
import java.util.*;

import data.Graph;
import data.GraphData;
import data.Node;

public class MinimumSpanningTreeCalculator {

    private final Graph minimumSpanningTree;

    public MinimumSpanningTreeCalculator() { minimumSpanningTree = new Graph(); }

    public Graph calculate(GraphData graph) {

        graph.graphData.forEach(node -> minimumSpanningTree.addNode(node.getKey().label, node.getKey().color, node.getKey().id));

        graph.graphData.forEach(node -> {
        	
            @SuppressWarnings("unchecked")
			final Optional<Map.Entry<Node, Double>>[] nearestNode = new Optional[]{ node.getValue().stream().findFirst() };
            node.getValue().forEach(adjacencyNode -> {
                if (nearestNode[0].isPresent()) {
                    if (nearestNode[0].get().getValue() > adjacencyNode.getValue())
                        nearestNode[0] = Optional.of(new AbstractMap.SimpleEntry<>(adjacencyNode.getKey(), adjacencyNode.getValue()));
                }
            });
            if (nearestNode[0].isPresent()) {
            	if(minimumSpanningTree.graph.graphData.get(node.getKey().id).getValue().contains(nearestNode[0].get()) == false)
            		minimumSpanningTree.addEdge(node.getKey(), nearestNode[0].get().getKey(), nearestNode[0].get().getValue());
            }               
        });
        
        return minimumSpanningTree;
    }
}
