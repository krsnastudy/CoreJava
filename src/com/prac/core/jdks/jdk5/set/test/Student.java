package com.prac.core.jdks.jdk5.set.test;


import java.util.Objects;

public class Student {
    private String fName;
    private String lName;
    private int eNumber;

    public Student(String fName, String lName, int eNumber) {
        this.fName = fName;
        this.lName = lName;
        this.eNumber = eNumber;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int geteNumber() {
        return eNumber;
    }

    public void seteNumber(int eNumber) {
        this.eNumber = eNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", eNumber=" + eNumber +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Student student = (Student) object;
        return eNumber == student.eNumber && Objects.equals(fName, student.fName) && Objects.equals(lName, student.lName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fName, lName, eNumber);
    }
}
