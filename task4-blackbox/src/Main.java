import data.Color;
import data.Graph;
import data.Node;

public class Main {

	public static void main(String[] args) {
		
		Graph graph = new Graph();
		Node node0 = graph.addNode("A", Color.WHITE);
		Node node1 = graph.addNode("B", Color.BLACK);
		Node node2 = graph.addNode("C", Color.GREEN);
		Node node3 = graph.addNode("D", Color.GREEN);
		Node node4 = graph.addNode("E", Color.GREEN);
		Node node5 = graph.addNode("F", Color.GREEN);
				
		graph.addEdge(node2, node0, 1.0);
		graph.addEdge(node2, node1, 1.0);
		graph.addEdge(node2, node3, 1.0);
		graph.addEdge(node2, node4, 1.0);
		
		graph.addEdge(node0, node1, 2.0);
		graph.addEdge(node0, node3, 2.0);
		
		graph.addEdge(node4, node1, 2.0);
		graph.addEdge(node4, node3, 2.0);
		

		graph.print();
		
		graph.transformations();	
		
		System.out.println("\nSearch (Not_Found) 0 to 5:");
		System.out.println(graph.search(node0, node5));
		
		System.out.println("Search (Found) 0 to 4:");
		System.out.println(graph.search(node0, node4));
		
	}		
	
}