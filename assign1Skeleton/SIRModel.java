import java.io.PrintWriter;
import java.util.Random;

/**
 * SIR model.
 *
 * @author Jeffrey Chan, 2021.
 */
public class SIRModel
{

    /**
     * Default constructor, modify as needed.
     */
    public SIRModel() {

    } // end of SIRModel()


    /**
     * Run the SIR epidemic model to completion, i.e., until no more changes to the states of the vertices for a whole iteration.
     *
     * @param graph Input contracts graph.
     * @param seedVertices Set of seed, infected vertices.
     * @param infectionProb Probability of infection.
     * @param recoverProb Probability that a vertex can become recovered.
     * @param sirModelOutWriter PrintWriter to output the necessary information per iteration (see specs for details).
     */
    public void runSimulation(ContactsGraph graph, String[] seedVertices,
        float infectionProb, float recoverProb, PrintWriter out)
    {
    	Random random = new Random ();
    	
    	List <String> newlyInfected;
    	List <String> newlyRecovered;
    	
        // TODO IMPLEMENT ME!
    	for (String vertex : seedVertices)
    	{
    		graph.infectVertex(vertex);
    	}
    	
    	int iterationNo = 0;
    	int lastIterationWithChanges = 0;
    	
    	do
    	{
    		iterationNo ++;
    		
    		String [] currentlyInfected 
    			= graph.allVerticesWithState (SIRState.I);
    		newlyInfected = new List <String> ();
        	newlyRecovered = new List <String> ();
    		
    		// Infect some vertices
    		for (String vertex : currentlyInfected)
    		{
    			String [] neighbours = graph.kHopNeighbours(1, vertex);
    			for (String neighbour : neighbours)
    			{
	    			if (random.nextFloat() < infectionProb 
	    					&& graph.getVertexState(neighbour) == SIRState.S)
	    			{
	    				newlyInfected.removeAll(neighbour);
	    				newlyInfected.add (neighbour);
	    			}
    			}
    		}
    		
    		// Recover some vertices
    		for (String vertex : currentlyInfected)
    		{
    			if (random.nextFloat () < recoverProb)
    			{
    				newlyRecovered.add (vertex);
    			}
    		}
    		
    		// Commit changes
    		for (String vertex : newlyInfected)
    		{
    			graph.infectVertex (vertex);
    		}
    		for (String vertex : newlyRecovered)
    		{
    			graph.recoverVertex (vertex);
    		}
    		
    		// Print results
    		String infectedString = String.join (" ", newlyInfected);
    		String recoveredString = String.join (" ", newlyRecovered);
    		String output
    		 = iterationNo + ": " 
    		 + "[" + infectedString + "] : "
    		 + "[" + recoveredString + "]";
    		out.println (output);
    		
    		if (newlyInfected.size () > 0 || newlyRecovered.size () > 0)
    		{
    			lastIterationWithChanges = iterationNo;
    		}
    		else if (currentlyInfected.length == 0)
    		{
    			lastIterationWithChanges = -100;
    		}
    	}
    	while (iterationNo - lastIterationWithChanges < 10);
    } // end of runSimulation()
} // end of class SIRModel
