
public class Map <K, V>
{
	
	class Pair
	{
		K key;
		V value;
		
		public Pair (K key, V value)
		{
			this.key = key;
			this.value = value;
		}
		
		public String toString ()
		{
			return "(" + key + "," + value + ")";
		}
	}
	
	Vector <Pair> vec = new Vector <Pair> ();
	
	public void set (K key, V value, boolean replace)
	{
		int index = getIndex (key);
		if (index == -1)
		{
			Pair pair = new Pair (key, value);
			vec.add(pair);
		}
		else if (replace)
		{
			vec.get (index).value = value;
		}
	}
	
	public void add (K key, V value)
	{
		set (key, value, false);
	}
	
	public void set (K key, V value)
	{
		set (key, value, true);
	}
	
	public void delete (K key)
	{
		int index = getIndex (key);
		vec.set (index, null);
	}
	
	public V get (K key)
	{
		int index = getIndex (key);
		
		if (index == -1)
		{
			return null;
		}
		else
		{
			return vec.get(index).value;
		}
	}
	
	public int getIndex (K key)
	{
		for (int i = 0; i < vec.size (); i++)
		{
			Pair pair = vec.get (i);
			if (pair != null && pair.key.equals (key))
			{
				return i;
			}
		}
		
		return -1;
	}
	
	public K getKey (int index)
	{
			return vec.get (index).key;		
	}
	
	public V getValue (int index)
	{
		Pair pair = vec.get (index);
		if (pair == null)
		{
			return null;
		}
		else
		{
			return pair.value;
		}
	}

	public int size() {
		return vec.size ();
	}
	
	public String toString ()
	{
		String str = "";
		for (int i = 0; i < vec.size (); i++)
		{
			Pair val = vec.get (i);
			if (val != null)
			{
				str += val + " ";
			}
		}
		
		return str;
	}
}
