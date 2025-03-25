package com.prac.core.jdks.jdk5.design.visitor;

interface Visitor {
    void visit(Developer developer);
    void visit(Manager manager);
}
