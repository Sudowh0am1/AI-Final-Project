package com.company;

public class state implements Comparable<state> {
    int h;
    int g;
    parking parking;

    public state(int g, int h, parking p) {
        this.g = g;
        this.h = h;
        this.parking = new parking(p);
    }

    public state(state state) {
        this.g = state.g;
        this.h = state.h;
        this.parking = new parking(state.parking);
    }

    @Override
    public int compareTo(state o) {
        if (this.g + this.h > o.g + o.h)
            return 1;

        else if (this.g + this.h < o.g + o.h)
            return -1;

        else if (this.h > o.h)
            return 1;

        else if (this.h < o.h)
            return -1;

        else return 0;

    }

    public boolean isGoal() {
        return h == 0;
    }

    @Override
    public String toString() {
        return "g" + this.g + " h" + this.h;
    }

    public boolean is_equal(state s) {
        if (this.parking.is_equal(s.parking))
            return true;
        return false;
    }
}
