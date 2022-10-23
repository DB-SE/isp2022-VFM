package graphs.algorithms;

import graphs.LabeledWeightedGraph;
import graphs.abstactgraphs.WeightedGraph;
import graphs.data.Node;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Optional;

public class MinimumSpanningTree {

    private final LabeledWeightedGraph minimumSpanningTree;

    public MinimumSpanningTree() {
        minimumSpanningTree = new LabeledWeightedGraph();
    }

    public WeightedGraph calculate(Map<Node, Map<Node, Double>> graph) {

        graph.keySet().forEach(node -> minimumSpanningTree.addNode(node.label));

        graph.forEach((node, adjacencyNodes) -> {
            final Optional<Map.Entry<Node, Double>>[] nearestNode = new Optional[]{adjacencyNodes.entrySet().stream().findFirst()};
            adjacencyNodes.forEach((adjacencyNode, adjacencyValue) -> {
                if (nearestNode[0].isPresent()) {
                    if (nearestNode[0].get().getValue() > adjacencyValue)
                        nearestNode[0] = Optional.of(new AbstractMap.SimpleEntry<>(adjacencyNode, adjacencyValue));
                }
            });
            if (nearestNode[0].isPresent())
                minimumSpanningTree.addEdge(node.label, nearestNode[0].get().getKey().label, nearestNode[0].get().getValue());
        });
        return minimumSpanningTree;
    }
}
