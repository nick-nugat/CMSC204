import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * @author Nicholas Nguyen
 */

public class CourseDBManager implements CourseDBManagerInterface {
	CourseDBStructure structure;


	/**
	 *
	 * @param id course id
	 * @param crn course crn
	 * @param credits number of credits
	 * @param roomNum course room number
	 * @param instructor name of the instructor
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement element = new CourseDBElement(id, crn, credits, roomNum, instructor);
		structure.add(element);
	}

	/**
	 *
	 * @param crn course crn (key)
	 * @return
	 */
	@Override
	public CourseDBElement get(int crn) {
		return null;
	}

	/**
	 *
	 * @param input input file
	 * @throws FileNotFoundException
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {

	}

	/**
	 *
	 * @return
	 */
	@Override
	public ArrayList<String> showAll() {
		return null;
	}
}
