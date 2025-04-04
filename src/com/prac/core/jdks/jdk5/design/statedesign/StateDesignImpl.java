package com.prac.core.jdks.jdk5.design.statedesign;

public class StateDesignImpl {
    public static void main(String[] args) {
        TrafficLight signal = new TrafficLight();
        for (int i = 0; i < 6; i++) {
            signal.show();
            signal.change();
        }
    }
}
