import java.util.ArrayList;
import java.util.List;


public class Graph {
	protected Integer[][] edges;
	protected List<PrimNode> nodes;
	private String[] labels = { "A", "B", "C", "D", "E", "F" }; 
	
	/*
	A -> 0
	B -> 1
	C -> 2
	D -> 3
	E -> 4
	F -> 5 
	*/
	
	public Graph(Integer[][] edges) {
		
		// sets the edges to a data field
		this.edges = edges;
		
		// creates a new node (1 per row in the graph)
		this.nodes = new ArrayList<PrimNode>();
		for (int i = 0; i < this.edges.length; i++) {
			String label = labels[i]; // for human readability
			PrimNode node = new PrimNode(i, label);
			this.nodes.add(node);
		}
	}
	
	public void calculateMST() {
		// Your code here:
	}
	
	
	// convenience method to output the matrix:
	public void printEdgeMatrix() {
		System.out.println();
		System.out.println("Initial Graph");
		System.out.println("--------------------------------------------------------");
		System.out.print("\t");
		for (int i=0; i < this.edges.length; i++) {
			System.out.print(this.labels[i] + "\t");
		}
		System.out.println();
		for (int i=0; i < this.edges.length; i++) {
			System.out.print(this.labels[i]+"\t");
			for(int j=0;j<this.edges[i].length;j++) {
				if (this.edges[i][j] == null) {
					System.out.print("-\t");
				} else {
					System.out.print(this.edges[i][j]+ "\t");
				}
			}
			System.out.println();
		}
		System.out.println("--------------------------------------------------------");
	}
	
	// convenience method to output the MST:
	public void printMST() {
		System.out.println();
		System.out.println("MST");
		System.out.println("--------------------------------------------------------");
		Integer weight = 0;
		for (PrimNode node : this.nodes) {
			System.out.println(node);
			weight += node.key;
		}
		System.out.println("--------------------------------------------------------");
		System.out.println();
		System.out.println("Total (Minimum) Weight: " + weight);
	}

}
