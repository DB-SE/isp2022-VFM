import java.util.AbstractMap; 
import java.util.List; 
import java.util.ArrayList; 
import java.util.Map; 
import java.util.HashMap; import java.util.Objects;  

public   class  Graph {
		

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

	

    public void print  () {
    	for(int i = 0; i<graph.graphData.size(); i++) {
    		System.out.print("\n" + graph.graphData.get(i).getKey().toString() + " --> ");
    		for(int j=0; j<graph.graphData.get(i).getValue().size(); j++) {
    			System.out.print(graph.graphData.get(i).getValue().get(j).getKey().toString() + " Weight:" + graph.graphData.get(i).getValue().get(j).getValue().toString() + ", ");
    		}
    	}
    	System.out.println("\n");
    }

		

	public boolean search  (Node start, Node goal) {
		BreadthFirstSearchCalculator calculator = new BreadthFirstSearchCalculator();
		if(calculator.breadthFirstSearch(start, goal, graph) != null)
			return true;
		else
			return false;
	}

	
		
	public void mst  () {		
		MinimumSpanningTreeCalculator calculator = new MinimumSpanningTreeCalculator();
		System.out.println("Minimum Spanning Tree:");
		calculator.calculate(graph).print();
	}

		

	public void adjacencyMatrix  () {
		System.out.println("Adjacency Matrix:");
		double[][] matrix = getAdjacencyMatrix();		
		for (int i = 0; i < matrix[0].length; i++) {			
    		for (int j = 0; j < matrix[0].length; j++) {    			
    			System.out.print("|" + matrix[i][j] + "|");	
    		}
    		System.out.println();
    	}	
	}

	
    
    
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

		  
    
    protected void addEdge(Node node1, Node node2, Double weight) {    	
    	graph.graphData.get(node1.id).getValue().add(new AbstractMap.SimpleEntry<Node, Double>(node2, weight)); 
        graph.graphData.get(node2.id).getValue().add(new AbstractMap.SimpleEntry<Node, Double>(node1, weight)); 
    }

	 
    
	private double[][] getAdjacencyMatrix  () {
    	int size = graph.graphData.size();    	
    	double[][] matrix = new double[size][size];
    	
    	for (int i = 0; i < size; i++) {
    		for (int j = 0; j < size; j++) {
    				matrix[i][j] = weightOfAdjacency(graph.graphData.get(i).getKey(), graph.graphData.get(j).getKey(), graph);  						
    		}
    	}
    	return matrix;
    }

	
	
    private double weightOfAdjacency  (Node node, Node adjacency, GraphData graph) {    
    	for(int i = 0; i < graph.graphData.get(node.id).getValue().size(); i++) {
    		if(graph.graphData.get(node.id).getValue().get(i).getKey().id == adjacency.id)
    			return graph.graphData.get(node.id).getValue().get(i).getValue();
    	}
    	return 0.0;   	
    }


}
