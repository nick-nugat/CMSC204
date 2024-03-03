/**
 * @author Nicholas Nguyen
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList <T> implements Iterable<T> {
	protected Node<T> head;
	protected Node<T> tail;
	protected int size;

	/**
	 * inner class Node<T>
	 */
	public class Node<T>{
		protected T data;
		protected Node<T> previous;
		protected Node<T> next;

		public Node(T dataNode){
			this.data = dataNode;

		}
	} //end Node<T> inner class

	/**
	 * inner class DoubleLinkedListIterator
	 */
	public class DoubleLinkedListIterator implements ListIterator<T>{
		private Node<T> current;
		private boolean atStart;

		public DoubleLinkedListIterator(){
			this.current = head;
			this.atStart = true;
		}

		@Override
		public boolean hasNext() {
			if (atStart) return head != null;
			return current != null && current.next != null;
		}

		@Override
		public T next() throws NoSuchElementException{
			if (!hasNext()) throw new NoSuchElementException();

			if (atStart){
				current = head;
				atStart = false;
			} else{
				current = current.next;
			}
			return current.data;
		}

		@Override
		public boolean hasPrevious() {
			if (atStart) return false;
			return current != null && (current.previous != null || current == head);
		}

		@Override
		public T previous() throws NoSuchElementException {
			if (!hasPrevious()) throw new NoSuchElementException();

			if (current == head){
				atStart = true;
			}
			T data = current.data;
			current = current.previous;
			return data;
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
		Node<T> node = new Node<T>(data);
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
		Node<T> node = new Node<T>(data);
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
	public Node<T> remove(T targetData, Comparator<T> comparator){
		if (size == 0) return null;

		Node<T> current = head;
		while (current != null){
			if (comparator.compare(targetData, current.data) == 0){ //0 means that they are equal
				if (current == head){
					head = head.next; //moves head forward
					if (head != null){
						head.previous = null;
					}
				} else if (current == tail){
					tail = tail.previous; //moves tail back
					if (tail != null){
						tail.next = null;
					}
				} else{ //current node is neither the head or tail (in the middle)
					 current.previous.next = current.next;
					 if (current.next != null){ //if not end of list
						 current.next.previous = current.previous;
					 }
				}
				if (size == 0) head = tail = null; //if empty (all nodes removed)
				size--;
				return current;
			}
			current = current.next;
		} //end while loop
		return null;
	}


	/**
	 * Removes and returns the first element from the list. If there are no elements the method returns null. Do not implement this method using iterators.
	 * @return data from head
	 */
	public T retrieveFirstElement(){
		if (size == 0) return null;
		T headData = head.data;
		if (head == tail){
			head = tail = null;
		} else{
			head = head.next;
			head.previous = null;
		}
		size--;
		return headData;
	}

	/**
	 *
	 * @return
	 */
	public T retrieveLastElement(){
		if (size == 0) return null;
		T tailData = tail.data;

		if (head == tail){
			head = tail = null;
		} else{
			tail = tail.previous;
			tail.next = null;
		}
		size--;
		return tailData;
	}

	/**
	 *
	 * @return
	 */
	public ArrayList<T> toArrayList(){
		ArrayList<T> list = new ArrayList<>();
		Node<T> current = head;
		while (current != null){
			list.add(current.data);
			current = current.next;
		}
		return list;
	}

}
