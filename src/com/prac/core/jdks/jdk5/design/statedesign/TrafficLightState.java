package com.prac.core.jdks.jdk5.design.statedesign;

// State interface
interface TrafficLightState {
    void next(TrafficLight light);
    String getColor();
}