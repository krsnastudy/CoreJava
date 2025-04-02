package com.prac.core.jdks.jdk11.timeunit;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class TimeUnitConversion {
    public static void main(String[] args) {
        Consumer<Long> cOut = p -> System.out.println(p);
        TimeUnit timeUnit = TimeUnit.DAYS;

        long duration24 = timeUnit.convert(Duration.ofHours(24));
        cOut.accept(duration24);

        long duration50 = timeUnit.convert(Duration.ofHours(50));
        cOut.accept(duration50);
    }
}