package com.prac.core.jdk5.design.visitor;

class Manager implements Employee {
    private String name;
    private double salary;

    public Manager(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}