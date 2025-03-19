package com.prac.core.jdk8.stream.employee.records;

import com.prac.core.jdk8.stream.employee.data.Department;

record Employee(
String firstName,
String lastName,
int employeeNumber,
float employeeSal,
int employeePincode,
String employeeDepartment,
int employeeAge,
String gender){}