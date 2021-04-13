import java.util.Iterator;

public class ListTester {
	public static void main (String [] args)
	{
		// Test adding
		List<Integer> list = new List <Integer> ();
		for (int i = 0; i < 128; i++)
		{
			list.add(i);
		}
		
		// Test toArray ()
		Integer [] arr = new Integer [list.size ()];
		list.toArray (arr);
		
		for (int i = 0; i < arr.length; i++)
		{
			System.out.println (arr [i]);
		}
		
		// Test removing
		{
			for (int i = 1; i < list.size (); i++)
			{
				list.remove (i);
			}
		}
		
		// Test iterator
		Iterator <Integer> it = list.iterator();
		for(int val = it.next (); it.hasNext(); val = it.next ())
		{
			System.out.println (val);
		}
		
		// Test removeAll
		list = new List <Integer> ();
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				list.add(i);
			}
		}
		
		list.removeAll(2);
		list.removeAll(3);
		
		it = list.iterator();
		for(int val = it.next (); it.hasNext(); val = it.next ())
		{
			System.out.println (val);
		}
	}
}
