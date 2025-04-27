package com.prac.core.jdks.jdk5.string;

public class CallByvalue {
    void swap(StringBuilder a, StringBuilder b) {
        System.out.println("B4");
        System.out.println("a: "+a.hashCode());
        System.out.println("b: "+b.hashCode());

        StringBuilder temp = a;
        a = b;
        b = temp;

        System.out.println("A4");
        System.out.println("a: "+a.hashCode());
        System.out.println("b: "+b.hashCode());
    }

    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder("Hello");
        StringBuilder sb2 = new StringBuilder("World");

/*
        System.out.println("sb1: "+sb1.hashCode());
        System.out.println("sb2: "+sb2.hashCode());
*/

        new CallByvalue().swap(sb1, sb2);

        System.out.println(sb1); // ???
        System.out.println(sb2); // ???

/*        System.out.println("sb1: "+sb1.hashCode());
        System.out.println("sb2: "+sb2.hashCode());*/

    }

}

/*
* What happens here?
* Inside swap(), the values of the references a and b are swapped locally.
* BUT — since Java passes copy of reference, the original sb1 and sb2 in main() remain unchanged!
* So output will still be:
* Hello
* World
*
* */