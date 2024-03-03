

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BasicDoubleLinkedList_STUDENT_Test {
	BasicDoubleLinkedList<String> linkedString;
	BasicDoubleLinkedList<Double> linkedDouble;
	BasicDoubleLinkedList<Car> linkedCar;

	StringComparator stringComparator;
	DoubleComparator doubleComparator;
	CarComparator carComparator;

	public Car
			a = new Car("Tesla", "Cybertruck", 2023),
			b = new Car("Land Rover", "Defender", 2023),
			c = new Car("Toyota", "Supra", 2023),
			d = new Car("Audi", "RS6 Avant", 2023),
			e = new Car("Mercedes-Benz", "G-Class", 2023),
			f = new Car("BMW", "i4", 2023);


	@Before
	public void setUp() throws Exception {
		linkedString = new BasicDoubleLinkedList<>();
		linkedString.addToEnd("homework");
		linkedString.addToEnd("house");
		stringComparator = new StringComparator();

		linkedDouble = new BasicDoubleLinkedList<>();
		linkedDouble.addToEnd(80.0);
		linkedDouble.addToEnd(30.0);
		doubleComparator = new DoubleComparator();

		linkedCar = new BasicDoubleLinkedList<>();
		linkedCar.addToEnd(b);
		linkedCar.addToEnd(c);
		carComparator = new CarComparator();
	}

	@After
	public void tearDown() throws Exception {
		linkedString = null;
		linkedDouble = null;
		linkedCar = null;
		doubleComparator = null;
		stringComparator = null;
	}

	@Test
	public void testGetSize() {
		assertEquals(2, linkedString.getSize());
		assertEquals(2, linkedDouble.getSize());
		assertEquals(2, linkedCar.getSize());
	}

	@Test
	public void testAddToEnd() {
		assertEquals("house", linkedString.getLast());
		linkedString.addToEnd("finish");
		assertEquals("finish", linkedString.getLast());

		assertEquals(c, linkedCar.getLast());
		linkedCar.addToEnd(d);
		assertEquals(d, linkedCar.getLast());

		assertEquals(30.0, linkedDouble.getLast(), .0);
		linkedDouble.addToEnd(40.0);
		assertEquals(40.0, linkedDouble.getLast(), .0);
	}

	@Test
	public void testAddToFront() {
		assertEquals("homework", linkedString.getFirst());
		linkedString.addToFront("food");
		assertEquals("food", linkedString.getFirst());

		assertEquals(b, linkedCar.getFirst());
		linkedCar.addToFront(a);
		assertEquals(a, linkedCar.getFirst());

		assertEquals(80.0, linkedDouble.getFirst(), .0);
		linkedDouble.addToFront(23.3);
		assertEquals(23.3, linkedDouble.getFirst(), .0);
	}

	@Test
	public void testGetFirst() {
		assertEquals("homework", linkedString.getFirst());
		linkedString.addToFront("kind");
		assertEquals("kind", linkedString.getFirst());

		assertEquals(b, linkedCar.getFirst());
		linkedCar.addToFront(a);
		assertEquals(a, linkedCar.getFirst());

		assertEquals(80.0, linkedDouble.getFirst(), .0);
		linkedDouble.addToFront(67.8);
		assertEquals(67.8, linkedDouble.getFirst(), .0);
	}

	@Test
	public void testGetLast() {
		assertEquals("house", linkedString.getLast());
		linkedString.addToEnd("tired");
		assertEquals("tired", linkedString.getLast());

		assertEquals(c, linkedCar.getLast());
		linkedCar.addToEnd(d);
		assertEquals(d, linkedCar.getLast());

		assertEquals(30.0, linkedDouble.getLast(), .0);
		linkedDouble.addToEnd(96.2);
		assertEquals(96.2, linkedDouble.getLast(), .0);
	}

	@Test
	public void testToArrayList() {
		ArrayList<String> listOfStrings;
		ArrayList<Car> list;
		ArrayList<Double> listOfDoubles;

		linkedString.addToEnd("difficult");
		linkedString.addToEnd("interesting");
		linkedString.addToFront("bubbly");
		listOfStrings = linkedString.toArrayList();

		assertEquals("bubbly", listOfStrings.get(0));
		assertEquals("homework", listOfStrings.get(1));
		assertEquals("house", listOfStrings.get(2));
		assertEquals("difficult", listOfStrings.get(3));
		assertEquals("interesting", listOfStrings.get(4));

		linkedCar.addToFront(a);
		linkedCar.addToEnd(d);
		list = linkedCar.toArrayList();
		assertEquals(a, list.get(0));
		assertEquals(b, list.get(1));
		assertEquals(c, list.get(2));
		assertEquals(d, list.get(3));

		linkedDouble.addToEnd(2.0);
		linkedDouble.addToFront(34.8);
		listOfDoubles = linkedDouble.toArrayList();
		assertEquals(34.8, listOfDoubles.get(0), 0);
		assertEquals(80.0, listOfDoubles.get(1), 0);
		assertEquals(30.0, listOfDoubles.get(2), 0);
		assertEquals(2.0, listOfDoubles.get(3), 0);
	}

	@Test
	public void testIteratorSuccessfulNext() {
		ListIterator<String> iterator = linkedString.iterator();
		ListIterator<Car> iteratorCar = linkedCar.iterator();
		ListIterator<Double> iteratorDouble = linkedDouble.iterator();

		linkedString.addToFront("start");
		linkedString.addToEnd("finish");
		assertTrue(iterator.hasNext());
		assertEquals("start", iterator.next());
		assertEquals("homework", iterator.next());
		assertEquals("house", iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals("finish", iterator.next());

		linkedCar.addToFront(a);
		linkedCar.addToEnd(d);
		assertTrue(iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertTrue(iteratorCar.hasNext());
		assertEquals(d, iteratorCar.next());

		linkedDouble.addToFront(68.7);
		linkedDouble.addToEnd(21.3);
		assertTrue(iteratorDouble.hasNext());
		assertEquals(68.7, iteratorDouble.next(), 0);
		assertEquals(80.0, iteratorDouble.next(), 0);
		assertEquals(30.0, iteratorDouble.next(), 0);
		assertTrue(iteratorDouble.hasNext());
		assertEquals(21.3, iteratorDouble.next(), 0);
	}

	@Test
	public void testIteratorSuccessfulPrevious() {
		ListIterator<Car> iteratorCar = linkedCar.iterator();
		ListIterator<String> iteratorString = linkedString.iterator();
		ListIterator<Double> iteratorDouble = linkedDouble.iterator();

		linkedCar.addToFront(a);
		linkedCar.addToEnd(d);
		assertTrue(iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(d, iteratorCar.next());
		assertTrue(iteratorCar.hasPrevious());
		assertEquals(d, iteratorCar.previous());
		assertEquals(c, iteratorCar.previous());
		assertEquals(b, iteratorCar.previous());
		assertEquals(a, iteratorCar.previous());

		linkedString.addToFront("clash");
		linkedString.addToEnd("use");
		assertTrue(iteratorString.hasNext());
		assertEquals("clash", iteratorString.next());
		assertEquals("homework", iteratorString.next());
		assertEquals("house", iteratorString.next());
		assertEquals("use", iteratorString.next());
		assertTrue(iteratorString.hasPrevious());
		assertEquals("use", iteratorString.previous());
		assertEquals("house", iteratorString.previous());
		assertEquals("homework", iteratorString.previous());
		assertEquals("clash", iteratorString.previous());

		linkedDouble.addToFront(3.66);
		linkedDouble.addToEnd(21.9);
		assertTrue(iteratorDouble.hasNext());
		assertEquals(3.66, iteratorDouble.next(), 0);
		assertEquals(80.0, iteratorDouble.next(), 0);
		assertEquals(30.0, iteratorDouble.next(), 0);
		assertEquals(21.9, iteratorDouble.next(), 0);
		assertTrue(iteratorDouble.hasPrevious());
		assertEquals(21.9, iteratorDouble.previous(), 0);
		assertEquals(30.0, iteratorDouble.previous(), 0);
		assertEquals(80.0, iteratorDouble.previous(), 0);
		assertEquals(3.66, iteratorDouble.previous(), 0);
	}

	@Test
	public void testIteratorNoSuchElementExceptionNext() {
		ListIterator<Car> iteratorCar = linkedCar.iterator();
		ListIterator<Double> iteratorDouble = linkedDouble.iterator();

		linkedCar.addToFront(a);
		linkedCar.addToEnd(d);
		assertTrue(iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertTrue(iteratorCar.hasNext());
		assertEquals(d, iteratorCar.next());

		linkedDouble.addToFront(63.2);
		linkedDouble.addToEnd(32.0);
		assertTrue(iteratorDouble.hasNext());
		assertEquals(63.2, iteratorDouble.next(), 0);
		assertEquals(80.0, iteratorDouble.next(), 0);
		assertEquals(30.0, iteratorDouble.next(), 0);
		assertTrue(iteratorDouble.hasNext());
		assertEquals(32.0, iteratorDouble.next(), 0);

		try {
			//no more elements in list
			iteratorCar.next();
			assertTrue("Did not throw a NoSuchElementException", false);
		} catch (NoSuchElementException e) {
			assertTrue("Successfully threw a NoSuchElementException", true);
		} catch (Exception e) {
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}

	}

	@Test
	public void testIteratorNoSuchElementExceptionPrevious() {
		linkedCar.addToFront(a);
		linkedCar.addToEnd(d);
		ListIterator<Car> iteratorCar = linkedCar.iterator();
		linkedDouble.addToFront(63.2);
		linkedDouble.addToEnd(32.0);
		ListIterator<Double> iteratorDouble = linkedDouble.iterator();

		assertTrue(iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(d, iteratorCar.next());
		assertTrue(iteratorCar.hasPrevious());
		assertEquals(d, iteratorCar.previous());
		assertEquals(c, iteratorCar.previous());
		assertEquals(b, iteratorCar.previous());
		assertEquals(a, iteratorCar.previous());

		assertTrue(iteratorDouble.hasNext());
		assertEquals(63.2, iteratorDouble.next(), 0);
		assertEquals(80.0, iteratorDouble.next(), 0);
		assertEquals(30.0, iteratorDouble.next(), 0);
		assertEquals(32.0, iteratorDouble.next(), 0);
		assertTrue(iteratorDouble.hasPrevious());
		assertEquals(32.0, iteratorDouble.previous(), 0);
		assertEquals(30.0, iteratorDouble.previous(), 0);
		assertEquals(80.0, iteratorDouble.previous(), 0);
		assertEquals(63.2, iteratorDouble.previous(), 0);


		try {
			//no more elements in list
			iteratorCar.previous();
			assertTrue("Did not throw a NoSuchElementException", false);
		} catch (NoSuchElementException e) {
			assertTrue("Successfully threw a NoSuchElementException", true);
		} catch (Exception e) {
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}

	}

	@Test
	public void testIteratorUnsupportedOperationException() {
		linkedCar.addToFront(a);
		linkedCar.addToEnd(d);
		ListIterator<Car> iteratorCar = linkedCar.iterator();
		ListIterator<Double> iteratorDouble = linkedDouble.iterator();

		assertTrue(iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertTrue(iteratorCar.hasNext());
		assertEquals(d, iteratorCar.next());

		linkedDouble.addToFront(63.2);
		linkedDouble.addToEnd(32.0);
		assertTrue(iteratorDouble.hasNext());
		assertEquals(63.2, iteratorDouble.next(), 0);
		assertEquals(80.0, iteratorDouble.next(), 0);
		assertEquals(30.0, iteratorDouble.next(), 0);
		assertTrue(iteratorDouble.hasNext());
		assertEquals(32.0, iteratorDouble.next(), 0);
		try {
			//remove is not supported for the iterator
			iteratorCar.remove();
			assertTrue("Did not throw a UnsupportedOperationException", false);
		} catch (UnsupportedOperationException e) {
			assertTrue("Successfully threw a UnsupportedOperationException", true);
		} catch (Exception e) {
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}

	}

	@Test
	public void testRemove() {
		// remove the first
		assertEquals(b, linkedCar.getFirst());
		assertEquals(c, linkedCar.getLast());
		linkedCar.addToFront(a);
		assertEquals(a, linkedCar.getFirst());
		linkedCar.remove(a, carComparator);
		assertEquals(b, linkedCar.getFirst());
		//remove from the end of the list
		linkedCar.addToEnd(d);
		assertEquals(d, linkedCar.getLast());
		linkedCar.remove(d, carComparator);
		assertEquals(c, linkedCar.getLast());
		//remove from middle of list
		linkedCar.addToFront(a);
		assertEquals(a, linkedCar.getFirst());
		assertEquals(c, linkedCar.getLast());
		linkedCar.remove(b, carComparator);
		assertEquals(a, linkedCar.getFirst());
		assertEquals(c, linkedCar.getLast());

	}

	@Test
	public void testRetrieveFirstElement() {
		assertEquals(b, linkedCar.getFirst());
		linkedCar.addToFront(a);
		assertEquals(a, linkedCar.getFirst());
		assertEquals(a, linkedCar.retrieveFirstElement());
		assertEquals(b, linkedCar.getFirst());
		assertEquals(b, linkedCar.retrieveFirstElement());
		assertEquals(c, linkedCar.getFirst());

		assertEquals("homework", linkedString.getFirst());
		linkedString.addToFront("start");
		assertEquals("start", linkedString.getFirst());
		assertEquals("start", linkedString.retrieveFirstElement());
		assertEquals("homework", linkedString.getFirst());
		assertEquals("homework", linkedString.retrieveFirstElement());
		assertEquals("house", linkedString.getFirst());

		assertEquals(80.0, linkedDouble.getFirst(), 0);
		linkedDouble.addToFront(69.23);
		assertEquals(69.23, linkedDouble.getFirst(), 0);
		assertEquals(69.23, linkedDouble.retrieveFirstElement(), 0);
		assertEquals(80.0, linkedDouble.getFirst(), 0);
		assertEquals(80.0, linkedDouble.retrieveFirstElement(), 0);
		assertEquals(30.0, linkedDouble.getFirst(), 0);
	}

	@Test
	public void testRetrieveLastElement() {
		assertEquals(c, linkedCar.getLast());
		linkedCar.addToEnd(d);
		assertEquals(d, linkedCar.getLast());
		assertEquals(d, linkedCar.retrieveLastElement());
		assertEquals(c, linkedCar.getLast());

		assertEquals("house", linkedString.getLast());
		linkedString.addToEnd("start");
		assertEquals("start", linkedString.getLast());
		assertEquals("start", linkedString.retrieveLastElement());
		assertEquals("house", linkedString.getLast());

		assertEquals(30.0, linkedDouble.getLast(), 0);
		linkedDouble.addToEnd(32.0);
		assertEquals(32.0, linkedDouble.getLast(), 0);
		assertEquals(32.0, linkedDouble.retrieveLastElement(), 0);
		;
		assertEquals(30.0, linkedDouble.getLast(), 0);

	}

	private class StringComparator implements Comparator<String> {

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}

	}

	private class DoubleComparator implements Comparator<Double> {

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}

	}

	private class CarComparator implements Comparator<Car> {

		@Override
		public int compare(Car arg0, Car arg1) {
			// Just put cars in alphabetic order by make
			return arg0.toString().compareTo(arg1.toString());
		}

	}

	private class Car {
		String make;
		String model;
		int year;

		public Car(String make, String model, int year) {
			this.make = make;
			this.model = model;
			this.year = year;
		}

		public String getMake() {
			return make;
		}

		public String getModel() {
			return model;
		}

		public int getYear() {
			return year;
		}

		public String toString() {
			return (getMake() + " " + getModel() + " " + getYear());
		}
	}
}
