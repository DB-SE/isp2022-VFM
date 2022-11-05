package graph.algorithm;

import graph.Graph;
import graph.Node;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Optional;

public class MinimumSpanningTree {

    private final Graph minimumSpanningTree;

    public MinimumSpanningTree() { minimumSpanningTree = new Graph(); }

    public Graph calculate(Map<Node, Map<Node, Double>> graph) {

        graph.keySet().forEach(node -> minimumSpanningTree.addNode(node.label, node.id));

        graph.forEach((node, adjacencyNodes) -> {
            final Optional<Map.Entry<Node, Double>>[] nearestNode = new Optional[]{adjacencyNodes.entrySet().stream().findFirst()};
            adjacencyNodes.forEach((adjacencyNode, adjacencyValue) -> {
                if (nearestNode[0].isPresent()) {
                    if (nearestNode[0].get().getValue() > adjacencyValue)
                        nearestNode[0] = Optional.of(new AbstractMap.SimpleEntry<>(adjacencyNode, adjacencyValue));
                }
            });
            if (nearestNode[0].isPresent())
                minimumSpanningTree.addEdge(node.id, nearestNode[0].get().getKey().id, nearestNode[0].get().getValue());
        });
        return minimumSpanningTree;
    }
}
