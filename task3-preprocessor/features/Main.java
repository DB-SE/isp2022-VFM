/**
 * TODO description
 */
public class Main {
	
	public static void main(String[] args) {
		
		Graph graph = new Graph();
        String id1 = graph.addNode("test1");
        String id2 = graph.addNode("test2", Color.PURPLE);
        String id3 = graph.addNode("test3", Color.GREEN);
        String id4 = graph.addNode("test4");
        graph.addEdge(id2, id3, 5.1);
        graph.addEdge(id3, id4, 4.2);
        graph.addEdge(id3, id3, 22.2);
        graph.print();
        
        
        /*if[MatrixExtraction]*/
        double[][] m = graph.getAdjacencyMatrix();
        for (int i = 0; i < m.length; i++) {
        	for (int j = 0; j < m.length; j++) {
				System.out.print(m[i][j] + ", ");
			}
			System.out.println();
        }
        /*end[MatrixExtraction]*/
        
        
        /*if[DFS]*/
        System.out.println(graph.depthFirstSearch(id2, id4));
        /*end[DFS]*/
        
        
        /*if[MST]*/
        graph.minimumSpanningTree().print();
        /*end[MST]*/

	}

}
