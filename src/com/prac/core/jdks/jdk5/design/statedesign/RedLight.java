package com.prac.core.jdks.jdk5.design.statedesign;

// Concrete states
class RedLight implements TrafficLightState {
    public void next(TrafficLight light) {
        light.setState(new GreenLight());
    }
    public String getColor() {
        return "Red";
    }
}