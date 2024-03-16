import java.util.ArrayList;
import java.util.LinkedList;
import java.io.IOException;

/**
 * @author Nicholas Nguyen
 */

public class CourseDBStructure implements CourseDBStructureInterface {
	private static final double LOAD_FACTOR = 1.5;
	private LinkedList<CourseDBElement>[] hashTable;
	private int tableLength;

	/**
	 * Constructor to determine table length
	 * @param n estimated number of courses
	 */
	public CourseDBStructure(int n){
		tableLength = getNextPrime((int) (n / LOAD_FACTOR));
		hashTable = new LinkedList[tableLength];
		for (int i = 0; i < tableLength; i++) {
			hashTable[i] = new LinkedList<>();
		}
	}

	/**
	 * Constructor for testing purposes
	 * @param testing not used in actual constructor
	 * @param hashTableSize size of hash table
	 */
	public CourseDBStructure(String testing, int hashTableSize){
		tableLength = hashTableSize;
		hashTable = new LinkedList[tableLength];
		for (int i = 0; i < tableLength; i++) {
			hashTable[i] = new LinkedList<>();
		}
	}


	/**
	 * Adds to data structure based on hash code of CRN
	 * @param element the CourseDBElement to be added to CourseDBStructure
	 */
	@Override
	public void add(CourseDBElement element) {
		int index = element.getCRN() % tableLength;
		LinkedList<CourseDBElement> bucket = hashTable[index];

		if (bucket.isEmpty()){
			bucket.add(element);
		} else{
			for (CourseDBElement  e : bucket) {
				if (e.compareTo(element) == 0) {
					return;
				} else if (e.getCRN() == element.getCRN()) {
					if (!(e.getID().equals(element.getID()))) {
						e.setID(element.getID());
					}
					if (e.getCredits() != element.getCredits()) {
						e.setCredits(element.getCredits());
					}
					if (!(e.getRoomNum().equals(element.getRoomNum()))) {
						e.setRoomNum(element.getRoomNum());
					}
					if (!(e.getInstructorName().equals(element.getInstructorName()))) {
						e.setInstructorName(element.getInstructorName());
					}
					return;
				}
			}
		}
	}

	/**
	 * Gets a CourseDBElement based on its CRN
	 * @param CRN crn (key) whose associated courseDatabaseElement is to be returned
	 * @return an element based on CRN
	 * @throws IOException if key is not found from CRN
	 */
	@Override
	public CourseDBElement get(int CRN) throws IOException {
		int index = CRN % tableLength;
		LinkedList<CourseDBElement> bucket = hashTable[index];

		if (bucket.isEmpty()) throw new IOException();
		for (CourseDBElement e : bucket) {
			if (e.getCRN() == CRN){
				return e;
			}
		}
		throw new IOException();
	}

	/**
	 * Returns an ArrayList of String representing all the courses
	 * @return all courses as an ArrayList of String
	 */
	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> list = new ArrayList<>();
		
		for (LinkedList<CourseDBElement> bucket : hashTable) {
			for (CourseDBElement element : bucket) {
				list.add(element.toString());
			}
		}
		return list;
	}

	/**
	 *
	 * @return the length of the table
	 */
	@Override
	public int getTableSize() {
		return tableLength;
	}


	//helper methods for prime numbers

	/**
	 *
	 * @param n a number
	 * @return true if prime, false if not
	 */
	private static boolean isPrime(int n) {
		if (n <= 1) return false;
		if (n <= 3) return true;

		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) return false;
		}

		return true;
	}

	/**
	 *
	 * @param n a number
	 * @return the next prime number (4K + 3 prime)
	 */
	private static int getNextPrime(int n) {
		while (true) {
			if (isPrime(n) && (n % 4 == 3)) {
				return n;
			}
			n++;
		}
	}
}
