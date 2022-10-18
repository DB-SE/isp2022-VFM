public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("Magdeburg");
        graph.addVertex("Halle");
        graph.addVertex("Berlin");
        graph.addVertex("Jena");
        graph.addVertex("Test");
        graph.addEdge("Magdeburg", "Halle" , 100.0);
        graph.addEdge("Magdeburg", "Berlin", 150.0);
        graph.addEdge("Magdeburg", "Jena", 250.0);
        graph.addEdge("Magdeburg", "Test");

        graph.print();
        graph.removeEdge("Magdeburg", "Test");
        graph.printWeightless();
        graph.removeVertex("Test");
        graph.printWeightless();
    }
}
