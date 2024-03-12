import java.util.ArrayList;

/**
 * @author Nicholas Nguyen
 */

public class CourseDBStructure implements CourseDBStructureInterface {
	/*This class has two constructors:
			1)	A constructor that takes in an integer n which represents the estimated number of
	courses and determines the size of the hash table by finding a 4K+3 prime just greater than n /loading factor.
	Example:  if n is 500 courses, then 500/1.5 = 333, The next 4K+3 prime over 333 is 347.  So, you would set the table a length to 347.

			2)	A Constructor for testing purposes. This constructor will take a string “Testing” and an int for the hashtable size.  This is used only for testing.
*/

	public CourseDBStructure(int n){}

	//constructor for testing purposes (?)
	public CourseDBStructure(String testing, int hashTableSize){}

	//refer to interface for help

	@Override
	public void add(CourseDBElement element) {

	}

	@Override
	public CourseDBElement get(int crn) throws IOException {
		return null;
	}

	@Override
	public ArrayList<String> showAll() {
		return null;
	}

	@Override
	public int getTableSize() {
		return 0;
	}
}
