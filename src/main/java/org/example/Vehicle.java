package org.example;

public class Vehicle {

    public static final String CONTROL_TYPE = "Radio Control";
    private String name;
    private String color;
    private int wheelCount;
    private double currentSpeed;
    private double mileage;
    private double fuelLevel;

    public double accelerate(double speed){
        currentSpeed += speed;

        return currentSpeed/60; //DISTANTA PARCURSA INTR-UN MINUT

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWheelCount() {
        return wheelCount;
    }

    public void setWheelCount(int wheelCount) {
        this.wheelCount = wheelCount;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }
    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public double accelerate(double speed) {

        setCurrentSpeed(getCurrentSpeed()+speed);

        double travelDistance = getCurrentSpeed()/60;
        double spentFuel = travelDistance * mileage/100;
        fuelLevel -= spentFuel;

        return super.accelerate(speed);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", wheelCount=" + wheelCount +
                '}';
    }

}
