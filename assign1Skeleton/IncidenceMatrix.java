import java.io.PrintWriter;

/**
 * Incidence matrix implementation for the GraphInterface interface.
 *
 * Your task is to complete the implementation of this class.  You may add methods, but ensure your modified class compiles and runs.
 *
 * @author Jeffrey Chan, 2021.
 */
public class IncidenceMatrix extends AbstractGraph
{

	private static final int MAX_VERTICES = 10_000; //Arbitrary value
	private static final int MAX_EDGES = 100_000;
	private boolean [][] adj = new boolean [MAX_EDGES][MAX_VERTICES];
	private boolean [] slotFull = new boolean [MAX_EDGES];
	
	/**
	 * Contructs empty graph.
	 */
    public IncidenceMatrix() {
    	// Implement me!
    } // end of IncidenceMatrix()


    public void addVertex(String vertLabel) {
        super.addVertex(vertLabel);
    } // end of addVertex()

    private void addEdge (int src, int tar)
    {
    	int i = 0;
    	while (slotFull [i])
    	{
    		i++;
    	}
    	
    	adj [i][src] = true;
    	adj [i][tar] = true;
    	slotFull [i] = true;
    }

    public void addEdge(String srcLabel, String tarLabel) {
    	
    	int src = vertices.getIndex(srcLabel);
    	int tar = vertices.getIndex(tarLabel);
    	
    	addEdge(src, tar);
    	
    } // end of addEdge()


    public void toggleVertexState(String vertLabel) {
        super.toggleVertexState (vertLabel);
    } // end of toggleVertexState()

    private void deleteEdge (int src, int tar)
    {
    	for (int i = 0; i < adj.length; i++)
        {
        	if (adj [i][src] && adj [i][tar])
        	{
        		adj [i][src] = false;
        		adj [i][tar] = false;
        		slotFull [i] = false;
        	}
        }
    }

    public void deleteEdge(String srcLabel, String tarLabel) {
        int src = vertices.getIndex(srcLabel);
        int tar = vertices.getIndex(tarLabel);
        
        deleteEdge(src, tar);
    } // end of deleteEdge()

    public void deleteVertex (int vertex)
    {
    	for (int i = 0; i < adj.length; i++)
        {
     	   if (adj [i][vertex])
     	   {
     		   for (int j = 0; j < adj [i].length; j++)
     		   {
     			   adj [i][j] = false;
     		   }
     		   slotFull [i] = false;
     	   }
        }
    }
    
    public void deleteVertex(String vertLabel) {
       int vertex = vertices.getIndex(vertLabel);
       
       deleteVertex(vertex);
       super.deleteVertex(vertLabel);
    } // end of deleteVertex()

    
    private void kHopNeighbours(boolean [] isNeighbour, int k, int vertex) {
        if (k <= 0)
        {
        	return;
        }
        
        for (int i = 0; i < adj.length; i++)
        {
        	if (adj [i][vertex])
        	{
        		for (int j = 0; j < vertices.size(); j++)
        			{
        				if (adj [i][j])
        					{
        						isNeighbour [j] = true;
        						kHopNeighbours(isNeighbour, k - 1, j);
        					}
        			}
        		
        	}
        }
    } // end of kHopNeighbours()

    public String[] kHopNeighbours(int k, String vertLabel) {
    	boolean [] isNeighbour = new boolean [vertices.size()];
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


    public void printVertices(PrintWriter os) {
        super.printVertices(os);
    } // end of printVertices()


    public void printEdges(PrintWriter os) {
        for (boolean [] row : adj)
        {
        	String a = null;
        	String b = null;
        	for (int vertex = 0; vertex < row.length; vertex ++)
        	{
   
        		if (row [vertex])
        		{
        			if (a == null)
        			{
        				a = vertices.getKey(vertex);
        			}
        			else
        			{
        				b = vertices.getKey(vertex);
        			}
        		}
        	}
        	if (a != null)
        	{
        		os.println (a + " " + b);
        		os.println (b + " " + a);
        	}
        }
    } // end of printEdges()

} // end of class IncidenceMatrix
