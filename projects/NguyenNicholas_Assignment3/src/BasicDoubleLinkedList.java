/**
 * @author Nicholas Nguyen
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList <T> implements Iterable {
	private BasicDoubleLinkedList<T> elements = new BasicDoubleLinkedList<>();
	private Node head;
	private Node tail;
	private int size;

	/**
	 * inner class Node
	 */
	public class Node{
		private T data;
		private Node previous;
		private Node next;

		public Node(T dataNode){
			this.data = dataNode;
			this.previous = null;
			this.next = null;
		}
	} //end Node inner class

	/**
	 * inner class DoubleLinkedListIterator
	 */
	public class DoubleLinkedListIterator implements ListIterator<T>{
		private Node current;

		public DoubleLinkedListIterator(){
			this.current = head;
		}

		@Override
		public boolean hasNext() {
			return current.next != null;
		}

		@Override
		public T next() throws NoSuchElementException{
			if (!hasNext()) throw new NoSuchElementException();
			current = current.next;
			return current.data;
		}

		@Override
		public boolean hasPrevious() {
			return current.previous != null;
		}

		@Override
		public T previous() {
			if (!hasPrevious()) throw new NoSuchElementException();
			current = current.previous;
			return current.data;
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
		Node node = new Node(data);
		if (size == 0){
			head = tail = node;
		} else{
			tail.next = node;
			node.previous = tail;
			tail = node;
		}
		size++;
	}

	/**
	 *
	 * @param data
	 */
	public void addToFront(T data){
		Node node = new Node(data);
		if (size == 0){
			head = tail = node;
		} else{
			node.next = head;
			head.previous = node;
			head = node;
		}
		size++;
	}

	/**
	 *
	 * @return
	 */
	public T getFirst(){
		return size != 0 ? head.data : null;
	}

	/**
	 *
	 * @return
	 */
	public T getLast(){
		return size != 0 ? tail.data : null;
	}

	/**
	 *
	 * @return
	 */
	public ListIterator<T> iterator(){
		return new DoubleLinkedListIterator(); //prob not right
	}

	/**
	 *
	 * @param targetData
	 * @param comparator
	 * @return
	 */
	public Node remove(T targetData, Comparator<T> comparator){

	}


	/**
	 * Removes and returns the first element from the list. If there are no elements the method returns null. Do not implement this method using iterators.
	 * @return
	 */
	public T retrieveFirstElement(){
		if (size == 0) return null;
		return head.data;
	}

	/**
	 *
	 * @return
	 */
	public T retrieveLastElement(){
		if (size == 0) return null;
		return tail.data;
	}

	/**
	 *
	 * @return
	 */
	public ArrayList<T> toArrayList(){

	}

}
