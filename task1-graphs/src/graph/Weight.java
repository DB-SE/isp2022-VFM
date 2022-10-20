package graph;

import java.util.*;

public class Weight {

    protected void addNode(String label, Map<Node, Map<Node, Double>> graph) {
        graph.putIfAbsent(new Node(label), new HashMap<>());
    }

    protected void removeNode(String label, Map<Node, Map<Node, Double>> graph) {
        Node node = new Node(label);
        graph.values().forEach(adjacencyVertices -> adjacencyVertices.remove(node));
        graph.remove(node);
    }

    protected void addEdge(String label1, String label2, Double weight, Map<Node, Map<Node, Double>> graph) {
        Node node1 = new Node(label1);
        Node node2 = new Node(label2);
        graph.get(node1).putIfAbsent(node2, weight);
        graph.get(node2).putIfAbsent(node1, weight);
    }

    protected void removeEdge(String label1, String label2, Map<Node, Map<Node, Double>> graph) {
        Node node1 = new Node(label1);
        Node node2 = new Node(label2);
        Map<Node, Double> adjacencyVerticesOfVertex1 = graph.get(node1);
        Map<Node, Double> adjacencyVerticesOfVertex2 = graph.get(node2);
        if (adjacencyVerticesOfVertex1 != null)
            adjacencyVerticesOfVertex1.remove(node2);
        if (adjacencyVerticesOfVertex2 != null)
            adjacencyVerticesOfVertex2.remove(node1);
    }

    protected void print(Map<Node, Map<Node, Double>> graph) {
        graph.forEach((node, adjacencyVertices) -> {
            System.out.print("\n" + node.label + " --> ");
            adjacencyVertices.forEach((adjacencyNode, weight) -> System.out.print(adjacencyNode.label + "(" + weight + "), "));
        });
        System.out.println();
    }

    protected Node search(Map<Node, Map<Node, Double>> graph, Node goal) {
        Node someNode = graph.entrySet().iterator().next().getKey();
        return DFS(graph, new ArrayList<>(), someNode, goal);
    }

    /**
     *
     * @param graph Graph
     * @param visited besuchte Knoten
     * @param node suchender Knoten
     * @param goal Zielknoten
     * @return node, wenn gefunden, null, wenn nicht
     */
    private Node DFS(Map<Node, Map<Node, Double>> graph, List<Node> visited, Node node, Node goal) {
        // daran orientiert https://de.wikipedia.org/wiki/Tiefensuche#Algorithmen
        visited.add(node);
        if (node.equals(goal))
            return node;
        else {
            Stack<Node> stack = new Stack<>();
            for (Node node2 : graph.get(node).keySet()) {
                if (!visited.contains(node2))
                    stack.push(node2);
            }
            while (!stack.empty()) {
                Node node3 = stack.pop();
                DFS(graph, visited, node3, goal);
            }
            return null;
        }
    }
}
