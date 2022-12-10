import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

import data.Node;
import interfaces.Print;

public class Colored implements Print{

	@Override
	public List<List<String>> getPrint(List<AbstractMap.SimpleEntry<Node, List<AbstractMap.SimpleEntry<Node, Double>>>> data) {
		
		List<List<String>> colors = new ArrayList<>();
		
		for(AbstractMap.SimpleEntry<Node, List<AbstractMap.SimpleEntry<Node, Double>>> node : data) {			
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
