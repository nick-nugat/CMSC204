import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Nicholas Nguyen
 */

public class CourseDBManager implements CourseDBManagerInterface {
	private CourseDBStructure structure;

	public CourseDBManager(){
		structure = new CourseDBStructure(100); //not sure what num i should be putting here
	}

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
	public CourseDBElement get(int crn) throws IOException {
		return structure.get(crn);
	}

	/**
	 *
	 * @param input input file
	 * @throws FileNotFoundException
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		Scanner scanner = new Scanner(input);

		while (scanner.hasNextLine()){
			String line = scanner.nextLine().trim();
			String[] courseAsArray = line.split(" ");
			int length = courseAsArray.length;

			String id = courseAsArray[0].trim();
			int CRN = Integer.parseInt(courseAsArray[1].trim());
			int credits = Integer.parseInt(courseAsArray[2].trim());
			String roomNum = courseAsArray[3].trim();
			String instructorName = "";
			if (courseAsArray[4].equals("Learning")){
				roomNum += " Learning";
				for (int i = 5; i < length; i++) {
					instructorName += courseAsArray[i];
				}
			} else {
				for (int i = 4; i < length; i++) {
					instructorName += courseAsArray[i];
				}
			}
			add(id, CRN, credits, roomNum, instructorName);
		}
	}

	/**
	 *
	 * @return
	 */
	@Override
	public ArrayList<String> showAll() {
		return structure.showAll();
	}
}
