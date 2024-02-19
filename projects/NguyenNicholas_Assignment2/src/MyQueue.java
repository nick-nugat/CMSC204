/**
 * @author Nicholas Nguyen
 */

import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface<T> {
	private ArrayList<T> elements;
	private int capacity;


	public MyQueue(){
		capacity = 100;
		elements = new ArrayList<>(capacity);
	}

	public MyQueue(int capacity) {
		this.capacity = capacity;
		elements = new ArrayList<>(capacity);
	}

	@Override
	public boolean isEmpty() {
		return elements.isEmpty();
	}

	@Override
	public boolean isFull() {
		return elements.size() == capacity;
	}

	@Override
	public boolean enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}
		elements.add(element);
		return true;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}
		return elements.remove(0); // Remove the first element
	}

	@Override
	public int size() {
		return elements.size();
	}

	@Override
	public void fill(ArrayList<T> list) throws QueueOverflowException {
		for (T element : list) {
			if (isFull()) {
				throw new QueueOverflowException();
			}
			enqueue(element);
		}
	}

	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		for (T element : elements) {
			builder.append(element);
		}
		return builder.toString();
	}

	@Override
	public String toString(String delimiter) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < elements.size(); i++) {
			builder.append(elements.get(i).toString());
			if (i < elements.size() - 1) {
				builder.append(delimiter);
			}
		}
		return builder.toString();
	}
}
