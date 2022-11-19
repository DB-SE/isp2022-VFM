import java.util.Objects;
import java.util.UUID;

public class Node {

    public String id;
    public String label;
    public Color color;


    public Node() {
        this.id = UUID.randomUUID().toString();
        this.label = null;
        this.color = Color.WHITE;
    }

    public Node(String label) {
        this.id = UUID.randomUUID().toString();
        this.label = label;
        this.color = Color.WHITE;
    }

    public Node(Color color) {
        this.id = UUID.randomUUID().toString();
    	this.label = null;
        this.color = color;
    }

    public Node(String label, String id) {
        this.id = id;
        this.label = label;
        this.color = Color.WHITE;
    }

    public Node(String label, Color color) {
        this.id = UUID.randomUUID().toString();
        this.label = label;
        this.color = color;
    }

    public Node(String label, String id, Color color) {
        this.id = id;
        this.label = label;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return id.equals(node.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
    	









	    	
	        	if(label == null)
	        		return color + id + Color.RESET;
	        	return color + label + Color.RESET;
	    	


    	
    }
}

