import java.io.PrintWriter;

/**
 * Abstract class to allow you to implement common functionality or definitions.
 * All three graph implement classes extend this.
 *
 * Note, you should make sure to test after changes.  Note it is optional to
 * use this file.
 *
 * @author Jeffrey Chan, 2021.
 */
public abstract class AbstractGraph implements ContactsGraph
{
	protected Map <String, SIRState> vertices = new Map <String, SIRState> ();
	
	@Override
	public void addVertex(String label) {
		vertices.add (label, SIRState.S);
    } // end of addVertex()

	@Override
	public void toggleVertexState(String label) {
		SIRState state = vertices.get(label);
		vertices.set(label, state.toggle());
    } // end of toggleVertexState()
	
	@Override
	public void infectVertex (String label)
	{
		SIRState state = vertices.get(label);
		vertices.set(label, state.infect());
	}
	
	@Override
	public void recoverVertex (String label)
	{
		SIRState state = vertices.get(label);
		vertices.set(label, state.recover());
	}
	
	@Override
	public void printVertices(PrintWriter os) {
        os.println (vertices);
    } // end of printVertices()
	
	@Override 
	public void deleteVertex(String vertLabel) {
        vertices.delete(vertLabel);
    } // end of deleteVertex()
	
	@Override
	public String [] allVerticesWithState (SIRState state)
	{
		List <String> returnList = new List <String> ();
		
		for (int i = 0; i < vertices.size(); i++)
		{
			if (vertices.getValue(i) == state)
			{
				returnList.add(vertices.getKey(i));
			}
		}
		
		String [] returnArr = new String [returnList.size ()];
		returnList.toArray(returnArr);
		
		return returnArr;
	}
	
	@Override
	public SIRState getVertexState (String vertex)
	{
		return vertices.get(vertex);
	}

	
} // end of abstract class AbstractGraph
