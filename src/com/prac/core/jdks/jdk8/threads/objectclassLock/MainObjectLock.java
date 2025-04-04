package com.prac.core.jdks.jdk8.threads.objectclassLock;

import org.springframework.scheduling.annotation.Async;

import java.util.stream.IntStream;

public class MainObjectLock {
    public static void main(String[] args) {
        CounterObjectLock c1 = new CounterObjectLock();
        CounterObjectLock c2 = new CounterObjectLock();

        // Threads can run in parallel (different objects)
        Thread t1 = new Thread(() -> c1.increment());
        Thread t2 = new Thread(() -> c2.increment());

        t1.start();
        t2.start();

/*        for(int i=1; i<=10; i++){
            Thread thread = new Thread(() -> c1.increment(), "Thread-"+i);
            thread.start();
        }*/


/*        IntStream.range(99, 110)
                .parallel()
                .forEach(i -> {
                    Thread thread = new Thread(() -> c1.increment(), "Thread-" + i);
                    thread.start();
                });*/

        callAsync();
    }

    @Async
    public static void callAsync(){
        CounterObjectLock c1 = new CounterObjectLock();

        IntStream.range(99, 110)
                .parallel()
                .forEach(i -> {
                    Thread thread1 = new Thread(() -> c1.increment(), "Thread1-" + i);
                    thread1.start();

                    if(i%2==0) {
                        Thread thread = new Thread(() -> new CounterObjectLock().increment(), "Thread-" + i);
                        thread.start();
                    }else{
                        Thread thread = new Thread(() -> new CounterObjectLock().decrement(), "Thread-" + i);
                        thread.start();
                    }
                });
    }
}
