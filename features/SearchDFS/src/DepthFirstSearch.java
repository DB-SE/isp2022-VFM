import data.GraphData;
import data.Node;
import interfaces.Search;

public class DepthFirstSearch implements Search {
	
	public boolean search(Node start, Node goal, GraphData graph) {
		DepthFirstSearchCalculator calculator = new DepthFirstSearchCalculator();
		return calculator.depthFirstSearch(start, goal, graph) == goal;
	}

}