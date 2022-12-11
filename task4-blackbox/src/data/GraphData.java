package data;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

public class GraphData {

	public List<AbstractMap.SimpleEntry<Node, List<AbstractMap.SimpleEntry<Node, Double>>>> graphData;
	
	public GraphData() { graphData = new ArrayList<>(); }
}
