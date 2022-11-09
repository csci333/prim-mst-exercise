import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


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
	
	/*
		PRIM-MINIMUM-SPANNING-TREE(G, w, r) // graph G, weight function w, source vertex r
			for each vertex u in G // initialization step: null parents and infinite keys
			   u.key = ∞
			   u.p = NULL
			r.key = 0
			Let Q be a new priority queue containing all vertices V of G
			
			while Q is not empty
			   u = EXTRACT-MIN(Q)
			   for each vertex v adjacent to u
			      if v is still stored in Q and w(u, v) < v.key // we can get to it cheaper
			         v.p = u // (u, v) is cheapest edge known so far to connect v to the MST
			         DECREASE-KEY(Q, v, w(u,v)) // key of v decreased to edge weight (u, v) 
	
	*/
	public void calculateMST() {
		// Initialization phase:
		for (PrimNode node : this.nodes) {
			node.key = Integer.MAX_VALUE; // infinity
			node.p = null;
		}
		PrimNode source = this.nodes.get(0);
		source.key = 0;
		
		PriorityQueue<PrimNode> queue = new PriorityQueue<PrimNode>();
		for (PrimNode node : this.nodes) {
			queue.add(node);
		}
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
