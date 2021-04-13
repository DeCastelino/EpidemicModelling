
public class Vector <T> 
{
	private static final int INITIAL_CAPACITY = 2;
	
	private int size = 0;
	private Object [] arr = new Object [INITIAL_CAPACITY];
	
	public void add (T value)
	{
		set (size, value);
	}
	
	public void set (int index, T value)
	{
		if (index >= size)
		{
			expand (index);
			size = index + 1;
		}
		arr [index] = value;
	}
	@SuppressWarnings("unchecked")
	public T get (int index)
	{
		return (T) arr [index];
	}
	
	public int size ()
	{
		return this.size;
	}
	
	private void expand (int index)
	{
		int newLen = arr.length;
		while (newLen <= index)
		{
			newLen *= 2;
		}
		
		Object [] newArr = new Object [newLen];
		for (int i = 0; i < arr.length; i++)
		{
			newArr [i] = arr [i];
		}
		this.arr = newArr;
	}
}
