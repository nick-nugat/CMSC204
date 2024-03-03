/**
 * @author Nicholas Nguyen
 */

import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>{
	private Comparator<T> compareableObject;

	public SortedDoubleLinkedList(Comparator<T> compareableObject){
		//todo implement constructor
	}

	public void add(T data){
		//todo implement add method (other add methods don't work and will throw exceptions)
	}


	@Override
	public ListIterator<T> iterator(){
		return super.iterator();
	}

	@Override
	public Node remove(T data, Comparator<T> comparator){
		return super.remove(data, comparator);
	}

	@Override
	public void addToEnd(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}

	@Override
	public void addToFront(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}


}