package graph;

import java.util.*;

public class Weightless {

    protected void addNode(String label, Map<Node, List<Node>> graph) {
        graph.putIfAbsent(new Node(label), new ArrayList<>());
    }

    protected void removeNode(String label, Map<Node, List<Node>> graph) {
        Node node = new Node(label);
        graph.values().forEach( adjacencyVertices -> adjacencyVertices.remove(node));
        graph.remove(node);
    }

    protected void addEdge(String label1, String label2, Map<Node, List<Node>> graph) {
        Node node1 = new Node(label1);
        Node node2 = new Node(label2);
        graph.get(node1).add(node2);
        graph.get(node2).add(node1);
    }

    protected void removeEdge(String label1, String label2, Map<Node, List<Node>> graph) {
        Node node1 = new Node(label1);
        Node node2 = new Node(label2);
        Collection<Node> adjacencyVerticesOfVertex1 = graph.get(node1);
        Collection<Node> adjacencyVerticesOfVertex2 = graph.get(node2);
        if (adjacencyVerticesOfVertex1 != null)
            adjacencyVerticesOfVertex1.remove(node2);
        if (adjacencyVerticesOfVertex2 != null)
            adjacencyVerticesOfVertex2.remove(node1);
    }

    protected void print(Map<Node, List<Node>> graph) {
        graph.forEach((node, adjacencyVertices) -> {
            System.out.print("\n" + node.label + " --> ");
            adjacencyVertices.forEach(adjacencyNode -> System.out.print(adjacencyNode.label + ", "));
        });
        System.out.println();
    }

    protected Node search(Map<Node, List<Node>> graph, Node goal) {
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
    private Node DFS(Map<Node, List<Node>> graph, List<Node> visited, Node node, Node goal) {
        // daran orientiert https://de.wikipedia.org/wiki/Tiefensuche#Algorithmen
        visited.add(node);
        if (node.equals(goal))
            return node;
        else {
            Stack<Node> stack = new Stack<>();
            for (Node node2 : graph.get(node)) {
                if (!visited.contains(node2))
                    stack.push(node2);
            }
            while (!stack.empty()) {
                Node node3 = stack.pop();
                Node node4 = DFS(graph, visited, node3, goal);
                if (node4 != null)
                    return node4;
            }
            return null;
        }
    }
}
