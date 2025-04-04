package com.prac.core.jdks.jdk8.threads.objectclassLock;

class Logger {
    private static int logCount = 0;

    // Class-level lock (synchronized static method)
    public static synchronized void log(String msg) {
        logCount++;
        System.out.println(msg + "  " + logCount);
    }

    // Class-level lock (synchronized block on Class object)
    public static void logError(String error) {
        synchronized (Logger.class) { // Locks the Class object
            logCount++;
            System.err.println(error + "  " + logCount);
        }
    }
}

class Main {
    public static void main(String[] args) {
        // Even with different Logger instances, threads contend for the SAME lock
        Thread t1 = new Thread(() -> Logger.log("Info: System started"));
        Thread t2 = new Thread(() -> Logger.logError("Error: File not found"));

        t1.start();
        t2.start();
    }
}