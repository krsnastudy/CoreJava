package com.prac.core.jdk5.design.visitor;

interface Visitor {
    void visit(Developer developer);
    void visit(Manager manager);
}
