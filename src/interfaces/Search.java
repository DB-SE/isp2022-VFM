package interfaces;

import data.GraphData;
import data.Node;

public interface Search {
	
	boolean search(Node start, Node goal, GraphData graph);

}
