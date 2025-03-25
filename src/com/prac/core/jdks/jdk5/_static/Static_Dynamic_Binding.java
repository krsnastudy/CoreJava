package com.prac.core.jdks.jdk5._static;

public class Static_Dynamic_Binding {
    public static void main(String[] args) {
        Parent obj1 = new Parent();
        Parent obj2 = new Child(); // Reference of Parent, but object of Child

        obj1.staticMethod(); // Calls Parent's static method
        obj2.staticMethod(); // Calls Parent's static method (Not Child's)

        obj1.instanceMethod(); // Calls Parent's instance method
        obj2.instanceMethod(); // Calls Child's instance method (Dynamic Binding)
    }
}

class Parent {
    static void staticMethod() {
        System.out.println("Parent - Static Method");
    }

    void instanceMethod() {
        System.out.println("Parent - Instance Method");
    }
}

class Child extends Parent {
    static void staticMethod() { // Hiding Parent's static method
        System.out.println("Child - Static Method");
    }

    @Override
    void instanceMethod() { // Overriding Parent's instance method
        System.out.println("Child - Instance Method");
    }
}

/*
*
*Static Binding (Early Binding)
Static binding occurs at compile-time. The method that needs to be called is resolved during compilation.
*
*
*Dynamic Binding (Late Binding)
Dynamic binding occurs at runtime. The method call is resolved based on the actual object type (not the reference type).
*
*When to Use What?
*
* ✅ Use Static Binding When:
You need better performance.
The method should not be overridden (final, private, or static).
You are designing utility/helper methods (static methods).
*
✅ Use Dynamic Binding When:
You need polymorphism (method overriding).
You are designing flexible, extensible systems.
You want runtime behavior based on object type.
*
* */