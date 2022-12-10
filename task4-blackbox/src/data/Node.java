package data;

import java.util.Objects;
//import java.util.UUID;

public class Node {

    public int id;
    public String label;
    public Color color;


//    public Node() {
//        this.id = UUID.randomUUID().toString();
//        this.label = null;
//        this.color = Color.WHITE;
//    }
//
//    public Node(String label) {
//        this.id = UUID.randomUUID().toString();
//        this.label = label;
//        this.color = Color.WHITE;
//    }
//
//    public Node(Color color) {
//        this.id = UUID.randomUUID().toString();
//    	this.label = null;
//        this.color = color;
//    }
//
//    public Node(String label, String id) {
//        this.id = id;
//        this.label = label;
//        this.color = Color.WHITE;
//    }
//
//    public Node(String label, Color color) {
//        this.id = UUID.randomUUID().toString();
//        this.label = label;
//        this.color = color;
//    }

    public Node(String label, Color color, int id) {
        this.id = id;
        this.label = label;
        this.color = color;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Node node = (Node) o;
//        return id.equals(node.id);
//    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
//    @Override
//    public String toString() {
//    
//	    		return label;
//	    	
//    }
//
//    @Override
//    public String toString() {
//    	/*if_not[Colored]*/
//	    	/*if[Labeled]*/
//	    	if(label == null)
//	    		return id;
//	    	return label;
//			/*else[Labeled]*/
//		    return id;
//			/*end[Labeled]*/
//		    
//    	/*else[Colored]*/
//	    	/*if[Labeled]*/
//	        	if(label == null)
//	        		return color + id + Color.RESET;
//	        	return color + label + Color.RESET;
//	    	/*else[Labeled]*/
//	        return color + id + Color.RESET;
//	    	/*end[Labeled]*/
//    	/*end[Colored]*/
//    }
}

