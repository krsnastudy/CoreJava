package com.prac.core.jdk5.design.visitor;

class BonusVisitor implements Visitor {
    @Override
    public void visit(Developer developer) {
        System.out.println("Developer Bonus: " + (developer.getSalary() * 0.10));
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("Manager Bonus: " + (manager.getSalary() * 0.20));
    }
}
