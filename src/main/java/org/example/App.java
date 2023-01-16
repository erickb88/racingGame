package org.example;
/**
 * MAIN METHOD *
 */
public class App {

    public static void main( String[] args ) {

        Engine daciaEngine = new Engine();
        daciaEngine.setManufacturer("Renault");

        RadioControlledCar dacia = new RadioControlledCar(daciaEngine);
        dacia.setEngine(daciaEngine);
        dacia.setName("Dacia");
        dacia.setColor("red");
        dacia.setDoorCount(4);
        dacia.setWheelCount(4);
        dacia.setMileage(8.5);

        Engine ladaEngine = new Engine();
        ladaEngine.setManufacturer("Lada");

        RadioControlledCar lada = new RadioControlledCar(ladaEngine);
        lada.setEngine(ladaEngine);
        lada.setName("Lada");
        lada.setColor("blue");
        lada.setDoorCount(2);
        lada.setWheelCount(4);
        lada.setMileage(7.5);

        RadioControlledMotorcycle yamaha = new RadioControlledMotorcycle(new Engine());

        Race race = new Race();
        race.getCompetitors().add(dacia);
        race.getCompetitors().add(lada);

 /*       for(int i = 0; i<race.getCompetitors().length; i++){
            if(race.getCompetitors()[i]!=null) {
                System.out.println("Vehicle "+i+": "+race.getCompetitors()[i].getName());
            }
        }
*/
        for (Vehicle vehicle : race.getCompetitors()) {
            if(vehicle != null) System.out.println(vehicle.getName());
        }



    }
}
