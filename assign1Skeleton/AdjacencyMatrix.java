import java.io.PrintWriter;


/**
 * Adjacency matrix implementation for the GraphInterface interface.
 *
 * Your task is to complete the implementation of this class.  You may add methods, but ensure your modified class compiles and runs.
 *
 * @author Jeffrey Chan, 2021.
 */
public class AdjacencyMatrix extends AbstractGraph
{
	private static final int MATRIX_SIZE = 10_000; //Arbitrary value
	private boolean [][] adj = new boolean [MATRIX_SIZE][MATRIX_SIZE];

	/**
	 * Contructs empty graph.
	 */
    public AdjacencyMatrix() {
    	// Implement me!
    } // end of AdjacencyMatrix()

    public void setEdge (String srcLabel, String tarLabel, boolean isEdge)
    {
    	int a = vertices.getIndex(srcLabel);
        int b = vertices.getIndex(tarLabel);
        
        adj [a][b] = isEdge;
        adj [b][a] = isEdge;
    }
    public void addEdge(String srcLabel, String tarLabel) {
        setEdge (srcLabel, tarLabel, true);
    } // end of addEdge()


    public void deleteEdge(String srcLabel, String tarLabel) {
        setEdge (srcLabel, tarLabel, false);
    } // end of deleteEdge()


    public void deleteVertex(String vertLabel) {
        int vertex = vertices.getIndex (vertLabel);
        
        for (int i = 0; i < adj.length; i++)
        {
        	adj [i][vertex] = false;
        	adj [vertex][i] = false;
        }
        
        super.deleteVertex(vertLabel);
    } // end of deleteVertex()

    
    private void kHopNeighbours(boolean [] isNeighbour, int k, int vertex) {
        if (k <= 0)
        {
        	return;
        }
        
        for (int i = 0; i < adj.length; i++)
        {
        	if (adj [vertex][i])
        	{
        		isNeighbour [i] = true;
        		kHopNeighbours(isNeighbour, k - 1, i);
        	}
        }
    } // end of kHopNeighbours()
    
    public String[] kHopNeighbours(int k, String vertLabel) {
        boolean [] isNeighbour = new boolean [adj.length];
        int vertIndex = vertices.getIndex(vertLabel);
        kHopNeighbours(isNeighbour, k, vertIndex);

        List <String> neighboursList = new List <String> ();
        for (int i = 0; i < isNeighbour.length; i++)
        {
        	if (i == vertIndex)
        	{
        		continue;
        	}
        	else if (isNeighbour [i])
        	{
        		neighboursList.add(vertices.getKey(i));
        	}
        }
        
        String [] arr = new String [neighboursList.size()];
        return neighboursList.toArray(arr);
    } // end of kHopNeighbours()


    public void printEdges(PrintWriter os) {
        for (int i = 0; i < adj.length; i++)
        {
        	for (int j = 0; j < adj.length; j++)
        	{
        		if (adj [i][j])
        		{
        			os.println (vertices.getKey(i) + " " + vertices.getKey(j));
        		}
        	}
        }
    } // end of printEdges()

} // end of class AdjacencyMatrix
