package com.prac.core.jdks.jdk11.files;

import com.prac.core.jdks.jdk8.stream.employee.data.Employee;
import com.prac.core.jdks.jdk8.stream.employee.data.EmployeeExt;
import com.prac.core.jdks.jdk8.stream.employee.data.PopulateEmpData;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class FileChanges {
    @SneakyThrows
    public static void writeFile (String fileName) {
        /*********/
        StringBuffer sb = new StringBuffer();
        int noOfRecords = new Random().nextInt(9999, 999999); // How many records you want
        List<Employee> emp = new ArrayList<Employee>();
        List<EmployeeExt> empDet = new ArrayList<EmployeeExt>();
        PopulateEmpData exec = new PopulateEmpData();
        emp = exec.populateEmpData(noOfRecords);
        empDet = exec.populateEmployeeMoreDetails(noOfRecords);

        empDet.parallelStream()
                .distinct()
                .collect(Collectors.groupingBy(EmployeeExt::getDepartment))
                .entrySet().stream()
                .forEach(e->{
                    sb.append("Department: "+e.getKey()+"[Count: "+e.getValue().size()+"]"+"\n" +
                            e.getValue().stream()
//                                    .map(m->m.getfName()+","+m.getlName()+"["+m.geteNumber()+"] Salary: "+m.geteSal())
                                    .map(m->m.toStringSpecific())
                                    .collect(Collectors.joining("~"))
                    ).append("\n\n");
                });
        ;
        System.out.println(sb.toString());
        String writeFileName = "src/resources/files/"+fileName;
        Files.writeString(Path.of(writeFileName), sb.toString());
        System.out.println("File Written Successfully of size "+empDet.size());
    }
}
