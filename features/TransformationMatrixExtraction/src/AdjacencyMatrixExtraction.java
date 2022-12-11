import java.util.List;

import data.GraphData;
import data.Node;
import interfaces.Transformations;
import interfaces.Decorations;

public class AdjacencyMatrixExtraction implements Transformations {
			
	public void transform(GraphData graph, List<Decorations> decorations) {
		System.out.println("Adjacency Matrix:");
		double[][] matrix = getAdjacencyMatrix(graph, decorations);		
		for (int i = 0; i < matrix[0].length; i++) {			
    		for (int j = 0; j < matrix[0].length; j++) {    			
    			System.out.print("|" + matrix[i][j] + "|");	
    		}
    		System.out.println();
    	}	
	}
	
	private double[][] getAdjacencyMatrix(GraphData graph, List<Decorations> decorations) {
    	int size = graph.graphData.size();    	
    	double[][] matrix = new double[size][size];
    	
    	for (int i = 0; i < size; i++) {
    		for (int j = 0; j < size; j++) {
    			if(isWeight(decorations))
    				matrix[i][j] = weightOfAdjacency(graph.graphData.get(i).getKey(), graph.graphData.get(j).getKey(), graph);
    			else {
    				if(weightOfAdjacency(graph.graphData.get(i).getKey(), graph.graphData.get(j).getKey(), graph) != 0)
    					matrix[i][j] = 1;
    				else
    					matrix[i][j] = 0;	
    			}    						
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
    
	private boolean isWeight(List<Decorations> decorations) {
		for (Decorations decoration : decorations) {	
			if(decoration.getClass().toString().contentEquals("class Weight")) return true;	
		}					
		return false;
	}

}
