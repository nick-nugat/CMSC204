/**
 * @author Nicholas Nguyen
 */

public class CourseDBElement implements Comparable {
	private String ID;
	private int CRN;
	private int credits;
	private String roomNum;
	private String instructorName;
	private static final String COURSE_AS_STRING = "\nCourse:%s CRN:%d Credits:%d Instructor:%s Room:%s";

	public CourseDBElement(){

	}
	public CourseDBElement(String ID, int CRN, int credits, String roomNum, String instructorName) {
		this.ID = ID;
		this.CRN = CRN;
		this.credits = credits;
		this.roomNum = roomNum;
		this.instructorName = instructorName;
	}

	/**
	 * Compares each attribute of an element
	 * @param o the object to be compared.
	 * @return
	 */
	@Override
	public int compareTo(Object o) {
		if (!(o instanceof CourseDBElement other)){
			throw new IllegalArgumentException("That is not an instance of CourseDBElement! Please try again.");
		}

		if (!this.ID.equals(other.getID())) {
			return this.ID.compareTo(other.getID());
		}
		if (this.CRN != other.getCRN()) {
			return Integer.compare(this.CRN, other.getCRN());
		}
		if (this.credits != other.getCredits()) {
			return Integer.compare(this.credits, other.getCredits());
		}
		if (!this.roomNum.equals(other.getRoomNum())) {
			return this.roomNum.compareTo(other.getRoomNum());
		}
		return this.instructorName.compareTo(other.getInstructorName());
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
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

	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	@Override
	public String toString() {
		return String.format(COURSE_AS_STRING, ID, CRN, credits, instructorName, roomNum);
	}
}
