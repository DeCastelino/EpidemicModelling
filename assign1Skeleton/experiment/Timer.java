package experiment;

public class Timer {

	private long startTime = 0;
	private long stopTime = 0;
	
	public void start ()
	{
		this.startTime = System.currentTimeMillis ();
	}
	
	public int stop ()
	{
		this.stopTime = System.currentTimeMillis ();
		int difference = (int) (stopTime - startTime);
		
		return difference;
	}
	
}
