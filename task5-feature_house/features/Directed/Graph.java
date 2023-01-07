import java.util.AbstractMap;
import java.util.List;
import java.util.ArrayList;

public class Graph {	  
    
    protected void addEdge(Node node1, Node node2, Double weight) {    	
    	graph.graphData.get(node1.id).getValue().add(new AbstractMap.SimpleEntry<Node, Double>(node2, weight)); 
    }   
    
}
