public class PrimTester {


	public static void main(String[] args) {		
		/*
		
		   | A  		| B  	| C  	| D  	| E  	| F
		-----------------------------------------------------
		A  | null	| 8		| null	| 10		| null	| null	
		B  | 8		| null	| 14		| 12		| null	| null	
		C  | null	| 14		| null	| 15		| 13		| null	
		D  | 10		| 12		| 15		| null	| 12		| 20	
		E  | null	| null	| 13		| 12		| null	| 19	
		F  | null	| null	| null	| 20		| 19		| null	
		
		*/
	
		Integer[][] matrix = {
			{null, 8, null, 10, null, null},	// A (0)
			{8, null, 14, 12, null, null},	// B (1)
			{null, 14, null, 15, 13, null},	// C (2)
			{10, 12, 15, null, 12, 20},		// D (3)
			{null, null, 13, 12, null, 19},	// E (4)
			{null, null, null, 20, 19, null}	// F (5)
		};	
		
		
		Graph g = new Graph(matrix);
		
		// displays the matrix in a useful form:
		g.printEdgeMatrix();
		
		// Your task:
		g.calculateMST();
		
		// Print parents and minimum weights to the terminal:
        g.printMST();
        
        // implemented in VisHelper
        Visualizer v = new Visualizer(g);
        v.save();
        System.out.println("Open visualizer/index.html in the web browser.");
	}

}
