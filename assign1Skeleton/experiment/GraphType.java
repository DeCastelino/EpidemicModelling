package experiment;

public enum GraphType {
	RANDOM,
	SCALE_FREE;
	
	@Override
	public String toString ()
	{
		if (this == RANDOM)
		{
			return "random";
		}
		else if (this == SCALE_FREE)
		{
			return "scalefree";
		}
		else 
		{
			return null;
		}
	}
}
