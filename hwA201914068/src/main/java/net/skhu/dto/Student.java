package net.skhu.dto;

public class Student {
	int id;
	String studentNumber;
	String studentName;
	String email;

	public Student(int id, String studentNumber, String studentName, String email) {
		super();
		this.id = id;
		this.studentNumber = studentNumber;
		this.studentName = studentName;
		this.email = email;
	}

	public Student() {
    }


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
