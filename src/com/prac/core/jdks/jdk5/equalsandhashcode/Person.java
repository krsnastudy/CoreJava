package com.prac.core.jdks.jdk5.equalsandhashcode;

class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    /**Even though .equals() returns true, the hashCode() is different, so HashSet won't find it.
     * Comment hashCode()
     * **/
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Person && ((Person) obj).name.equals(this.name);
    }

    /** hashCode() may match, but equals() will return false because it's checking object reference.
     * Comment equals(Object obj)
     * **/
    @Override
    public int hashCode() {
        return name.hashCode();
    }




    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
