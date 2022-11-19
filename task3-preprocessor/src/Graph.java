import java.util.HashMap;
import java.util.Map;

public class Graph {

    public Map<Node, Map<Node, Double>> data;

    public Graph() { data = new HashMap<>(); }

    public String addNode(String label) {
        Node node = new Node(label);
        data.putIfAbsent(node, new HashMap<>());
        return node.id;
    }

    public String addNode(String label, String id) {
        Node node = new Node(label, id);
        data.putIfAbsent(node, new HashMap<>());
        return node.id;
    }

    public String addNode(String label, Color color) {
        Node node = new Node(label, color);
        data.putIfAbsent(node, new HashMap<>());
        return node.id;
    }

    public String addNode(String label, String id, Color color) {
        Node node = new Node(label, id, color);
        data.putIfAbsent(node, new HashMap<>());
        return node.id;
    }

    public String addNode(Color color) {
        Node node = new Node(color);
        data.putIfAbsent(node, new HashMap<>());
        return node.id;
    }

    public void removeNode(String id) {
        final Node[] node = new Node[1];
        data.keySet().forEach( key -> {
            if (key.id == id) node[0] = key;
        });
        data.values().forEach(adjacencyNode -> adjacencyNode.remove(node[0]));
        data.remove(node[0]);
    }

    public void addEdge(String id1, String id2) {
        Double weight = Double.MAX_VALUE;
        data.get(findNode(id1)).putIfAbsent(findNode(id2), weight);
		


    }

    public void addEdge(String id1, String id2, Double weight) {
        data.get(findNode(id1)).putIfAbsent(findNode(id2), weight);
        


    }

    protected void removeEdge(String id1, String id2) {
        Node node1 = findNode(id1);
        Node node2 = findNode(id2);
        Map<Node, Double> adjacencyNodesOfNode1 = data.get(node1);
        Map<Node, Double> adjacencyNodesOfNode2 = data.get(node2);
        if (adjacencyNodesOfNode1 != null)
            adjacencyNodesOfNode1.remove(node2);
        



    }

    private Node findNode(String id){
        final Node[] node = new Node[1];
        data.keySet().forEach( key -> {
            if (key.id == id) node[0] = new Node(key.label, key.id);
        });
        return node[0];
    }


    
    public Boolean depthFirstSearch(String startId, String goalId) {
        Node found = new DepthFirstSearch().depthFirstSearch(findNode(startId), findNode(goalId), data);
        return found != null;
    }
    

    





    public void print() {
        data.forEach((node, adjacencyNodes) -> {
            System.out.print("\n" + node + " --> ");
            
            adjacencyNodes.forEach((adjacencyNode, weight) -> System.out.print(adjacencyNode + ", "));
            


        });
        System.out.println();
    }
}
