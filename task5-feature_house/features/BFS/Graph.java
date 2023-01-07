import java.util.AbstractMap;
import java.util.List;
import java.util.ArrayList;

public class Graph {	

	public boolean search(Node start, Node goal) {
		BreadthFirstSearchCalculator calculator = new BreadthFirstSearchCalculator();
		if(calculator.breadthFirstSearch(start, goal, graph) != null)
			return true;
		else
			return false;
	}
   
    
}
