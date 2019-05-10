package colin29.court.domain.bank;

public class Employee {
	private int employeeId;
	private String fname;
	private String lname;
	private String title;
	private int assignedBranchId;

	public int getEmployeeId() {
		return employeeId;
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public String getTitle() {
		return title;
	}

	public int getAssignedBranchId() {
		return assignedBranchId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAssignedBranchId(int assignedBranchId) {
		this.assignedBranchId = assignedBranchId;
	}

}
