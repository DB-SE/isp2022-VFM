import java.util.Objects;  

public    class   Node {
	

    public int id;

	
    public String label;

	
    public Color color;

	

    public Node(String label, Color color, int id) {
        this.id = id;
        this.label = label;
        this.color = color;
    }

	

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return id == node.id;
    }

	

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

	
    
    
     private String  toString__wrappee__Graph() {
    		return "ID:"+ id;
    }

	

    @Override
    public String toString() {
    		return toString__wrappee__Graph() + " Label:" + label;
    }


}
