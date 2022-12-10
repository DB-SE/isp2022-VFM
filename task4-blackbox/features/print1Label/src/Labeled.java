import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

import data.Node;
import interfaces.Print;

public class Labeled implements Print{

	@Override
	public List<List<String>> getPrint(List<AbstractMap.SimpleEntry<Node, List<AbstractMap.SimpleEntry<Node, Double>>>> data) {
				
		List<List<String>> labels = new ArrayList<>();
		
		for(AbstractMap.SimpleEntry<Node, List<AbstractMap.SimpleEntry<Node, Double>>> node : data) {			
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
