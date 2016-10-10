package structures;


import java.util.Comparator;
import java.util.List;


public class JAbstractArrayHeap<P, V> extends AbstractArrayHeap<P, V>{
	
	// Comparator<P> comparator;
	public JAbstractArrayHeap(Comparator<P> comparator) 
	{
		super(comparator);
		//this.comparator=comparator;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Given an index of some "node" returns the index to that "nodes" left
	 * child.
	 * 
	 * @param index
	 *            an index in this {@link AbstractArrayHeap}
	 * @return the index of the specified "nodes" left child
	 * @throws IndexOutOfBoundsException
	 *             if {@code index} is less than 0
	 */
	public int getLeftChildOf(int index)
	{
		if(index<0)
			throw new IndexOutOfBoundsException();
		else
			return (index*2)+1;
	}

	/**
	 * Given an index of some "node" returns the index to that "nodes" right
	 * child.
	 * 
	 * @param index
	 *            a "nodes" index
	 * @return the index of the specified "nodes" right child
	 * @throws IndexOutOfBoundsException
	 *             if {@code index} is less than 0
	 */
   	public int getRightChildOf(int index)
   	{
   		if(index<0)
   			throw new IndexOutOfBoundsException();
   		else
		return (index*2)+2;
   	}

	/**
	 * Given an index of some "node" returns the index to that "nodes" parent.
	 * 
	 * @param index
	 *            a "nodes" index
	 * @return the index of the specified "nodes" parent
	 * @throws IndexOutOfBoundsException
	 *             if {@code index} is less than 1
	 */
	public int getParentOf(int index)
	{
		if(index<1)
			throw new IndexOutOfBoundsException();
		else
		return (index-1)/2;
	}

	/**
	 * <p>
	 * This results in the entry at the specified index "bubbling up" to a
	 * location such that the property of the heap are maintained. This method
	 * should run in O(log(size)) time.
	 * </p>
	 * <p>
	 * Note: When add is called, an Entry is placed at the end of the internal
	 * array and then this method is called on that index.
	 * </p>
	 * 
	 * @param index
	 *            the index to bubble up
	 */
	public void bubbleUp(int index)
	{
		List<Entry<P,V>> tempList=asList(); 
		int hole=index;
		Entry<P,V> temp= tempList.get(index);
		//System.out.println(temp.getValue());
		while(hole>0&& this.getComparator().compare(temp.getPriority(),tempList.get((hole-1)/2).getPriority())>0)
		{
			//System.out.println("Method executed");
			swap(hole,(hole-1)/2);
			hole=(hole-1)/2;
		}
	}

	/**
	 * <p>
	 * This method results in the entry at the specified index "bubbling down"
	 * to a location such that the property of the heap are maintained. This
	 * method should run in O(log(size)) time.
	 * </p>
	 * <p>
	 * Note: When remove is called, if there are elements remaining in this
	 * {@link AbstractArrayHeap} the bottom most element of the heap is placed
	 * at the 0th index and bubbleDown(0) is called.
	 * </p>
	 * 
	 * @param index
	 */
	public void bubbleDown(int index)
	{
		int hole=index;
		int newhole=getnewindex(hole);
		while(hole!=newhole)
		{
			swap(hole,newhole);
			hole=newhole;
			newhole=getnewindex(hole);
		}
	}
	private int getnewindex(int index)
	{
		int left=getLeftChildOf(index);
		int right=getRightChildOf(index);
		if(left>size()-1)
			return index;
		else
			if(left==size()-1)
			{
				if(getComparator().compare(asList().get(index).getPriority(), asList().get(left).getPriority())>0)
					return index;
				else
					return left;
			}
			else
			{
				if(getComparator().compare(asList().get(left).getPriority(), asList().get(right).getPriority())>0)
				{
					if(getComparator().compare(asList().get(index).getPriority(),asList().get(left).getPriority())>0)
						return index;
					else
						return left;
				}
				else
				{
					if(getComparator().compare(asList().get(index).getPriority(),asList().get(right).getPriority())>0)
						return index;
					else
						return right;
				}
				   
			}
		
	}


}
