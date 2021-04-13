public class VectorTester {
	public static void main (String [] args)
	{
		Vector <Integer> vector = new Vector <Integer> ();
		for (int i = 0; i < 128; i++)
		{
			vector.add(i);
		}
		
		for (int i = 0; i < vector.size(); i++)
		{
			System.out.println (vector.get (i));
		}
	}
}
