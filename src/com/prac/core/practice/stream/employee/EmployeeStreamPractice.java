package com.prac.core.practice.stream.employee;

import com.prac.core.practice.stream.employee.Employee;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class EmployeeStreamPractice {
    @SuppressWarnings("static-access")
	public static void main(String[] args) {
        PopulateEmpData exec = new PopulateEmpData();
        int noOfRecords = new Random().nextInt(5, 999);
        List<Employee> empList = new ArrayList<>();
        int salRandom = new Random().nextInt(1, 9);
        int salFilter = salRandom * 10000;        
        
        empList = exec.populateEmployeeData(noOfRecords);

/*        System.out.println("Printing "+noOfRecords+" Employees Information By Department Wise");
        empList.stream()
                .collect(Collectors.groupingBy(Employee::getDeptCode))
                .entrySet()
                .stream()
                .forEach(System.out::println);*/

        // Employee FirstName StartsWith K
        System.out.println("\nEmployee FirstName/LastName StartsWith K");
        empList.stream()
                .filter(f-> (f.getFName().startsWith("K") || f.getLName().startsWith("K")))
                .forEach(System.out::println);

        //Employee Details Salary >50000
        System.out.println("\nEmployees Salary>"+(salFilter/1000)+" Thousands");
        empList.stream()
        		.sorted(Comparator.comparing(Employee::getESal))
                .filter(f->f.getESal()>salFilter)
                .forEach(System.out::println);

        //Employee Details Sort By FirstName
        System.out.println("\nEmployee Details Sort By FirstName");
        empList.stream()
                .sorted(Comparator.comparing(Employee::getFName))
//                .sorted(Comparator.comparing(Employee::getFName).reversed())
                .forEach(System.out::println);

        //Employee Details Sort By FirstName, LastName
        System.out.println("\nEmployee Details Sort By FirstName, LastName");
        Comparator<Employee> nameComparator =
                Comparator.comparing(Employee::getFName)
                          .thenComparing(Employee::getLName);

        empList.stream()
                .sorted(nameComparator)
                .forEach(System.out::println);

        //Employee Details Sum Of Salary
        Float totSal =
        empList.stream()
                .map(m->m.getESal())
                .reduce((float)0, (a, b)->a+b);
        System.out.println("\nSum of All Employees Salary : "+totSal);

        //Employee Details Dept Wise Sort By Salary
        System.out.println("\nPrinting Employees Dept Wise Sorting By Salary");
        empList.stream()
                .collect(Collectors.groupingBy(Employee::getDeptCode))
                .entrySet().stream()
                .forEach(e->{
                    System.out.println("\n/*************************  Department "+e.getKey()+"  ********************/\n"+
                        e.getValue().stream().sorted(Comparator.comparing(Employee::getESal)).toList()
                    );
                });

        //Employees Salary Sum DeptWise
        System.out.println("\nSum of All Employees Salary Dept Wise: ");
        empList.stream()
                .collect(Collectors.groupingBy(Employee::getDeptCode))
                .forEach((k,v)->{
                    System.out.println("Department "+k + " Salary Total : "+
                        v.stream().map(m->m.getESal()).reduce((float)0, (a,b)->a+b)
                    );
                });

        //Employees Salary Summarization DeptWise
        System.out.println("\nAverage of Employees Salary Dept Wise: ");
        empList.stream()
                .collect(Collectors.groupingBy(Employee::getDeptCode))
                .entrySet().stream()
                .forEach(e->{
                    System.out.println("Department "+e.getKey()+" --> " +
                        e.getValue().stream()
                                .collect(Collectors.summarizingDouble(Employee::getESal))
//                                .getMin()
//                                .getMax()
                                .getAverage()
//                                .getCount()
                    );
                });

        // Highest Salaried Employee
        Employee highSal =
        empList.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getESal))).get();
        System.out.println("\nHighest Salary Paid Employee : "+highSal);

        // Lowest Salaried Employee
        Employee lowSal = empList.stream().collect(Collectors.minBy(Comparator.comparing(Employee::getESal))).get();
        System.out.println("Lowest Salary Paid Employee : "+lowSal);

        // Indexed Base highest Salary
        int idx = 2;
        Employee idxSal =
        empList.stream().sorted(Comparator.comparing(Employee::getESal)).toList().get(idx-1);
        System.out.println(idx+" Highest Salary Paid Employee : "+idxSal);

        // Department Wise Indexed Base highest Salary
        int dIdx = new Random().nextInt(2, (noOfRecords/10));
        String rankPrefix = dIdx<2 ? ("st") : ((dIdx>2 && dIdx<3)?"nd":(dIdx>2 && dIdx<4)?"rd":"th");
        
        System.out.println("\n"+dIdx+rankPrefix+" Highest Salary Department Wise");
                empList.stream()
                        .collect(Collectors.groupingBy(Employee::getDeptCode))
                        .entrySet().stream()
                        .filter(f->(dIdx-1)<f.getValue().size())
                        .forEach(e->{
                            System.out.println(e.getKey() +" Department "+dIdx+rankPrefix+" Highest Salary --> " +
                                e.getValue().stream().sorted(Comparator.comparing(Employee::getESal)).toList().get(dIdx-1)
                            );
                        });

        // Department Wise Count of Employees
        System.out.println("\nEmployees Total Count Department Wise");
        empList.stream()
                .collect(Collectors.groupingBy(Employee::getDeptCode, Collectors.counting()))
                .entrySet().stream()
                .forEach(System.out::println);

        //Adding Emp Details to Map
        System.out.println("\nEmployees Sorting By Sal, Dept");
        empList.stream()
                .sorted(Comparator.comparing(Employee::getDeptCode).thenComparing(Employee::getESal))
                .collect(Collectors.toMap(Employee::getENumber, Function.identity(), (a,b)->a, LinkedHashMap::new))
                .entrySet().stream()
                .forEach(e-> System.out.println("EmployeeId: "+e.getKey()+" ["+e.getValue().getFName()+" "+e.getValue().getLName()+"] --> "+e.getValue()))
        ;

        // Fetch Employees By Gender Base
