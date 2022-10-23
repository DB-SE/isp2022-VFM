import graphs.LabeledUnweightedGraph;
import graphs.LabeledWeightedGraph;
import graphs.UnlabeledUnweightedGraph;
import graphs.UnlabeledWeightedGraph;

public class Main {

    public static void main(String[] args) {

        // no label, no weight
        UnlabeledUnweightedGraph graph1 = new UnlabeledUnweightedGraph();
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
        System.out.println("\tREACHABLE: "+graph1.depthFirstSearch(nodeId1, nodeId2));
        System.out.println("\tREACHABLE: "+graph1.depthFirstSearch(nodeId1, nodeId3));

        // label, no weight
        LabeledUnweightedGraph graph2 = new LabeledUnweightedGraph();
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
        System.out.println("\tREACHABLE: "+graph2.depthFirstSearch("Magdeburg", "Halle"));
        System.out.println("\tREACHABLE: "+graph2.depthFirstSearch("Magdeburg", "Berlin"));

        // no label, weight
        UnlabeledWeightedGraph graph3 = new UnlabeledWeightedGraph();
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
        System.out.println("\tREACHABLE: "+graph3.depthFirstSearch(id1, id2));
        System.out.println("\tREACHABLE: "+graph3.depthFirstSearch(id1, id3));


        // label, weight
        LabeledWeightedGraph graph4 = new LabeledWeightedGraph();
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
        System.out.println("\tREACHABLE: "+graph4.depthFirstSearch("Magdeburg", "Halle"));
        System.out.println("\tREACHABLE: "+graph4.depthFirstSearch("Magdeburg", "Berlin"));


        // MinimumSpanningTree
        LabeledWeightedGraph graph5 = new LabeledWeightedGraph();
        graph5.addNode("A");
        graph5.addNode("B");
        graph5.addNode("C");
        graph5.addNode("D");
        graph5.addNode("E");
        graph5.addEdge("A", "B", 2.0);
        graph5.addEdge("B", "C", 2.0);
        graph5.addEdge("C", "D", 2.0);
        graph5.addEdge("D", "A", 2.0);
        graph5.addEdge("A", "E", 1.0);
        graph5.addEdge("B", "E", 1.0);
        graph5.addEdge("C", "E", 1.0);
        graph5.addEdge("D", "E", 1.0);
        graph5.print();

        graph5.getMinimumSpanningTree().print();

        graph5.addNode("F");
        graph5.addEdge("F", "A", 0.5);
        graph5.addEdge("F", "B", 0.5);
        graph5.getMinimumSpanningTree().print();

        graph5.removeEdge("E", "D");
        graph5.getMinimumSpanningTree().print();
    }
}
