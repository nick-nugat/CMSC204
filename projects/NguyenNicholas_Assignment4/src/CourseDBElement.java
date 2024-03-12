/**
 * @author Nicholas Nguyen
 */

public class CourseDBElement implements Comparable {
	private String courseID;
	private int crn;
	private int credits;
	private String roomNumber;
	private String instructorName;

	@Override
	public int compareTo(Object o) {
		return 0;
	}
}
