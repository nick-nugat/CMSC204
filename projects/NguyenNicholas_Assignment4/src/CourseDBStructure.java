import java.util.ArrayList;
import java.util.LinkedList;
import java.io.IOException;

/**
 * @author Nicholas Nguyen
 */

//implement a hash table with buckets
public class CourseDBStructure implements CourseDBStructureInterface {
	//each element will have a hash code calculated based on CRN (since it's unique)
	//however, tests require hashcode of String
	private static final double LOAD_FACTOR = 1.5;
	private LinkedList<CourseDBElement>[] hashTable;
	private int tableLength;
	private static final String COURSE_AS_STRING = "\nCourse:%s CRN:%d Credits:%d Instructor:%s Room:%s";

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

	@Override
	public CourseDBElement get(int CRN) throws IOException {
		int index = CRN % tableLength;
		LinkedList<CourseDBElement> bucket = hashTable[index];

		for (CourseDBElement e : bucket) {
			if (e.getCRN() == CRN){
				return e;
			}
		}
		throw new IOException();
	}

	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> list = new ArrayList<>();
		
		for (LinkedList<CourseDBElement> bucket : hashTable) {
			for (CourseDBElement element : bucket) {
				String ID = element.getID();
				int CRN = element.getCRN();
				int credits = element.getCredits();
				String instructorName = element.getInstructorName();
				String roomNum = element.getRoomNum();
				
				String courseString = String.format(COURSE_AS_STRING, ID, CRN, credits, instructorName, roomNum);
				list.add(courseString);
			}
		}
		return list;
	}

	@Override
	public int getTableSize() {
		return tableLength;
	}


	//helper methods for prime numbers
	private static int getNextPrime(int n) {
		while (true) {
			if (isPrime(n) && (n % 4 == 3)) {
				return n;
			}
			n++;
		}
	}

	private static boolean isPrime(int n) {
		if (n <= 1) return false;
		if (n <= 3) return true;

		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) return false;
		}

		return true;
	}
}
