package com.prac.core.jdks.jdk5.design.visitor;

class TaxVisitor implements Visitor {
    @Override
    public void visit(Developer developer) {
        System.out.println("Developer Tax Deduction: " + (developer.getSalary() * 0.15));
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("Manager Tax Deduction: " + (manager.getSalary() * 0.25));
    }
}
