import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Visualizer {
	
	private Graph graph;
	
	public Visualizer(Graph graph) {
		this.graph = graph;
	}
	
	private String getOutputFilePath() {
		String dir = System.getProperty("user.dir");
        String separator = System.getProperty("file.separator");
        return dir + separator + "src/visualizer/prim-tree.js";
	}
	
	@SuppressWarnings("unchecked")
	public void save() {
		JSONObject object = new JSONObject();
		JSONArray jsonNodes = new JSONArray();
		JSONArray jsonEdges = new JSONArray();
		
		for (PrimNode node : this.graph.nodes) {
			jsonNodes.add(node.toNodeJSON(node));
			if (node.p != null) {
				jsonEdges.add(node.toEdgeJSON(node, this.graph.edges[node.id]));
			}
    		}
		this.appendBackgroundEdgesJSON(jsonEdges);
		object.put("nodes", jsonNodes);
		object.put("edges", jsonEdges);
		
        try (FileWriter file = new FileWriter(this.getOutputFilePath())) {
            file.write("const graphData = " + object.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
	@SuppressWarnings("unchecked")
	private void appendBackgroundEdgesJSON(JSONArray currentEdges) {
		
		for (int i = 0; i < this.graph.edges.length; i++) {
			for (int j = 0; j < this.graph.edges.length; j++) {
				Integer edgeWeight = this.graph.edges[i][j];
				if (edgeWeight == null) continue;
	
				boolean alreadyInThere = false;
				for(Object o : currentEdges) {
					JSONObject ce = (JSONObject)((JSONObject)o).get("data");
					Integer target = (Integer)ce.get("target");
					Integer source = (Integer)ce.get("source");
					if (target == i && source == j){
						alreadyInThere = true;
					} else if (target == j && source == i){
						alreadyInThere = true;
					}
				}
				if (!alreadyInThere) {
					JSONObject entry = new JSONObject();
					JSONObject data = new JSONObject();
					data.put("target", i);
					data.put("source", j);
					data.put("weight", edgeWeight);
					data.put("inTree", false);
					entry.put("data", data);
					currentEdges.add(entry);
				}
			}
		}
	}
}
