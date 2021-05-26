package com.prac.core.jdk5.map;

public class Student {

	private String studentname;
	private long studentno;
	private String schoolname;
	private String studentclass;
	private String studentsection;
	
	public Student(String studentname, long studentno, String schoolname, String studentclass, String studentsection) {
		super();
		this.studentname = studentname;
		this.studentno = studentno;
		this.schoolname = schoolname;
		this.studentclass = studentclass;
		this.studentsection = studentsection;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public long getStudentno() {
		return studentno;
	}

	public void setStudentno(long studentno) {
		this.studentno = studentno;
	}

	public String getSchoolname() {
		return schoolname;
	}

	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}

	public String getStudentclass() {
		return studentclass;
	}

	public void setStudentclass(String studentclass) {
		this.studentclass = studentclass;
	}

	public String getStudentsection() {
		return studentsection;
	}

	public void setStudentsection(String studentsection) {
		this.studentsection = studentsection;
	}

	@Override
	public String toString() {
		return "[Number=" + studentno + ", School=" + schoolname
				+ ", Class=" + studentclass + ", Section=" + studentsection + "]";
	}

	
	@Override
	public int hashCode() {
		System.out.print("Student hashCode(): ");
		final int prime = 31;
		int result = 1;
		result = prime * result + ((schoolname == null) ? 0 : schoolname.hashCode());
		result = prime * result + ((studentclass == null) ? 0 : studentclass.hashCode());
		result = prime * result + ((studentname == null) ? 0 : studentname.hashCode());
		result = prime * result + (int) (studentno ^ (studentno >>> 32));
		result = prime * result + ((studentsection == null) ? 0 : studentsection.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		System.out.print("Student equals(): ");
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (schoolname == null) {
			if (other.schoolname != null)
				return false;
		} else if (!schoolname.equals(other.schoolname))
			return false;
		if (studentclass == null) {
			if (other.studentclass != null)
				return false;
		} else if (!studentclass.equals(other.studentclass))
			return false;
		if (studentname == null) {
			if (other.studentname != null)
				return false;
		} else if (!studentname.equals(other.studentname))
			return false;
		if (studentno != other.studentno)
			return false;
		if (studentsection == null) {
			if (other.studentsection != null)
				return false;
		} else if (!studentsection.equals(other.studentsection))
			return false;
		return true;
	}
	
}
