import java.util.Objects; 

public class Graph {

    public void print() {
    	for(int i = 0; i<graph.graphData.size(); i++) {
    		System.out.print("\n" + graph.graphData.get(i).getKey().toString() + " --> ");
    		for(int j=0; j<graph.graphData.get(i).getValue().size(); j++) {
    			System.out.print(graph.graphData.get(i).getValue().get(j).getKey().toString() + " Weight:" + graph.graphData.get(i).getValue().get(j).getValue().toString() + ", ");
    		}
    	}
    	System.out.println("\n");
    } 
    
	private double[][] getAdjacencyMatrix() {
    	int size = graph.graphData.size();    	
    	double[][] matrix = new double[size][size];
    	
    	for (int i = 0; i < size; i++) {
    		for (int j = 0; j < size; j++) {
    				matrix[i][j] = weightOfAdjacency(graph.graphData.get(i).getKey(), graph.graphData.get(j).getKey(), graph);  						
    		}
    	}
    	return matrix;
    }
	
    private double weightOfAdjacency(Node node, Node adjacency, GraphData graph) {    
    	for(int i = 0; i < graph.graphData.get(node.id).getValue().size(); i++) {
    		if(graph.graphData.get(node.id).getValue().get(i).getKey().id == adjacency.id)
    			return graph.graphData.get(node.id).getValue().get(i).getValue();
    	}
    	return 0.0;   	
    }
}
