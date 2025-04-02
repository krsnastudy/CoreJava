package com.prac.core.jdks.jdk17.sealed;

public class SealedExample {
    public static void main(String[] args) {
        Shape shape = new Circle(5);

        // Pattern Matching
/*        double area = switch (shape) {
            case Circle c -> Math.PI * c.radius() * c.radius();
            case Rectangle r -> r.width() * r.height();
            case Triangle t -> 0.5 * t.base() * t.height();
        };*/

//        System.out.println("Area: " + area);
    }
}
