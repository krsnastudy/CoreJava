package com.prac.core.jdks.jdk5.design.statedesign;

public class GreenLight implements TrafficLightState {
    public void next(TrafficLight light) {
        light.setState(new YellowLight());
    }
    public String getColor() {
        return "Green";
    }
}