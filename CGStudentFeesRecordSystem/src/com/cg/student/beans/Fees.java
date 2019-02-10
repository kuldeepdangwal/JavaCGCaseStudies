package com.cg.student.beans;

public class Fees {
	int tutionFees;
	int transportFees;
	int examinationFees;
	public Fees() {}
	public Fees(int tutionFees, int examinationFees) {
		super();
		this.tutionFees = tutionFees;
		this.examinationFees = examinationFees;
	}
	public Fees(int tutionFees, int transportFees, int examinationFees) {
		super();
		this.tutionFees = tutionFees;
		this.transportFees = transportFees;
		this.examinationFees = examinationFees;
	}
	public int getTutionFees() {
		return tutionFees;
	}
	public void setTutionFees(int tutionFees) {
		this.tutionFees = tutionFees;
	}
	public int getTransportFees() {
		return transportFees;
	}
	public void setTransportFees(int transportFees) {
		this.transportFees = transportFees;
	}
	public int getExaminationFees() {
		return examinationFees;
	}
	public void setExaminationFees(int examinationFees) {
		this.examinationFees = examinationFees;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + examinationFees;
		result = prime * result + transportFees;
		result = prime * result + tutionFees;
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
		Fees other = (Fees) obj;
		if (examinationFees != other.examinationFees)
			return false;
		if (transportFees != other.transportFees)
			return false;
		if (tutionFees != other.tutionFees)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Fees [tutionFees=" + tutionFees + ", transportFees=" + transportFees + ", examinationFees="
				+ examinationFees + "]";
	}	
}
