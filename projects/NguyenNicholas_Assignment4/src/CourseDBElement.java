/**
 * @author Nicholas Nguyen
 */

public class CourseDBElement implements Comparable {
	private String courseID;
	private int CRN;
	private int credits;
	private String roomNumber;
	private String instructorName;

	public CourseDBElement(String courseID, int CRN, int credits, String roomNumber, String instructorName) {
		this.courseID = courseID;
		this.CRN = CRN;
		this.credits = credits;
		this.roomNumber = roomNumber;
		this.instructorName = instructorName;
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public int getCRN() {
		return CRN;
	}

	public void setCRN(int CRN) {
		this.CRN = CRN;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}
}
