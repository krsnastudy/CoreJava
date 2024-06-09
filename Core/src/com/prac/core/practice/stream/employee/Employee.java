package com.prac.core.practice.stream.employee;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private String fName;
    private String lName;
    private int eNumber;
    private float eSal;
    private int ePincode;
    private String deptCode;
    private LocalDate dateOfJoin;
    private String gender;
}
