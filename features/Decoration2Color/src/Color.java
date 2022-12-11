import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

import data.GraphData;
import data.Node;
import interfaces.Decorations;

public class Color implements Decorations {

	@Override
	public List<List<String>> getDecoration(GraphData graph) {
		
		List<List<String>> colors = new ArrayList<>();
		
		for(AbstractMap.SimpleEntry<Node, List<AbstractMap.SimpleEntry<Node, Double>>> node : graph.graphData) {			
			List<String> colorsInner = new ArrayList<>();	
			colorsInner.add("Color:" + node.getKey().color.toString());
			for(AbstractMap.SimpleEntry<Node, Double> innerNode : node.getValue()) {
				colorsInner.add("Color:" + innerNode.getKey().color.toString());
			}
			colors.add(colorsInner);			
		}
		return colors;
	}

}
