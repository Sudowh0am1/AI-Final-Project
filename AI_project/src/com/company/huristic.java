package com.company;

public class huristic {

    public int get_h(parking parking) {

        int h = 0;
        for (int i = 1; i < parking.cars.size(); i++) {
            car car = parking.cars.get(i);
            if (car.getDirection()) {
                if (car.getX() == parking.getRedCar().getX()) {
                    System.out.println("this problem cant solve until the car with " + car.car_ID + " car in the parking");
                    System.exit(0);
                }
            } else {
                for (int j = car.getX(); j < car.getX() + car.length; j++) {
                    if (j == parking.getRedCar().getX() && car.getY() > parking.getRedCar().getY()) {
                        h++;
                        break;
                    }
                }
            }
        }
        return h;
    }
}
