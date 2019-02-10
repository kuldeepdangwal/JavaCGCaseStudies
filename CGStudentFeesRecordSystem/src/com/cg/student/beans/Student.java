package com.cg.student.beans;

public class Student {
	int studentId;
	String studentName;
	String studentAddress;
	long contactNumber;
	String studentClass;
	boolean transportStatus;
	Fees fees;
	public Student() {}
	public Student(String studentName, String studentAddress, long contactNumber, String studentClass,
			boolean transportStatus, Fees fees) {
		super();
		this.studentName = studentName;
		this.studentAddress = studentAddress;
		this.contactNumber = contactNumber;
		this.studentClass = studentClass;
		this.transportStatus = transportStatus;
		this.fees = fees;
	}
	public Student(int studentId, String studentName, String studentAddress, long contactNumber, String studentClass,
			boolean transportStatus, Fees fees) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAddress = studentAddress;
		this.contactNumber = contactNumber;
		this.studentClass = studentClass;
		this.transportStatus = transportStatus;
		this.fees = fees;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
	public boolean isTransportStatus() {
		return transportStatus;
	}
	public void setTransportStatus(boolean transportStatus) {
		this.transportStatus = transportStatus;
	}
	public Fees getFees() {
		return fees;
	}
	public void setFees(Fees fees) {
		this.fees = fees;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (contactNumber ^ (contactNumber >>> 32));
		result = prime * result + ((fees == null) ? 0 : fees.hashCode());
		result = prime * result + ((studentAddress == null) ? 0 : studentAddress.hashCode());
		result = prime * result + ((studentClass == null) ? 0 : studentClass.hashCode());
		result = prime * result + studentId;
		result = prime * result + ((studentName == null) ? 0 : studentName.hashCode());
		result = prime * result + (transportStatus ? 1231 : 1237);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (contactNumber != other.contactNumber)
			return false;
		if (fees == null) {
			if (other.fees != null)
				return false;
		} else if (!fees.equals(other.fees))
			return false;
		if (studentAddress == null) {
			if (other.studentAddress != null)
				return false;
		} else if (!studentAddress.equals(other.studentAddress))
			return false;
		if (studentClass == null) {
			if (other.studentClass != null)
				return false;
		} else if (!studentClass.equals(other.studentClass))
			return false;
		if (studentId != other.studentId)
			return false;
		if (studentName == null) {
			if (other.studentName != null)
				return false;
		} else if (!studentName.equals(other.studentName))
			return false;
		if (transportStatus != other.transportStatus)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentAddress=" + studentAddress
				+ ", contactNumber=" + contactNumber + ", studentClass=" + studentClass + ", transportStatus="
				+ transportStatus + ", fees=" + fees + "]";
	}
}
