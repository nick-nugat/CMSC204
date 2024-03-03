/**
 * @author Nicholas Nguyen
 */

import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>{
	private Comparator<T> comparableObject;

	public SortedDoubleLinkedList(Comparator<T> comparableObject){
		//todo implement constructor
		this.comparableObject = comparableObject;
		head = tail = null;
		size = 0;
	}

	public void add(T data){
		Node<T> node = new Node<T>(data);
		if (head == null){ //if empty
			head = tail = node; //first and only element
		} else{ //contains elements
			Node<T> current = head;
			Node<T> previous = null;

			while ((current != null) && (comparableObject.compare(data, current.data) > 0)){
				previous = current; //will always point to node before current
				current = current.next;
			}

			if (previous == null){ //meaning node is smaller than existing elements - insert at the beginning
				node.next = head;
				head.previous = node;
				head = node;
			} else if (current == null){ //didn't find anywhere to insert - insert at the end
				tail.next = node;
				node.previous = tail;
				tail = node;
			} else{ //insert in the middle
				previous.next = node;
				node.previous = previous;
				node.next = current;
				current.previous = node;
			}
		}
		size++; //increment size
	}

	@Override
	public Node remove(T data, Comparator<T> comparator){
		return super.remove(data, comparator);
	}

	@Override
	public ListIterator<T> iterator(){
		return super.iterator();
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