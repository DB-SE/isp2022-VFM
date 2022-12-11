import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

import data.GraphData;
import data.Node;
import interfaces.Decorations;

public class Label implements Decorations {

	@Override
	public List<List<String>> getDecoration(GraphData graph) {
				
		List<List<String>> labels = new ArrayList<>();
		
		for(AbstractMap.SimpleEntry<Node, List<AbstractMap.SimpleEntry<Node, Double>>> node : graph.graphData) {			
			List<String> labelsInner = new ArrayList<>();		
			labelsInner.add("Label:" + node.getKey().label);
			for(AbstractMap.SimpleEntry<Node, Double> innerNode : node.getValue()) {
				labelsInner.add("Label:" + innerNode.getKey().label);
			}
			labels.add(labelsInner);			
		}
		return labels;
	}

}
