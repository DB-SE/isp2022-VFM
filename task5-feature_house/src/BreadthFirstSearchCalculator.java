import java.util.*; 

public  class  BreadthFirstSearchCalculator {
	

	public Integer breadthFirstSearch(Node start, Node goal, GraphData graph) {

		boolean[] discovered = new boolean[graph.graphData.size()];
		int actual = start.id;		
		
		Queue<Integer> q = new LinkedList<Integer>();		
		
		discovered[actual] = true;
		q.add(actual);
		System.out.print(actual + " -> ");
		
		while (!q.isEmpty()) {
			actual = q.poll();			
			for (int u: getNeighbors(actual, graph)) {
				System.out.print(u + " -> ");
				if (u == goal.id)					
					return u;				
				if (!discovered[u])	{
					discovered[u] = true;
					q.add(u);					
				}
			}
		}		
		return null;
	}

	
	
	private Iterable<Integer> getNeighbors(Integer node, GraphData graph) {
	
		List<AbstractMap.SimpleEntry<Node, Double>> neighbors = graph.graphData.get(node).getValue();
		List<Integer> neighborsIds = new ArrayList<Integer>();
		
		for(int i = 0; i < neighbors.size(); i++) {
			neighborsIds.add(neighbors.get(i).getKey().id);
		}
		
		return neighborsIds;
	}


}
