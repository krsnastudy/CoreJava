package com.prac.core.jdks.jdk5.mem;

class ResourceHolder {
    ResourceHolder() {
        System.out.println("In ResourceHolder class constructor");
    }

    @Override
    protected void finalize() throws Throwable{
        System.out.println("Finalizing object and releasing resources");
    }
}

public class FinalizeExample {
    public static void main(String[] args) {
        new ResourceHolder();
        System.gc(); // Request garbage collection
    }
}