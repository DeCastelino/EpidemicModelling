import java.util.Iterator;

public class List <T> implements Iterable <T> {

	class Node
	{
		T value;
		Node nextNode;
		
		public Node (T value, Node nextNode)
		{
			this.value = value;
			this.nextNode = nextNode;
		}
	}
	
	class NodeIterator implements Iterator <Node>
	{
		List <T> list;
		Node node;
		int i;
		
		public NodeIterator (List <T> list)
		{
			this.list = list;
			node = list.root;
			i = 0;
		}
		
		@Override
		public boolean hasNext() {
			return i < list.size ();
		}

		@Override
		public List<T>.Node next() {
			if (hasNext ())
			{
				Node returnValue = node;
				node = node.nextNode;
				i++;
				return returnValue;
			}
			else
			{
				return null;
			}
		}
		
	}
	
	class ListIterator implements Iterator <T>
	{
		NodeIterator i;
		
		public ListIterator(NodeIterator i) {
			this.i = i;
		}
		@Override
		public boolean hasNext() {
			return i.hasNext();
		}

		@Override
		public T next() {
			return i.next().value;
		}
		
	}
	
	private Node root;
	private int size;
	
	void add (T value)
	{
		root =  new Node (value, root);
		size ++;
	}
	
	void remove (int index)
	{
		if (index == 0)
		{
			root = root.nextNode;
		}
//		else if (index == 1)
//		{
//			root.nextNode = root.nextNode.nextNode;
//		}
		else
		{
			Iterator <Node> iterator = new NodeIterator(this);
			for (int i = 1; i < index; i++)
			{
				iterator.next();
			}
			Node node = iterator.next();
			node.nextNode = node.nextNode.nextNode;
		}
		
		size--;
	}
	
	void removeAll (T value)
	{
		if (size > 0 && root.value.equals(value))
		{
			remove (0);
		}
		else if (root != null)
		{
			for (Node node = root; node.nextNode != null;)
			{
				if (node.nextNode.value.equals(value))
				{
					node.nextNode = node.nextNode.nextNode;
					size --;
				}
				else
				{
					node = node.nextNode;
				}
			}
		}
	}
	
	T get (int index)
	{
		Iterator <T> iterator = iterator ();
		for (int i = 1; i < index; i++)
		{
			iterator.next();
		}
		return iterator.next();
	}
	
	int size ()
	{
		return this.size;
	}
	
	T [] toArray (T [] arr)
	{
		Iterator <T> iterator = this.iterator();
		for (int i = 0; i < arr.length; i++)
		{
			arr [i] = iterator.next ();
		}
		
		return arr;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new ListIterator(new NodeIterator(this));
	}
	
}
