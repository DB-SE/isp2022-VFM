import graph.LabelWeightGraph;
import graph.LabelWeightlessGraph;
import graph.LabelessWeightGraph;
import graph.LabelessWeightlessGraph;

public class Main {

    public static void main(String[] args) {

        // no label, no weight
        LabelessWeightlessGraph graph1 = new LabelessWeightlessGraph();
        String nodeId1 = graph1.addNode();
        String nodeId2 = graph1.addNode();
        String nodeId3 = graph1.addNode();
        graph1.addEdge(nodeId1, nodeId2);
        graph1.addEdge(nodeId1, nodeId3);
        graph1.print();
        graph1.removeEdge(nodeId1, nodeId3);
        graph1.print();
        graph1.removeNode(nodeId3);
        graph1.print();

        // label, no weight
        LabelWeightlessGraph graph2 = new LabelWeightlessGraph();
        graph2.addNode("Magdeburg");
        graph2.addNode("Halle");
        graph2.addNode("Berlin");
        graph2.addEdge("Magdeburg", "Halle");
        graph2.addEdge("Magdeburg", "Berlin");
        graph2.print();
        graph2.removeEdge("Magdeburg", "Berlin");
        graph2.print();
        graph2.removeNode("Berlin");
        graph2.print();

        // no label, weight
        LabelessWeightGraph graph3 = new LabelessWeightGraph();
        String id1 = graph3.addNode();
        String id2 = graph3.addNode();
        String id3 = graph3.addNode();
        graph3.addEdge(id1, id2, 100.0);
        graph3.addEdge(id1, id3, 200.0);
        graph3.print();
        graph3.removeEdge(id1, id3);
        graph3.print();
        graph3.removeNode(id3);
        graph3.print();

        // label, weight
        LabelWeightGraph graph4 = new LabelWeightGraph();
        graph4.addNode("Magdeburg");
        graph4.addNode("Halle");
        graph4.addNode("Berlin");
        graph4.addEdge("Magdeburg", "Halle", 100.0);
        graph4.addEdge("Magdeburg", "Berlin", 150.0);
        graph4.print();
        graph4.removeEdge("Magdeburg", "Berlin");
        graph4.print();
        graph4.removeNode("Berlin");
        graph4.print();
    }
}
