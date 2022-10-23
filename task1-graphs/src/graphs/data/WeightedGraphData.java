package graphs.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraphData implements GraphData {

    public Map<Node, Map<Node, Double>> data;

    public Map<Node, List<Node>> weightlessData() {
        Map<Node, List<Node>> weightless = new HashMap<>();
        data.forEach((node, adjacencyNodes) -> weightless.put(node, new ArrayList<>(adjacencyNodes.keySet())));
        return weightless;
    }
}
