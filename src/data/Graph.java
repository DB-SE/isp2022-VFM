package data;
import java.util.AbstractMap;
import java.util.List;

import interfaces.Decorations;
import interfaces.Search;
import interfaces.Transformations;
import interfaces.Type;
import loader.PluginLoader;
import java.util.ArrayList;

public class Graph {	

    public GraphData graph;

    public Graph() { graph = new GraphData(); }
    
    public GraphData getGraphData() { return graph; }
    
    final List<Type> type = PluginLoader.load(Type.class);
	final List<Search> search = PluginLoader.load(Search.class); 
	final List<Decorations> decorations = PluginLoader.load(Decorations.class);	
	final List<Transformations> transformations = PluginLoader.load(Transformations.class);	
    
    int count = 0;
    
    public Node addNode(String label, Color color) {
        Node node = new Node(label, color, count++);
        graph.graphData.add(new AbstractMap.SimpleEntry<>(node, new ArrayList<>()));
        return node;
    }
    
    public Node addNode(String label, Color color, int id) {
        Node node = new Node(label, color, id);
        graph.graphData.add(new AbstractMap.SimpleEntry<>(node, new ArrayList<>()));
        return node;
    }

    public void addEdge(Node node1, Node node2, Double weight) {
        type.get(0).addEdge(node1, node2, weight, graph);
    }
    
    public Boolean search(Node start, Node goal) {
    	for(Search search : search) {
    		return search.search(start, goal, graph);
    	}
    	return null;
    }
    
    public void transformations() {
    	for(Transformations transformation : transformations) {
    		transformation.transform(graph, decorations);
    	}
    }   
    
    public void print() {  
    	
    	List<List<List<String>>> decorationList = new ArrayList<>();    	
    	List<List<String>> idsLists = new ArrayList<>();
    	
    	for(int i = 0; i < graph.graphData.size(); i++) {    		
    		List<String> idsList = new ArrayList<>();
    		for(int j = 0; j < graph.graphData.get(i).getValue().size(); j++) {
    			if(j==0) idsList.add("Id:" + graph.graphData.get(i).getKey().id);
    			idsList.add("Id:" + graph.graphData.get(i).getValue().get(j).getKey().id);
    		}
    		idsLists.add(idsList);
    	}    	
    	decorationList.add(idsLists);
    	
    	for(Decorations decoration : decorations) {
    		decorationList.add(decoration.getDecoration(graph));
    	}        	
    	
    	List<String> resultList = new ArrayList<>();   
    	
    	for(int i = 0; i < decorationList.get(0).size(); i++) {    		
    		
    		String adjacentNodes = "";
    		for(int j = 0; j < decorationList.get(0).get(i).size(); j++) {    			
    			String adjacentNode = "";
    			for(int k = 0; k <= decorations.size(); k++) {   
    				if(k==0) adjacentNode = "[" + decorationList.get(k).get(i).get(j) + " ";    			
    				else if(k == decorations.size()) adjacentNode = adjacentNode + decorationList.get(k).get(i).get(j) + "] ";
    				else adjacentNode = adjacentNode + decorationList.get(k).get(i).get(j) + " ";
    			}  
    			if(j == 0) adjacentNodes = adjacentNodes + adjacentNode + "  -->  ";
    			else adjacentNodes = adjacentNodes + adjacentNode;
    		}    
    		resultList.add(adjacentNodes);
    	}
   
    	for(int i = 0; i < resultList.size(); i++) {
    		if(!resultList.get(i).isBlank())
    			System.out.println(resultList.get(i));
    	}   
    	System.out.println();
    }
    
}
