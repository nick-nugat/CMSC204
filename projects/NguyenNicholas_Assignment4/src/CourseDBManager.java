import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * @author Nicholas Nguyen
 */

public class CourseDBManager implements CourseDBManagerInterface {

	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {

	}

	@Override
	public CourseDBElement get(int crn) {
		return null;
	}

	@Override
	public void readFile(File input) throws FileNotFoundException {

	}

	@Override
	public ArrayList<String> showAll() {
		return null;
	}
}
