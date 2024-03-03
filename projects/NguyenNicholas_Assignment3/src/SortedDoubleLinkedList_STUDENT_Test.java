import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class SortedDoubleLinkedList_STUDENT_Test {
	SortedDoubleLinkedList<String> sortedLinkedString;
	SortedDoubleLinkedList<Double> sortedLinkedDouble;
	SortedDoubleLinkedList<Car> sortedLinkedCar;
	StringComparator comparator;
	DoubleComparator comparatorD;
	CarComparator comparatorCar;

	public Car
			a = new Car("Tesla", "Cybertruck", 2023),
			b = new Car("Land Rover", "Defender", 2023),
			c = new Car("Toyota", "Supra", 2023),
			d = new Car("Audi", "RS6 Avant", 2023),
			e = new Car("Mercedes-Benz", "G-Class", 2023),
			f = new Car("BMW", "i4", 2023);
	//alphabetical order: d, f, b, e, a, c

	@Before
	public void setUp() throws Exception {
		comparator = new StringComparator();
		sortedLinkedString = new SortedDoubleLinkedList<>(comparator);

		comparatorD = new DoubleComparator();
		sortedLinkedDouble = new SortedDoubleLinkedList<>(comparatorD);

		comparatorCar = new CarComparator();
		sortedLinkedCar = new SortedDoubleLinkedList<>(comparatorCar);
	}

	@After
	public void tearDown() throws Exception {
		comparator = null;
		comparatorD = null;
		comparatorCar = null;
		sortedLinkedString = null;
		sortedLinkedDouble = null;
		sortedLinkedCar = null;
	}

	@Test
	public void testAddToEnd() {
		try {
			sortedLinkedString.addToEnd("error");
			sortedLinkedDouble.addToEnd(38.0);
			sortedLinkedCar.addToEnd(c);
			assertTrue("Did not throw an UnsupportedOperationException", false);
		} catch (UnsupportedOperationException e) {
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		} catch (Exception e) {
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testAddToFront() {
		try {
			sortedLinkedString.addToFront("error");
			sortedLinkedDouble.addToFront(38.0);
			sortedLinkedCar.addToFront(c);
			assertTrue("Did not throw an UnsupportedOperationException", false);
		} catch (UnsupportedOperationException e) {
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		} catch (Exception e) {
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testIteratorSuccessfulNext() {
		ListIterator<String> iterator = sortedLinkedString.iterator();
		ListIterator<Car> iteratorCar = sortedLinkedCar.iterator();
		ListIterator<Double> iteratorDouble = sortedLinkedDouble.iterator();

		sortedLinkedString.add("hi");
		sortedLinkedString.add("there");
		assertTrue(iterator.hasNext());
		assertEquals("hi", iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals("there", iterator.next());

		sortedLinkedCar.add(a);
		sortedLinkedCar.add(b);
		sortedLinkedCar.add(c);
		sortedLinkedCar.add(d);
		sortedLinkedCar.add(e);
		sortedLinkedCar.add(f);

		assertTrue(iteratorCar.hasNext());
		assertEquals(d, iteratorCar.next());
		assertEquals(f, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(e, iteratorCar.next());
		assertEquals(a, iteratorCar.next());
		assertTrue(iteratorCar.hasNext());
		assertEquals(c, iteratorCar.next());

		sortedLinkedDouble.add(68.7);
		sortedLinkedDouble.add(21.3);
		assertTrue(iteratorDouble.hasNext());
		assertEquals(21.3, iteratorDouble.next(), 0);
		assertTrue(iteratorDouble.hasNext());
		assertEquals(68.7, iteratorDouble.next(), 0);
	}

	@Test
	public void testIteratorSuccessfulStringPrevious() {
		ListIterator<String> iteratorString = sortedLinkedString.iterator();

		sortedLinkedString.add("house");
		sortedLinkedString.add("clash");
		sortedLinkedString.add("use");
		sortedLinkedString.add("homework");

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
	}

	@Test
	public void testIteratorSuccessfulCarPrevious() {
		ListIterator<Car> iteratorCar = sortedLinkedCar.iterator();

		sortedLinkedCar.add(a);
		sortedLinkedCar.add(b);
		sortedLinkedCar.add(c);
		sortedLinkedCar.add(d);
		sortedLinkedCar.add(e);
		sortedLinkedCar.add(f);

		assertTrue(iteratorCar.hasNext());
		assertEquals(d, iteratorCar.next());
		assertEquals(f, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(e, iteratorCar.next());
		assertEquals(a, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertTrue(iteratorCar.hasPrevious());
		assertEquals(c, iteratorCar.previous());
		assertEquals(a, iteratorCar.previous());
		assertEquals(e, iteratorCar.previous());
		assertEquals(b, iteratorCar.previous());
		assertEquals(f, iteratorCar.previous());
		assertEquals(d, iteratorCar.previous());
	}

	@Test
	public void testIteratorSuccessfulDoubleNext() {
		ListIterator<Double> iteratorDouble = sortedLinkedDouble.iterator();

		sortedLinkedDouble.add(80.0);
		sortedLinkedDouble.add(3.66);
		sortedLinkedDouble.add(21.9);
		sortedLinkedDouble.add(30.0);

		assertTrue(iteratorDouble.hasNext());
		assertEquals(3.66, iteratorDouble.next(), 0);
		assertEquals(21.9, iteratorDouble.next(), 0);
		assertEquals(30.0, iteratorDouble.next(), 0);
		assertEquals(80.0, iteratorDouble.next(), 0);
	}

	@Test
	public void testIteratorSuccessfulDoublePrevious() {
		ListIterator<Double> iteratorDouble = sortedLinkedDouble.iterator();

		sortedLinkedDouble.add(80.0);
		sortedLinkedDouble.add(3.66);
		sortedLinkedDouble.add(21.9);
		sortedLinkedDouble.add(30.0);

		assertTrue(iteratorDouble.hasNext());
		assertEquals(3.66, iteratorDouble.next(), 0);
		assertEquals(21.9, iteratorDouble.next(), 0);
		assertEquals(30.0, iteratorDouble.next(), 0);
		assertEquals(80.0, iteratorDouble.next(), 0);
		assertTrue(iteratorDouble.hasPrevious());
		assertEquals(80.0, iteratorDouble.previous(), 0);
		assertEquals(30.0, iteratorDouble.previous(), 0);
		assertEquals(21.9, iteratorDouble.previous(), 0);
		assertEquals(3.66, iteratorDouble.previous(), 0);
	}

	@Test
	public void testIteratorNoSuchElementException() {
		ListIterator<Car> iteratorCar = sortedLinkedCar.iterator();
		ListIterator<Double> iteratorDouble = sortedLinkedDouble.iterator();

		sortedLinkedCar.add(a);
		sortedLinkedCar.add(b);
		sortedLinkedCar.add(c);
		sortedLinkedCar.add(d);
		sortedLinkedCar.add(e);
		sortedLinkedCar.add(f);

		assertTrue(iteratorCar.hasNext());
		assertEquals(d, iteratorCar.next());
		assertEquals(f, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(e, iteratorCar.next());
		assertEquals(a, iteratorCar.next());
		assertTrue(iteratorCar.hasNext());
		assertEquals(c, iteratorCar.next());

		sortedLinkedDouble.add(80.0);
		sortedLinkedDouble.add(3.66);
		sortedLinkedDouble.add(21.9);
		sortedLinkedDouble.add(30.0);

		assertTrue(iteratorDouble.hasNext());
		assertEquals(3.66, iteratorDouble.next(), 0);
		assertEquals(21.9, iteratorDouble.next(), 0);
		assertEquals(30.0, iteratorDouble.next(), 0);
		assertTrue(iteratorDouble.hasNext());
		assertEquals(80.0, iteratorDouble.next(), 0);

		try {
			//no more elements in list
			iteratorCar.next();
			iteratorDouble.next();
			assertTrue("Did not throw a NoSuchElementException", false);
		} catch (NoSuchElementException e) {
			assertTrue("Successfully threw a NoSuchElementException", true);
		} catch (Exception e) {
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
	}

	@Test
	public void testIteratorUnsupportedOperationExceptionString() {
		ListIterator<String> iterator = sortedLinkedString.iterator();
		sortedLinkedString.add("batch");
		sortedLinkedString.add("how");
		sortedLinkedString.add("to");

		try {
			//remove is not supported for the iterator
			iterator.remove();
			assertTrue("Did not throw a UnsupportedOperationException", false);
		} catch (UnsupportedOperationException e) {
			assertTrue("Successfully threw a UnsupportedOperationException", true);
		} catch (Exception e) {
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testAddCar() {
		sortedLinkedCar.add(a);
		sortedLinkedCar.add(b);
		sortedLinkedCar.add(c);
		sortedLinkedCar.add(d);
		assertEquals(d, sortedLinkedCar.getFirst());
		sortedLinkedCar.add(e);
		sortedLinkedCar.add(f);
		assertEquals(c, sortedLinkedCar.getLast());

		assertEquals(d, sortedLinkedCar.retrieveFirstElement());
		assertEquals(f, sortedLinkedCar.getFirst());
		assertEquals(c, sortedLinkedCar.retrieveLastElement());
		assertEquals(a, sortedLinkedCar.getLast());
	}

	@Test
	public void testRemoveFirstCar() {
		sortedLinkedCar.add(a);
		sortedLinkedCar.add(b);
		sortedLinkedCar.add(c);
		sortedLinkedCar.add(d);
		assertEquals(d, sortedLinkedCar.getFirst());
		sortedLinkedCar.add(e);
		sortedLinkedCar.add(f);
		assertEquals(c, sortedLinkedCar.getLast());

		assertEquals(d, sortedLinkedCar.getFirst());
		sortedLinkedCar.remove(d, comparatorCar);
		assertEquals(f, sortedLinkedCar.getFirst());
	}

	@Test
	public void testRemoveEndCar() {
		sortedLinkedCar.add(a);
		sortedLinkedCar.add(b);
		sortedLinkedCar.add(c);
		sortedLinkedCar.add(d);
		assertEquals(d, sortedLinkedCar.getFirst());
		sortedLinkedCar.add(e);
		sortedLinkedCar.add(f);
		assertEquals(c, sortedLinkedCar.getLast());

		assertEquals(c, sortedLinkedCar.getLast());
		sortedLinkedCar.remove(c, comparatorCar);
		assertEquals(a, sortedLinkedCar.getLast());
	}

	@Test
	public void testRemoveMiddleCar() {
		sortedLinkedCar.add(a);
		sortedLinkedCar.add(b);
		sortedLinkedCar.add(c);
		sortedLinkedCar.add(d);
		assertEquals(d, sortedLinkedCar.getFirst());
		sortedLinkedCar.add(e);
		sortedLinkedCar.add(f);
		assertEquals(c, sortedLinkedCar.getLast());

		assertEquals(6, sortedLinkedCar.getSize());
		sortedLinkedCar.remove(b, comparatorCar);
		assertEquals(d, sortedLinkedCar.getFirst());
		assertEquals(c, sortedLinkedCar.getLast());
		assertEquals(5, sortedLinkedCar.getSize());
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
			return arg0.getMake().compareTo(arg1.getMake());
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
