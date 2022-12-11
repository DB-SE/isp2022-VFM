import java.util.List;

import data.GraphData;
import interfaces.Decorations;
import interfaces.Transformations;

public class MinimumSpanningTree implements Transformations {
	
	public void transform(GraphData graph, List<Decorations> decorations) {		
		MinimumSpanningTreeCalculator calculator = new MinimumSpanningTreeCalculator();
		System.out.println("Minimum Spanning Tree:");
		calculator.calculate(graph).print();
	}		

}
