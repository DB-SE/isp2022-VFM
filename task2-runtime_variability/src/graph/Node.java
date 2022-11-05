package graph;

import java.util.Objects;
import java.util.UUID;

public class Node {
    ConfigReader config = new ConfigReader();
    public String id;
    public String label;

    public Node(String label) {
        this.label = label;
        this.id = UUID.randomUUID().toString();
    }

    public Node(String label, String id) {
        this.label = label;
        this.id = id;
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
        if (config.labeled){
            if(label == null) return id;
            return label;
        }
        return id;
    }
}

