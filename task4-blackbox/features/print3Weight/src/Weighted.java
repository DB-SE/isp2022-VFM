import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

import data.Node;
import interfaces.Print;

public class Weighted implements Print{

	@Override
	public List<List<String>> getPrint(List<AbstractMap.SimpleEntry<Node, List<AbstractMap.SimpleEntry<Node, Double>>>> data) {
		
		List<List<String>> weights = new ArrayList<>();
		
		for(AbstractMap.SimpleEntry<Node, List<AbstractMap.SimpleEntry<Node, Double>>> node : data) {			
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
