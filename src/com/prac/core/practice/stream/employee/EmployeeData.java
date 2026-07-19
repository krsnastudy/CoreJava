package com.prac.core.practice.stream.employee;

import java.util.List;
import java.util.Random;

public class EmployeeData {
    public static List<Employee> getEmployeeData(int count) {
        PopulateEmpData exec = new PopulateEmpData();
        int noOfRecords = new Random().nextInt(5, 999);
        int rCount = count==0?noOfRecords:count;
        return exec.populateEmployeeData(rCount);
    }
}
