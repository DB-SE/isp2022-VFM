package interfaces;

import java.util.*;

import data.Node;

public interface Print {
	
	List<List<String>> getPrint(List<AbstractMap.SimpleEntry<Node, List<AbstractMap.SimpleEntry<Node, Double>>>> data);
}
