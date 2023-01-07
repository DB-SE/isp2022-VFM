import java.util.AbstractMap;
import java.util.List;
import java.util.ArrayList;

public class Graph {	

	public boolean search(Node start, Node goal) {
		DepthFirstSearchCalculator calculator = new DepthFirstSearchCalculator();
		return calculator.depthFirstSearch(start, goal, graph) == goal;
	}	  
    
}
