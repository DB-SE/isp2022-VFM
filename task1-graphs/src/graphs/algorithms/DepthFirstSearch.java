package graphs.algorithms;

import graphs.data.GraphData;
import graphs.data.Node;
import graphs.data.UnweightedGraphData;
import graphs.data.WeightedGraphData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class DepthFirstSearch {

    public Node depthFirstSearch(Node start, Node goal, GraphData graphData) {
        System.out.print("DepthFirstSearch: \tSTART:"+start.label+"\tGOAL:"+goal.label+"\tROUTE:");
        if (graphData instanceof UnweightedGraphData)
            return depthFirstSearchWorker(start, goal, ((UnweightedGraphData) graphData).data, new ArrayList<>());
        else
            return depthFirstSearchWorker(start, goal, ((WeightedGraphData) graphData).weightlessData(), new ArrayList<>());
    }

    private Node depthFirstSearchWorker(Node actual, Node goal, Map<Node, List<Node>> graphData, List<Node> visited) {
        System.out.print(actual.label + " -> ");
        visited.add(actual);
        if (actual.equals(goal))
            return actual;
        else {
            Stack<Node> stack = new Stack<>();
            for (Node node2 : graphData.get(actual)) {
                if (!visited.contains(node2))
                    stack.push(node2);
            }
            while (!stack.empty()) {
                Node node3 = stack.pop();
                Node node4 = depthFirstSearchWorker(node3, goal, graphData, visited);
                if (node4 != null)
                    return node4;
            }
            return null;
        }
    }
}
