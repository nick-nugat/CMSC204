/**
 * @author Nicholas Nguyen
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;

public class BasicDoubleLinkedList <T> implements Iterable {
	/**
	 * inner class Node
	 */
	public class Node{
		private T data;
		private Node previous;
		private Node next;

		public Node(T dataNode){
			//todo
		}
	}

	/**
	 * inner class DoubleLinkedListIterator
	 */
	public class DoubleLinkedListIterator implements ListIterator<T>{

		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public T next() {
			return null;
		}

		@Override
		public boolean hasPrevious() {
			return false;
		}

		@Override
		public T previous() {
			return null;
		}




		@Override
		public int nextIndex() {
			return 0;
		}

		@Override
		public int previousIndex() {
			return 0;
		}

		@Override
		public void remove() {

		}

		@Override
		public void set(T t) {

		}

		@Override
		public void add(T t) {

		}
	}


	//todo create head, tail, and size
	public BasicDoubleLinkedList(){
		//todo initialize head, tail, and size -> null, null, and o respectively (?)
	}

	/**
	 *
	 * @return
	 */
	public int getSize(){

	}

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

	}

	/**
	 *
	 * @return
	 */
	public T getLast(){

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
	public BasicDoubleLinkedList.Node remove(T targetData, Comparator<T> comparator){

	}

	/**
	 *
	 * @param targetData
	 * @param comparator
	 * @return
	 */
	public BasicDoubleLinkedList.Node remove​(T targetData, Comparator<T> comparator){

	}

	/**
	 *
	 * @return
	 */
	public T retrieveFirstElement(){

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
