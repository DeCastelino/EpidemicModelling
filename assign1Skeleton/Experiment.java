import experiment.*;

public class Experiment {
	
	private static final int [] TC_VERTICES = {100, 1000, 10_000};
	private static final int [] TC_K = {1, 10, 100};
	private static final int [] TC_DEGREE = {2, 10, 100};
	
	
	private static final int DEFAULT_VERTICES = TC_VERTICES [2];
	private static final GraphType DEFAULT_GRAPH_TYPE 
		= GraphType.values () [0];
	
	private String loadGraph (GraphType graphType, int numVertices, int avgDegree)
	{
		// TODO
		
		return "filename";
	}
	
	private String generateFilename (
			GraphType graphType, 
			int numVertices, 
			int avgDegree)
	{
		String format = "testing-graph-%s-%d-%d.net";
		
		return String.format(format, graphType, numVertices, avgDegree);
	}
	
	private int scenario1 (int avgDegree, int k)
	{
		
	}
	
}
