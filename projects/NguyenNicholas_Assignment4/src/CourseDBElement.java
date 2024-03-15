/**
 * @author Nicholas Nguyen
 */

public class CourseDBElement implements Comparable {
	private String ID;
	private int CRN;
	private int credits;
	private String roomNum;
	private String instructorName;

	public CourseDBElement(String ID, int CRN, int credits, String roomNum, String instructorName) {
		this.ID = ID;
		this.CRN = CRN;
		this.credits = credits;
		this.roomNum = roomNum;
		this.instructorName = instructorName;
	}

	@Override
	public int compareTo(Object o) {
		return 0;
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
}