//        empList.stream()
//                .collect(Collectors.groupingBy(Employee::getGender))
//                .entrySet().stream()
//                .forEach(e-> System.out.println("\n/********** Gender: "+e.getKey()+" ***********/\n"+e.getValue()));

        // Fetch Employees By Gender Base
        empList.stream()
               .collect(Collectors.groupingBy(Employee::getGender))
               .entrySet().stream().sorted(Map.Entry.comparingByKey())
               .forEach(e-> System.out.println("\n"+e.getKey()+" Gender "+"\n"+e.getValue()));

        // Fetch Employees of DOJ in Year 2022
/*        int doj = 2022;
        System.out.println("\nEmployees Joined in Year "+doj);
        empList.stream()
                .filter(f->f.getDateOfJoin().getYear()==doj)
                .forEach(System.out::println);*/

        // Group Employees by DOJ
        empList.stream()
                .collect(Collectors.groupingBy(yr -> CommonUtil.getYear(yr.getDateOfJoin())))
                .forEach((x,y)-> System.out.println("\n/********** Year: "+x+"**********/\n"+y));

        System.out.println("\n/****** Employees Salary Summation By Yearwise *****/");
        empList.stream()
                .collect(Collectors.groupingBy(g->CommonUtil.getYear(g.getDateOfJoin())))
                .entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach(e-> System.out.println(e.getKey()+" Year Employees Count "+e.getValue().size()+", Salary Total: "+
//                        e.getValue().stream().collect(Collectors.summarizingDouble(Employee::getESal)).getSum()
						BigDecimal.valueOf(e.getValue().stream().collect(Collectors.summarizingDouble(Employee::getESal)).getSum()).setScale(2, RoundingMode.HALF_UP)
                        ));

        System.out.println("\n/****** Employees Salary Summation By Gender *****/");
        empList.stream()
                .collect(Collectors.groupingBy(Employee::getGender))
                .entrySet().stream()
                .forEach(x-> System.out.println(x.getKey()+" Total Salary: "+
//                        x.getValue().stream().map(m->m.getESal()).reduce((float)0, (a,b)->a+b)
//                        x.getValue().stream().collect(Collectors.summarizingDouble(Employee::getESal)).getSum()
						BigDecimal.valueOf(x.getValue().stream().collect(Collectors.summarizingDouble(Employee::getESal)).getSum()).setScale(2, RoundingMode.HALF_UP)	
                    )
                );

        
        
        /************** Total Count ****************/
        System.out.println("\nTotal Records Processing: "+noOfRecords);
    }//psvm
}//StreamPractice