package structures;

import java.util.Comparator;
import java.util.Iterator;

public class MaxQueue<P,V> implements PriorityQueue<P, V>{

	private AbstractArrayHeap<P,V> arrayHeap;
	public MaxQueue()
	{
		arrayHeap=new JAbstractArrayHeap<P,V>((Comparator<P>) new MaxIntegerComparator());
	}
	public PriorityQueue<P, V> enqueue(P priority, V value)
	{
		if(priority==null||value==null)
			throw new NullPointerException();
		else
		{
			arrayHeap.add(priority, value);
		}
		return this;
	}

	/**
	 * Removes the value with the highest priority in this {@link PriorityQueue}
	 * and then returns it. This runs in O(log(size)) time.
	 * 
	 * @return the value with the highest priority in this {@link PrioirtyQueue}
	 * @throws IllegalStateException
	 *             if this {@link PriorityQueue} is empty.
	 */
	public V dequeue()
	{
		if(arrayHeap.isEmpty())
			throw new IllegalStateException();
		else
		{
			return arrayHeap.remove();
		}
	}

	/**
	 * Returns the value with the highest priority in this {@link PriorityQueue}.
	 * 
	 * @return the value with the highest priority in this {@link PriorityQueue}.
	 * @throws IllegalStateException
	 *             if this {@link PriorityQueue} is empty.
	 */
	public V peek()
	{
		if(arrayHeap.isEmpty())
			throw new IllegalStateException();
		else
		{
			return arrayHeap.peek();
		}
	}

	/**
	 * Returns an {@link Iterator} over all of the entries in this
	 * {@link PriorityQueue}. The order of these elements is unspecified and a
	 * call to {@link Iterator#remove()} results in an
	 * {@link UnsupportedOperationException}.
	 * 
	 * @return an {@link Iterator} over all of the values in this
	 *         {@link PriorityQueue}.
	 */
	public Iterator<Entry<P, V>> iterator()
	{
		Iterator<Entry<P,V>> returnList=arrayHeap.asList().iterator();
		return returnList;
	}

	/**
	 * Returns the {@link Comparator} that is used to determine the ordering of
	 * {@link Entry}s in this {@link PriorityQueue}.
	 * 
	 * @return the {@link Comparator} that is used to determine the ordering of
	 *         {@link Entry}s in this {@link PriorityQueue}.
	 */
	public Comparator<P> getComparator()
	{
		return arrayHeap.getComparator();
	}

	/**
	 * Returns the total number of elements in this {@link PriorityQueue}
	 * 
	 * @return the total number of elements in this {@link PriorityQueue}
	 */
	public int size()
	{
		return arrayHeap.size();
	}

	/**
	 * Returns {@code true} if this {@link PrioirtyQueue} has no elements and
	 * {@code false} otherwise.
	 * 
	 * @return {@code true} if this {@link PrioirtyQueue} has no elements and
	 *         {@code false} otherwise.
	 */
	public boolean isEmpty()
	{
		return arrayHeap.isEmpty();
	}
}

