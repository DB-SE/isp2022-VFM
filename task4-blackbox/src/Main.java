import java.util.List;

import data.Color;
import data.Graph;
import interfaces.Print;
import loader.PluginLoader;
import data.Node;

public class Main {

	public static void main(String[] args) {
		
		Graph graph = new Graph();
		Node node1 = graph.addNode("node_0", Color.WHITE);
		Node node2 = graph.addNode("node_1", Color.BLACK);
		Node node3 = graph.addNode("node_2", Color.GREEN);
		
		graph.addEdge(node1, node2, 3.5);
		graph.addEdge(node1, node3, 6.1);
		graph.addEdge(node2, node3, 6.1);

		graph.print();
		
	}
	
	
}
