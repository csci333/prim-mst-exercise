import org.json.simple.JSONObject;

public abstract class JSONNodeHelper {

	// Converts the PrimNode to a JSONObject 
	// (to write to a file for the data visualization):
	@SuppressWarnings("unchecked")
	public JSONObject toNodeJSON(PrimNode node) {
		JSONObject entry = new JSONObject();
		JSONObject data = new JSONObject();
		data.put("id", node.id);
		data.put("key", node.key);
		data.put("label", node.label);
		entry.put("data", data);
		return entry;
	}
	
	// Converts the directed edge in the MST to a JSONObject 
	// (to write to a file for the data visualization):
	@SuppressWarnings("unchecked")
	public JSONObject toEdgeJSON(PrimNode node, Integer[] edgeWeights) {
		
		if (node.p != null) {
			JSONObject entry = new JSONObject();
			JSONObject data = new JSONObject();
			data.put("target", node.p.id);
			data.put("source", node.id);
			data.put("weight", node.key);
			data.put("inTree", true);
			entry.put("data", data);
			return entry;
		}
		return null;
	}

}
