import java.io.PrintWriter;
import java.util.Iterator;
// import java.util.*;

/**
 * Adjacency list implementation for the AssociationGraph interface.
 *
 * Your task is to complete the implementation of this class.  You may add methods, but ensure your modified class compiles and runs.
 *
 * @author Jeffrey Chan, 2019.
 */
public class AdjacencyList extends AbstractGraph
{

	private Vector <List <Integer>> adj = new Vector <List <Integer>> ();
	
    /**
	 * Contructs empty graph.
	 */
    public AdjacencyList() {
    	 
    } // end of AdjacencyList()
    
    @Override
    public void addVertex (String label)
    {
    	super.addVertex(label);
    	adj.set (vertices.getIndex(label), new List <Integer>());
    }

    public void addEdge(String srcLabel, String tarLabel) {
        int src = vertices.getIndex (srcLabel);
        int tar = vertices.getIndex (tarLabel);
        
        addEdge(src, tar);
    } // end of addEdge()
    
    public void addEdge (int src, int tar)
    {
    	adj.get(src).add(tar);
    	adj.get(tar).add(src);
    }


    public void deleteEdge(String srcLabel, String tarLabel) {
    	int src = vertices.getIndex (srcLabel);
        int tar = vertices.getIndex (tarLabel);
        
        deleteEdge (src, tar);
        deleteEdge (tar, src);
    } // end of deleteEdge()
    
    public void deleteEdge (int src, int tar)
    {
    	adj.get (src).removeAll (tar);
    	adj.get (tar).removeAll (src);
    }


    public void deleteVertex (int vertex)
    {
    	List <Integer> vertList = adj.get(vertex);
    	while (vertList.size () > 0)
    	{
    		vertList.remove(0);
    	}
    	for (int i = 0; i < adj.size (); i++)
    	{
    		adj.get (i).removeAll (vertex);
    	}
    }
    
    public void deleteVertex(String vertLabel) {
        int vertex = vertices.getIndex(vertLabel);
        
        deleteVertex(vertex);
        
        super.deleteVertex(vertLabel);
    } // end of deleteVertex()


    public String[] kHopNeighbours(int k, String vertLabel) {
    	boolean [] isNeighbour = new boolean [adj.size()];
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


    private void kHopNeighbours(boolean[] isNeighbour, int k, int vertIndex) {
    	if (k <= 0)
        {
        	return;
        }
    	
		List <Integer> neighbours = adj.get(vertIndex);
		for (int neighbour : neighbours)
		{
			isNeighbour [neighbour] = true;
			kHopNeighbours(isNeighbour, k - 1, neighbour);
		}
	}

	public void printVertices(PrintWriter os) {
        super.printVertices(os);
    } // end of printVertices()


    public void printEdges(PrintWriter os) {
    	for (int a = 0; a < adj.size (); a++)
        {
        	for (int b : adj.get (a))
        	{
        		os.println (vertices.getKey(a) + " " + vertices.getKey(b));
        	}
        }
    } // end of printEdges() 

} // end of class AdjacencyList
