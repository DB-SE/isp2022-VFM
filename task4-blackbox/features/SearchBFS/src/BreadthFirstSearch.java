import data.GraphData;
import data.Node;
import interfaces.Search;

public class BreadthFirstSearch implements Search {

	public boolean search(Node start, Node goal, GraphData graph) {
		BreadthFirstSearchCalculator calculator = new BreadthFirstSearchCalculator();
		if(calculator.breadthFirstSearch(start, goal, graph) != null)
			return true;
		else
			return false;
	}
	
}
