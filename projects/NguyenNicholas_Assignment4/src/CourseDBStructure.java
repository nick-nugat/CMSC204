import java.util.ArrayList;
import java.util.LinkedList;

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
			boolean duplicate = false;
			for (CourseDBElement  e : bucket) {
				if (e.getCRN() == element.getCRN()){
					duplicate = true;
					break;
				}
			}
			if (!duplicate){
				bucket.add(element);
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
			} else break;
		}
		throw new IOException();

	}

	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> list = new ArrayList<>();
		
		for (LinkedList<CourseDBElement> bucket : hashTable) {
			for (CourseDBElement element : bucket) {
				String id = element.getID();
				int CRN = element.getCRN();
				int credits = element.getCredits();
				String instructorName = element.getInstructorName();
				String roomNum = element.getRoomNum();
				
				String courseString = String.format(
						COURSE_AS_STRING,
							id, CRN, credits, instructorName, roomNum
				);

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

	/**
	 * Checks if a number is prime or not
	 * @param n number to check
	 * @return whether number is prime or not
	 */
	private static boolean isPrime(int n){
		if (n <= 1) return false;
		for (int i = 2; i < Math.sqrt(n); i++) {
			if (n % i == 0){
				return false;
			}
		}
		return true;
	}

	/**
	 * Gets the next prime number
	 * @param n number to check
	 * @return the next prime number
	 */
	private static int getNextPrime(int n){
		while (!isPrime(n)){
			n++;
		}
		return n;
	}

}
