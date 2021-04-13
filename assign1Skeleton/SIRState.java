/**
 * Enumeration of the 3 possible SIR states a vertex can be in.
 *
 * @author Jeffrey Chan, RMIT 2021
 */
public enum SIRState
{
    S, // SUSCEPTIBLE
    I, // INFECTED
    R; // RECOVERED
	
	public SIRState toggle ()
	{
		if (this == S)
		{
			return I;
		}
		else
		{
			return R;
		}
	}
	
	public SIRState infect ()
	{
		if (this == S)
		{
			return I;
		}
		else
		{
			return this;
		}
	}
	
	public SIRState recover ()
	{
		if (this == I)
		{
			return R;
		}
		else
		{
			return this;
		}
	}
} // end of enum SIRState

