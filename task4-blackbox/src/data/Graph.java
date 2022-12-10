package data;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import interfaces.Print;
import loader.PluginLoader;
import java.util.ArrayList;

public class Graph {
	
	int count = 0;
	
	final List<Print> prints = PluginLoader.load(Print.class);
//	final List<Edge> nodes = PluginLoader.load(Node.class);
//	final List<Edge> algorithms = PluginLoader.load(Algorithms.class);

    public List<AbstractMap.SimpleEntry<Node, List<AbstractMap.SimpleEntry<Node, Double>>>> data;

    public Graph() { data = new ArrayList<>(); }
    
    public List<AbstractMap.SimpleEntry<Node, List<AbstractMap.SimpleEntry<Node, Double>>>> getData() {
    	return data;
    }
    
    public Node addNode(String label, Color color) {
        Node node = new Node(label, color, count++);
        data.add(new AbstractMap.SimpleEntry<>(node, new ArrayList<>()));
        return node;
    }

//    public void removeNode(String id) {
//        final Node[] node = new Node[1];
//        data.keySet().forEach( key -> {
//            if (key.id == id) node[0] = key;
//        });
//        data.values().forEach(adjacencyNode -> adjacencyNode.remove(node[0]));
//        data.remove(node[0]);
//    }

    public void addEdge(Node node1, Node node2, Double weight) {
        data.get(node1.id).getValue().add(new AbstractMap.SimpleEntry<>(node2, weight)); 
        data.get(node2.id).getValue().add(new AbstractMap.SimpleEntry<>(node1, weight)); 
    }

//    protected void removeEdge(String id1, String id2) {
//        Node node1 = findNode(id1);
//        Node node2 = findNode(id2);
//        Map<Node, Double> adjacencyNodesOfNode1 = data.get(node1);
//        Map<Node, Double> adjacencyNodesOfNode2 = data.get(node2);
//        if (adjacencyNodesOfNode1 != null)
//            adjacencyNodesOfNode1.remove(node2);
//        /*if_not[Directed]*/
//        if (adjacencyNodesOfNode2 != null)
//            adjacencyNodesOfNode2.remove(node1);
//        /*end[Directed]*/
//    }
//
//    /*if[DFS]*/
//    public Boolean depthFirstSearch(String startId, String goalId) {
//        Node found = new DepthFirstSearch().depthFirstSearch(findNode(startId), findNode(goalId), data);
//        return found != null;
//    }
//    /*end[DFS]*/
//
//    /*if[MST]*/
//    public Graph minimumSpanningTree() {
//        return new MinimumSpanningTree().calculate(data);
//    }
//    /*end[MST]*/

    public void print() {
    	
    	List<List<List<String>>> printList = new ArrayList<>();    	
    	List<List<String>> idsLists = new ArrayList<>();
    	
    	for(int i = 0; i < data.size(); i++) {    		
    		List<String> idsList = new ArrayList<>();
    		for(int j = 0; j < data.get(i).getValue().size(); j++) {
    			if(j==0) idsList.add("Id:" + data.get(i).getKey().id);
    			idsList.add("Id:" + data.get(i).getValue().get(j).getKey().id);
    		}
    		idsLists.add(idsList);
    	}    	
    	printList.add(idsLists);
    	
    	for(Print print : prints) {
    		printList.add(print.getPrint(data));
    	}        	
    	
    	List<String> endList = new ArrayList<>();   
    	
    	for(int i = 0; i < printList.get(0).size(); i++) {    		
    		
    		String adjacentNodes = "";
    		for(int j = 0; j < printList.get(0).get(0).size(); j++) {    			
    			String adjacentNode = "";
    			for(int k = 0; k <= prints.size(); k++) {   
    				if(k==0) adjacentNode = "[" + printList.get(k).get(i).get(j) + " ";    			
    				else if(k == prints.size()) adjacentNode = adjacentNode + printList.get(k).get(i).get(j) + "] ";
    				else adjacentNode = adjacentNode + printList.get(k).get(i).get(j) + " ";
    			}  
    			if(j == 0) adjacentNodes = adjacentNodes + adjacentNode + "  -->  ";
    			else adjacentNodes = adjacentNodes + adjacentNode;
    		}    
    		endList.add(adjacentNodes);
    	}
   
    	for(int i = 0; i < endList.size(); i++) {
    		System.out.println(endList.get(i));
    	}   	
        	
    }
    
//    /*if[MatrixExtraction]*/
//    public double[][] getAdjacencyMatrix() {
//    	int size = data.entrySet().size();
//    	Map<Integer, Node> node_to_index = new HashMap();
//    	int[] k = new int[1];
//    	k[0] = 0;
//    	data.forEach((node, adjacency) -> {
//    		node_to_index.put(k[0], node);
//    		k[0]++;
//    	});
//    	double[][] matrix = new double[size][size];
//    	for (int i = 0; i < size; i++) {
//    		for (int j = 0; j < size; j++) {
//				Double adj_node = data.get(node_to_index.get(i)).get(node_to_index.get(j));
//				if (adj_node != null)
//					/*if[Weighted]*/
//					matrix[i][j] = adj_node;
//					/*else[Weighted]*/
//					matrix[i][j] = 1;
//					/*end[Weighted]*/
//				else
//					matrix[i][j] = 0;
//    		}
//    	}
//    	return matrix;
//    }
//    /*end[MatrixExtraction]*/
}
