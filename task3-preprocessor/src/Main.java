/**
 * TODO description
 */
public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("hello2");
		
		Graph graph = new Graph();
        String id1 = graph.addNode(null);
        String id2 = graph.addNode("test2");
        String id3 = graph.addNode("test3");
        String id4 = graph.addNode("test4");
        graph.print();
        graph.removeNode(id1);
        graph.print();
        graph.addEdge(id2, id3);
        graph.addEdge(id3, id4);
        graph.print();
        System.out.println(graph.depthFirstSearch(id2, id4));

        Graph graph5 = new Graph();
        String idAA = graph5.addNode("A");
        String idBB = graph5.addNode("B");
        String idCC = graph5.addNode("C");
        String idDD = graph5.addNode("D");
        String idEE = graph5.addNode(null);
        graph5.addEdge(idAA, idBB, 2.0);
        graph5.addEdge(idBB, idCC, 2.0);
        graph5.addEdge(idCC, idDD, 2.0);
        graph5.addEdge(idDD, idAA, 2.0);
        graph5.addEdge(idAA, idEE, 1.0);
        graph5.addEdge(idBB, idEE, 1.0);
        graph5.addEdge(idCC, idEE, 1.0);
        graph5.addEdge(idDD, idEE);
        graph5.print();

        graph5.minimumSpanningTree().print();
	}

}
