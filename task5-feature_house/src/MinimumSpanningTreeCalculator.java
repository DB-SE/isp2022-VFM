
import java.util.*; 

public  class  MinimumSpanningTreeCalculator {
	

    private final Graph minimumSpanningTree;

	

    public MinimumSpanningTreeCalculator() { minimumSpanningTree = new Graph(); }

	

    public Graph calculate(GraphData graph) {
              
        for(AbstractMap.SimpleEntry<Node, List<AbstractMap.SimpleEntry<Node, Double>>> node :  graph.graphData) {
        	minimumSpanningTree.addNode(node.getKey().label, node.getKey().color, node.getKey().id);
        }
        
        for(AbstractMap.SimpleEntry<Node, List<AbstractMap.SimpleEntry<Node, Double>>> node :  graph.graphData) {
        	
            @SuppressWarnings("unchecked")
			final Optional<Map.Entry<Node, Double>>[] nearestNode = new Optional[]{ node.getValue().stream().findFirst() };
            
            for(AbstractMap.SimpleEntry<Node, Double> adjacencyNode : node.getValue()) {
                if (nearestNode[0].isPresent()) {
                    if (nearestNode[0].get().getValue() > adjacencyNode.getValue())
                        nearestNode[0] = Optional.of(new AbstractMap.SimpleEntry<Node, Double>(adjacencyNode.getKey(), adjacencyNode.getValue()));
                }
            }
            if (nearestNode[0].isPresent()) {
            	if(minimumSpanningTree.graph.graphData.get(node.getKey().id).getValue().contains(nearestNode[0].get()) == false)
            		minimumSpanningTree.addEdge(node.getKey(), nearestNode[0].get().getKey(), nearestNode[0].get().getValue());
            }  
            
               
        }
        
        
        
        
        return minimumSpanningTree;
    }


}
