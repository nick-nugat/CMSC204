/**
 * @author Nicholas Nguyen
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;

public class BasicDoubleLinkedList <T> implements Iterable {
	private BasicDoubleLinkedList<T> elements = new BasicDoubleLinkedList<>();
	private T head;
	private T dataail;
	private int size;

	/**
	 * inner class Node
	 */
	public class Node{
		private T data;
		private Node previous;
		private Node next;

		public Node(T dataNode){
			//todo implement constructor
		}
	} //end Node inner class

	/**
	 * inner class DoubleLinkedListIterator
	 */
	public class DoubleLinkedListIterator implements ListIterator<T>{
		private Node current;

		public DoubleLinkedListIterator(){
			current = head;
		}

		// todo implement hasNext(), next(), hasPrevious() and previous()

		@Override
		public boolean hasNext() {

		}

		@Override
		public T next() {

		}

		@Override
		public boolean hasPrevious() {

		}

		@Override
		public T previous() {

		}

		//other methods not implemented
		@Override
		public int nextIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(T data) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(T data) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}


		//other methods will be throwing an UnsupportedOperationException
	} //end DoubleLinkedListIterator inner class


	public BasicDoubleLinkedList(){
		head = tail = null;
		size = 0;
	}

	/**
	 *
	 * @return
	 */
	public int getSize(){
		return size;
	}

//don't use iterators to implement the following methods

	/**
	 *
	 * @param data
	 */
	public void addToEnd(T data){

	}

	/**
	 *
	 * @param data
	 */
	public void addToFront(T data){

	}

	/**
	 *
	 * @return
	 */
	public T getFirst(){
		return size == 0 ? null : head;
	}

	/**
	 *
	 * @return
	 */
	public T getLast(){
		return size == 0 ? null : tail;
	}

	/**
	 *
	 * @return
	 */
	public ListIterator<T> iterator(){

	}

	/**
	 *
	 * @param targetData
	 * @param comparator
	 * @return
	 */
	public Node remove(T dataargetData, Comparator<T> comparator){

	}


	/**
	 * Removes and returns the first element from the list. If there are no elements the method returns null. Do not implement this method using iterators.
	 * @return
	 */
	public T retrieveFirstElement(){
		if (size != 0)
			return head;

	}

	/**
	 *
	 * @return
	 */
	public T retrieveLastElement(){

	}

	/**
	 *
	 * @return
	 */
	public ArrayList<T> toArrayList(){

	}

}
