import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class DepthFirstSearch {

    public Node depthFirstSearch(Node actual, Node goal, Map<Node, Map<Node, Double>> graphData) {

        return depthFirstSearch(actual, goal, graphData, new ArrayList<>());
    }

    private Node depthFirstSearch(Node actual, Node goal, Map<Node, Map<Node, Double>> graphData, List<Node> visited) {
        System.out.print(actual.label + " -> ");
        visited.add(actual);
        if (actual.equals(goal))
            return actual;
        else {
            Stack<Node> stack = new Stack<>();
            for (Node node2 : graphData.get(actual).keySet()) {
                if (!visited.contains(node2))
                    stack.push(node2);
            }
            while (!stack.empty()) {
                Node node3 = stack.pop();
                Node node4 = depthFirstSearch(node3, goal, graphData, visited);
                if (node4 != null)
                    return node4;
            }
            return null;
        }
    }
}
