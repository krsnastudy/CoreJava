package com.prac.core.jdks.jdk5.design.visitor;

import java.util.*;

public class VisitorPatternDemo {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Developer("Alice", 60000));
        employees.add(new Manager("Bob", 80000));

        Visitor bonusVisitor = new BonusVisitor();
        Visitor taxVisitor = new TaxVisitor();

        for (Employee employee : employees) {
            employee.accept(bonusVisitor);
            employee.accept(taxVisitor);
        }
    }
}
