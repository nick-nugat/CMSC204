import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Nicholas Nguyen
 */

public class CourseDBManager implements CourseDBManagerInterface {
	private CourseDBStructure structure;

	/**
	 * Constructor to initialize a CourseDBStructure with a length
	 */
	public CourseDBManager(){
		structure = new CourseDBStructure(100); //not sure what num i should be putting here
	}

	/**
	 * Adds to a CourseDBStructure data structure by calling its respective add() method
	 * @param ID course ID
	 * @param CRN course CRN
	 * @param credits number of credits
	 * @param roomNum course room number
	 * @param instructor name of the instructor
	 */
	@Override
	public void add(String ID, int CRN, int credits, String roomNum, String instructor) {
		CourseDBElement element = new CourseDBElement(ID, CRN, credits, roomNum, instructor);
		structure.add(element);
	}

	/**
	 * Gets a CourseDBElement based on its CRN by calling the get() method of CourseDBStructure
	 * Throws IOException if key isn't found
	 * @param CRN course CRN (key)
	 * @return an element based on the CRN
	 */
	@Override
	public CourseDBElement get(int CRN) {
		try{
			return structure.get(CRN);
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
		return null;
	}

	/**
	 * Reads data from an input file
	 * @param input input file
	 * @throws FileNotFoundException if file does not exist
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		Scanner scanner = new Scanner(input);

		while (scanner.hasNextLine()){
			String line = scanner.nextLine().trim();
			String[] courseAsArray = line.split(" ");
			int length = courseAsArray.length;

			String ID = courseAsArray[0].trim();
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
					instructorName += courseAsArray[i] + " ";
				}
				instructorName = instructorName.trim();
			}
			add(ID, CRN, credits, roomNum, instructorName);
		}
	}

	/**
	 * Calls showAll() method of CourseDBStructure to display all courses in the data structure
	 * @return an ArrayList of String representing all courses
	 */
	@Override
	public ArrayList<String> showAll() {
		return structure.showAll();
	}
}
