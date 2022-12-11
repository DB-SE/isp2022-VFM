
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import data.GraphData;
import data.Node;

public class DepthFirstSearchCalculator {

    public Node depthFirstSearch(Node actual, Node goal, GraphData graph) {

        return depthFirstSearch(actual, goal, graph, new ArrayList<>());
    }

    private Node depthFirstSearch(Node actual, Node goal, GraphData graph, List<Node> visited) {
        System.out.print(actual.id + " -> ");
        visited.add(actual);
        if (actual.equals(goal))
            return actual;
        else {
            Stack<Node> stack = new Stack<>();
            for (Node node2 : graph.graphData.get(actual.id).getValue().stream().map(it -> it.getKey()).toList()    ) {
                if (!visited.contains(node2))
                    stack.push(node2);
            }
            while (!stack.empty()) {
                Node node3 = stack.pop();
                Node node4 = depthFirstSearch(node3, goal, graph, visited);
                if (node4 != null)
                    return node4;
            }
            return null;
        }
    }
}
