package com.prac.core.jdk5.design.visitor;

interface Employee {
    void accept(Visitor visitor);  // Accept visitor
}
