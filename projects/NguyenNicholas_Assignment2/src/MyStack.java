import java.util.ArrayList;

public class MyStack<T> implements StackInterface<T> {
	private ArrayList<T> elements;
	private int capacity; // Maximum capacity of the stack

	public MyStack(){
		capacity = 100;
		elements = new ArrayList<>(capacity);
	}

	public MyStack(int capacity) {
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
	public boolean push(T element) throws StackOverflowException {
		if (isFull()) {
			throw new StackOverflowException();
		}
		elements.add(element);
		return true;
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException();
		}
		return elements.remove(elements.size() - 1);
	}

	@Override
	public T top() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException();
		}
		return elements.get(elements.size() - 1);
	}

	@Override
	public int size() {
		return elements.size();
	}

	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < elements.size(); i++) {
			builder.append(elements.get(i));
		}
		return builder.toString();
	}

	@Override
	public String toString(String delimiter) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < elements.size(); i++) {
			sb.append(elements.get(i).toString());
			if (i < elements.size() - 1) {
				sb.append(delimiter);
			}
		}
		return sb.toString();
	}

	@Override
	public void fill(ArrayList<T> list) throws StackOverflowException {
		for (T element : list) {
			if (isFull()) {
				throw new StackOverflowException();
			}
			push(element);
		}
	}
}
