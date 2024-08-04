package com.prac.core.jdk8.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PartitioningBy {
    public static void main(String[] args) {
        List<Integer> list =
                IntStream.rangeClosed(1,100)
                         .mapToObj(i->i)
                         .collect(Collectors.toList());

       Map<Boolean, List<Integer>> map = list.stream()
                                             .collect(Collectors.partitioningBy(i->i%2==0));

       map.entrySet().stream().forEach(e->{
           if(e.getKey())
               System.out.println("Even: "+e.getValue());
           else
               System.out.println("Odd: "+e.getValue());
       });
    }
}
