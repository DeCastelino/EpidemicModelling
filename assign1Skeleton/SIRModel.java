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
    	
    	List <String> newlyInfected = new List <String> ();
    	List <String> newlyRecovered = new List <String> ();
    	
        // TODO IMPLEMENT ME!
    	for (String vertex : seedVertices)
    	{
    		graph.infectVertex(vertex);
    	}
    	
    	int iterationNo = 0;
    	
    	do
    	{
    		iterationNo ++;
    		
    		String [] currentlyInfected 
    			= graph.allVerticesWithState (SIRState.I);
    		
    		// Infect some vertices
    		for (String vertex : currentlyInfected)
    		{
    			if (random.nextFloat() < infectionProb)
    			{
    				newlyInfected.add (vertex);
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
    	}
    	while (newlyInfected.size () > 0 || newlyRecovered.size () > 0);
    } // end of runSimulation()
} // end of class SIRModel