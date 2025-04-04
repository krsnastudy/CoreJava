package com.prac.core.jdks.jdk5.design.statedesign;

class TrafficLight {
    private TrafficLightState state;

    public TrafficLight() {
        state = new RedLight(); // initial state
    }

    public void setState(TrafficLightState state) {
        this.state = state;
    }

    public void change() {
        state.next(this);
    }

    public void show() {
        System.out.println("Current Light: " + state.getColor());
    }
}