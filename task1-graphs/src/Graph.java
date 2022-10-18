import java.util.*;

public class Graph {
    private final Map<Vertex, ArrayList<Map.Entry<Vertex, Double>>> vertices;

    public Graph() {
        vertices = new HashMap<>();
    }

    public void addVertex(String label) {
        vertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    public void removeVertex(String label) {
        Vertex vertex = new Vertex(label);
        vertices.forEach((key, value) -> getWeight(vertex, value).ifPresent(weight -> value.remove(new AbstractMap.SimpleEntry<>(vertex, weight))));
        vertices.remove(vertex);
    }

    private Optional<Double> getWeight(Vertex vertex, ArrayList<Map.Entry<Vertex, Double>> adjacencyVertices) {
        return adjacencyVertices.stream().filter(it -> it.getKey().label == vertex.label).findFirst().map(Map.Entry::getValue);
    }

    public void addEdge(String label1, String label2) {
        Double weight = 0.0;
        addEdge(label1, label2, weight);
    }

    public void addEdge(String label1, String label2, Double weight) {
        Vertex vertex1 = new Vertex(label1);
        Vertex vertex2 = new Vertex(label2);
        vertices.get(vertex1).add(new AbstractMap.SimpleEntry<>(vertex2, weight));
        vertices.get(vertex2).add(new AbstractMap.SimpleEntry<>(vertex1, weight));
    }

    public void removeEdge(String label1, String label2) {
        Vertex vertex1 = new Vertex(label1);
        Vertex vertex2 = new Vertex(label2);
        ArrayList<Map.Entry<Vertex, Double>> adjacencyVerticesOfVertex1 = vertices.get(vertex1);
        ArrayList<Map.Entry<Vertex, Double>> adjacencyVerticesOfVertex2 = vertices.get(vertex2);
        if (adjacencyVerticesOfVertex1 != null)
            getWeight(vertex2, adjacencyVerticesOfVertex1).ifPresent(weight -> adjacencyVerticesOfVertex1.remove(new AbstractMap.SimpleEntry<>(vertex2, weight)));
        if (adjacencyVerticesOfVertex2 != null)
            getWeight(vertex1, adjacencyVerticesOfVertex2).ifPresent(weight -> adjacencyVerticesOfVertex2.remove(new AbstractMap.SimpleEntry<>(vertex1, weight)));
    }

    public ArrayList<Map.Entry<Vertex, Double>> getAdjacencyVertices(String label) {
        return vertices.get(new Vertex(label));
    }

    public Map<Vertex, ArrayList<Map.Entry<Vertex, Double>>> getVertices() {
        return vertices;
    }

    public void print() {
        vertices.forEach((vertex, weight) -> {
            System.out.print("\n" + vertex.label + " --> ");
            vertices.get(vertex).forEach(adjacencyVertex -> System.out.print(adjacencyVertex.getKey().label + "(" + adjacencyVertex.getValue() + "), "));
        });
        System.out.println();
    }

    public void printWeightless() {
        vertices.forEach((vertex, weight) -> {
            System.out.print("\n" + vertex.label + " --> ");
            vertices.get(vertex).forEach(adjacencyVertex -> System.out.print(adjacencyVertex.getKey().label + ", "));
        });
        System.out.println();
    }
}