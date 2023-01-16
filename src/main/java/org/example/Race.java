package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Race {
    private double trackLength;
    private double trackFuelLevel;
    private int competitorCount = 2;
    private List<Vehicle> competitors = new ArrayList<Vehicle>();

    public List<Vehicle> getCompetitors() {
        return competitors;
    }
    public String readVehicleName() {
        System.out.println("Type a name for your vehicle and press Enter.");
        Scanner scanner = new Scanner(System.in);
        String vehicleName = scanner.nextLine();
        System.out.println("Your vehicle name is: "+vehicleName);

        return  vehicleName;
    }
    public double readAccelerationSpeed () throws Exception {
        System.out.println("Please enter acceleration speed as decimal number...");

        Scanner scanner = new Scanner(System.in);
        double accelerationSpeed = 0;
        try {
            accelerationSpeed = scanner.nextDouble();
            System.out.println("Acceleration speed: " +accelerationSpeed +"km/h");
        }
        catch (InputMismatchException exception){
            System.out.println("Please enter a valid number...");
            return readAccelerationSpeed();
        }
        return accelerationSpeed;
    }

    public void addCompetitor(){
        String name = readVehicleName();
        AutoVehicle autoVehicle = new AutoVehicle();
        autoVehicle.setName(name);

        double mileage = ThreadLocalRandom.current().nextDouble(6,15);
        autoVehicle.setMileage(mileage);

        System.out.println("Mlileage for vehicle with name" + autoVehicle.getName() + ": "+ mileage +" l/100km");
        competitors.add(autoVehicle);
    }
    public void addAllCompetitors(){
        for(int i=0;i<competitorCount;i++){
            addCompetitor();
        }
    }
    public AutoVehicle winner() throws Exception {
        int noFuelCompetitors = 0;
        boolean noWinner = true;

        for(Vehicle vehicle: competitors){
            double accelerationSpeed = readAccelerationSpeed();
            double travelDistance = vehicle.accelerate(accelerationSpeed);
            if(vehicle.getFuelLevel() <= 0) noFuelCompetitors++;
            if(travelDistance >= trackLength){
                noWinner = true;
                System.out.println("The winner is"+vehicle.getName());
                break;
            }
        }
    }
}
