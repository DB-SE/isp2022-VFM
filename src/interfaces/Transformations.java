package interfaces;

import java.util.List;

import data.GraphData;

public interface Transformations {

	void transform(GraphData graph, List<Decorations> decorations);
	
}
