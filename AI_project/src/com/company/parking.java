package com.company;

import java.util.ArrayList;

public class parking {
    int x;
    int y;
    int[][] parking_;
    ArrayList<car> cars = new ArrayList<car>();

    public parking(int x, int y, ArrayList<car> cars) {
        this.x = x + 2;
        this.y = y + 2;
        this.cars = cars;
        this.parking_ = new int[this.x][this.y];

        for (int i = 0; i < this.x; i++) {
            parking_[i][0] = 1;
            parking_[i][this.y - 1] = 1;
        }

        for (int i = 0; i < this.y; i++) {
            parking_[0][i] = 1;
            parking_[this.y - 1][i] = 1;
        }

        for (int i = 0; i < cars.size(); i++) {
            set_parking(cars.get(i));
        }
    }

    public parking(parking p) {

        this.x = p.x;
        this.y = p.y;
        for (int i = 0; i < p.cars.size(); i++) {
            this.cars.add(new car(p.cars.get(i)));
        }

        this.parking_ = new int[this.x][this.y];

        for (int i = 0; i < this.x; i++) {
            parking_[i][0] = 1;
            parking_[i][this.y - 1] = 1;
        }

        for (int i = 0; i < this.y; i++) {
            parking_[0][i] = 1;
            parking_[this.y - 1][i] = 1;
        }

        for (int i = 0; i < cars.size(); i++) {
            set_parking(p.cars.get(i));
        }

    }

    public void reset_parking(car car) {
        int count = 0;
        if (car.getDirection()) {
            for (int j = car.getY(); ; j++) {
                if (count == car.getLength())
                    break;
                parking_[car.getX()][j] = 0;
                count++;
            }
        } else {
            for (int j = car.getX(); ; j++) {
                if (count == car.getLength())
                    break;
                parking_[j][car.getY()] = 0;
                count++;
            }
        }
    }

    public void set_parking(car car) {
        int count = 0;
        if (car.Direction) {
            for (int j = car.getY(); ; j++) {
                if (count == car.getLength())
                    break;
                parking_[car.getX()][j] = car.getCar_ID();
                count++;
            }
        } else {
            for (int j = car.getX(); ; j++) {
                if (count == car.getLength())
                    break;
                parking_[j][car.getY()] = car.getCar_ID();
                count++;
            }
        }
    }

    //moving
    public boolean move_forward(car car) {
        if (can_Move_forward(car)) {
            reset_parking(car);
            car.forward();
            set_parking(car);
            return true;
        }
        return false;
    }

    public boolean move_backwards(car car) {
        if (can_Move_backwards(car)) {
            reset_parking(car);
            car.backwards();
            set_parking(car);
            return true;
        }
        return false;
    }

    public boolean move_up(car car) {
        if (can_Move_up(car)) {
            reset_parking(car);
            car.up();
            set_parking(car);
            return true;
        }
        return false;
    }

    public boolean move_down(car car) {
        if (can_Move_down(car)) {
            reset_parking(car);
            car.down();
            set_parking(car);
            return true;
        }
        return false;
    }


    //checking
    public boolean can_Move_forward(car car) {
        if (parking_[car.x][car.y + car.length] == 0)
            return true;
        return false;
    }

    public boolean can_Move_backwards(car car) {
        if (parking_[car.x][car.y - 1] == 0)
            return true;
        return false;
    }

    public boolean can_Move_up(car car) {
        if (parking_[car.x - 1][car.y] == 0)
            return true;
        return false;
    }

    public boolean can_Move_down(car car) {
        if (parking_[car.x + car.length][car.y] == 0)
            return true;
        return false;
    }

    public void show_cars() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (parking_[i][j] < 10)
                    System.out.print(parking_[i][j] + "  ");
                else
                    System.out.print(parking_[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public car getRedCar() {
        return cars.get(0);
    }

    public boolean is_equal(parking p) {

        for (int i = 0; i < this.cars.size(); i++) {
            if (!(this.cars.get(i).is_equal(p.cars.get(i))))
                return false;
        }
        return true;
    }
}

