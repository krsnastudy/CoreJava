package com.prac.core.jdks.jdk8.threads.deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class DeadlockDetector {

    public static void detectDeadlock() {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        long[] threadIds = bean.findDeadlockedThreads(); // detects monitor deadlocks

        if (threadIds != null) {
            ThreadInfo[] infos = bean.getThreadInfo(threadIds);
            System.out.println("Deadlock detected!");

            for (ThreadInfo info : infos) {
                System.out.println("Thread name: " + info.getThreadName());
                System.out.println("Waiting for lock: " + info.getLockName());
                System.out.println("Owned by: " + info.getLockOwnerName());
                System.out.println("--------------------------------");
            }
        } else {
            System.out.println("No deadlocks detected.");
        }
    }
}
