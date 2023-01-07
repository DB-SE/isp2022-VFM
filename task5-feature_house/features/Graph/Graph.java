import java.util.AbstractMap;
import java.util.List;
import java.util.ArrayList;

public class Graph {	

    public GraphData graph;

    public Graph() { graph = new GraphData(); }
    
    public GraphData getGraphData() { return graph; }
       
    int count = 0;
    
    public Node addNode(String label, Color color) {
        Node node = new Node(label, color, count++);
        graph.graphData.add(new AbstractMap.SimpleEntry<Node, List<AbstractMap.SimpleEntry<Node, Double>>>(node, new ArrayList<AbstractMap.SimpleEntry<Node, Double>>()));
        return node;
    }
    
    public Node addNode(String label, Color color, int id) {
        Node node = new Node(label, color, id);
        graph.graphData.add(new AbstractMap.SimpleEntry<Node, List<AbstractMap.SimpleEntry<Node, Double>>>(node, new ArrayList<AbstractMap.SimpleEntry<Node, Double>>()));
        return node;
    }    
    
    public void print() {
    	for(int i = 0; i<graph.graphData.size(); i++) {
    		System.out.print("\n" + graph.graphData.get(i).getKey().toString() + " --> ");
    		for(int j=0; j<graph.graphData.get(i).getValue().size(); j++) {
    			System.out.print(graph.graphData.get(i).getValue().get(j).getKey().toString() + ", ");
    		}
    	}
    	System.out.println("\n");
    }  

    public boolean search(Node node1, Node node2) {return false;}
    
    public void mst() {}
    
    public void adjacencyMatrix() {}
    
    
    public static void main(String[] args){
    	
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
		
		System.out.println("\nWay from node0 to node4:" + graph.search(node0, node4) + "\n");
		
		graph.mst();
		graph.adjacencyMatrix();
	}
    
    
}
