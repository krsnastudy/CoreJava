package com.prac.core.jdks.jdk5.design.statedesign;

public class YellowLight implements TrafficLightState {
    public void next(TrafficLight light) {
        light.setState(new RedLight());
    }
    public String getColor() {
        return "Yellow";
    }
}
