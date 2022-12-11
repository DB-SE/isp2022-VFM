import java.util.ArrayDeque;
import java.util.Queue;

import data.GraphData;
import data.Node;

public class BreadthFirstSearchCalculator {

	public Integer breadthFirstSearch(Node start, Node goal, GraphData graph) {

		boolean[] discovered = new boolean[graph.graphData.size()];
		int actual = start.id;		
		Queue<Integer> q = new ArrayDeque<>();
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
		return graph.graphData.get(node).getValue().stream().map(it -> it.getKey().id).toList();
	}
	
}