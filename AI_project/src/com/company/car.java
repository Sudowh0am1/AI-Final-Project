package com.company;

public class car {
    boolean Direction;    //0 for Vertical        1 for Horizontal
    int length;
    int x;
    int y;
    int car_ID;

    public car(boolean direction, int length, int x, int y, int car_ID) {
        Direction = direction;
        this.length = length;
        this.x = x;
        this.y = y;
        this.car_ID = car_ID;
    }

    public car(car c) {
        this.Direction = c.getDirection();
        this.length = c.length;
        this.x = c.x;
        this.y = c.y;
        this.car_ID = c.car_ID;
    }

    public void forward() {
        this.y++;
    }

    public void backwards() {
        this.y--;
    }

    public void up() {
        this.x--;
    }

    public void down() {
        this.x++;
    }

    public boolean getDirection() {
        return Direction;
    }

    public int getLength() {
        return length;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCar_ID() {
        return car_ID;
    }

    public boolean is_equal(car c) {
        if (c.car_ID == this.car_ID && this.getDirection() == c.getDirection() && this.x == c.x && this.y == c.y)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "ID:" + car_ID + " x:" + this.x + " y:" + this.y;
    }
}
