package com.prac.core.practice.stream.employee;

import java.util.Comparator;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;

import static com.prac.core.practice.stream.employee.PopulateEmpData.populateEmployeeData;

public class AsynExample {
    static final int noOfRec = 999;
    static final int cpuCores = Runtime.getRuntime().availableProcessors();
    static ExecutorService executor = Executors.newFixedThreadPool(cpuCores);
    static BiConsumer<String, String> biConsumer = (a,b)-> System.out.println("\nStep: "+a+" -- Thread Name: "+b);
    PopulateEmpData data = new PopulateEmpData();

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        AsynExample asynExample = new AsynExample();
        asynExample.process().get();
        executor.shutdown();
    }

    public static CompletableFuture<Void> process() {
        // Fetch employees data
        CompletableFuture<Void> empDetCF = CompletableFuture
            .supplyAsync(()->{
                biConsumer.accept("Fetching Employee Records", Thread.currentThread().getName());
                return populateEmployeeData(noOfRec);
            }, executor)

            .thenApplyAsync( (list1)->{
                biConsumer.accept("Filter Salary>20000 ", Thread.currentThread().getName());
                return list1.stream().filter(f->f.getESal()>20000).toList();
            }, executor)

            .thenApplyAsync((list2)->{
                biConsumer.accept("First Name/Last Name Starts with K ", Thread.currentThread().getName());
                return list2.stream().filter(f->f.getFName().startsWith("K") || f.getLName().startsWith("K")).toList();
            }, executor)

            .thenApplyAsync((list3)->{
                biConsumer.accept("Fetch Department ID -- Infra & IT", Thread.currentThread().getName());
                return list3.stream().filter(f->f.getDeptCode().equals("IT") || f.getDeptCode().equals("Admin") || f.getDeptCode().equals("Finance")).toList();
            })

            .exceptionallyAsync((exception)->{
                biConsumer.accept("In Exception Block ", Thread.currentThread().getName());
                exception.printStackTrace();
                return null;
            }, executor)

            .thenAcceptAsync((data)->{
                biConsumer.accept("Finally Sorting by DeptId,Sal ", Thread.currentThread().getName());
                data.stream().sorted(Comparator.comparing(Employee::getDeptCode).thenComparing(Employee::getESal))
                        .forEach(System.out::println);
            }, executor)

            .thenRunAsync(()->{
                System.out.println();
                biConsumer.accept("Completed the Async Programming ", Thread.currentThread().getName());
            });

        return empDetCF;
    }//psvm
}//Main