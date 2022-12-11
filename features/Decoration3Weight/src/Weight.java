import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

import data.GraphData;
import data.Node;
import interfaces.Decorations;

public class Weight implements Decorations {

	@Override
	public List<List<String>> getDecoration(GraphData graph) {
		
		List<List<String>> weights = new ArrayList<>();
		
		for(AbstractMap.SimpleEntry<Node, List<AbstractMap.SimpleEntry<Node, Double>>> node : graph.graphData) {			
			List<String> weightsInner = new ArrayList<>();	
			weightsInner.add("");
			for(AbstractMap.SimpleEntry<Node, Double> innerNode : node.getValue()) {
				weightsInner.add("Weight:" + innerNode.getValue().toString());
			}
			weights.add(weightsInner);			
		}
		return weights;
	}
}
