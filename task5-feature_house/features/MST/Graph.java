import java.util.AbstractMap; 
import java.util.List;
import java.util.ArrayList; 

public   class  Graph {
		
	public void mst() {		
		MinimumSpanningTreeCalculator calculator = new MinimumSpanningTreeCalculator();
		System.out.println("Minimum Spanning Tree:");
		calculator.calculate(graph).print();
	}   

}
