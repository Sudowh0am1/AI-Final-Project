package com.company;

import java.util.PriorityQueue;

public class A_star {

    public PriorityQueue<state> priorityQueue = new PriorityQueue<>();
    public int n;

    public A_star(parking parking, int n) {

        this.n = n;
        state newState = new state(0, new huristic().get_h(parking), parking);
        priorityQueue.add(newState);

        outerLoop:
        while (true) {

            state state = new state(priorityQueue.poll());

            if (state.isGoal()) {
                System.out.println("Test #" + this.n + ": " + (state.g + 1));
                break;
            }

            for (int i = 0; i < state.parking.cars.size(); i++) {
                car car = new car(state.parking.cars.get(i));

                if (car.getDirection()) {
                    if (check_forward(state, i)) {
                        System.out.println("Test #" + this.n + ": " + (state.g + 2));
                        break outerLoop;
                    }
                    if (check_backward(state, i)) {
                        System.out.println("Test #" + this.n + ": " + (state.g + 2));
                        break outerLoop;
                    }
                } else {
                    if (check_up(state, i)) {
                        System.out.println("Test #" + this.n + ": " + (state.g + 2));
                        break outerLoop;
                    }
                    if (check_down(state, i)) {
                        System.out.println("Test #" + this.n + ": " + (state.g + 2));
                        break outerLoop;
                    }
                }
            }
        }
    }

    public boolean check_forward(state state, int i) {

        state newState = new state(state);
        if (newState.parking.can_Move_forward(newState.parking.cars.get(i))) {
            while (newState.parking.can_Move_forward(newState.parking.cars.get(i))) {
                newState.parking.move_forward(newState.parking.cars.get(i));
            }
            state state1 = new state(newState.g + 1, new huristic().get_h(newState.parking), newState.parking);
            if (!is_duplicate(state1)) {
                if (state1.isGoal()) {
                }
                priorityQueue.add(state1);
            }
        }
        return false;
    }

    public boolean check_backward(state state, int i) {
        state newState = new state(state);
        if (newState.parking.can_Move_backwards(newState.parking.cars.get(i))) {
            while (newState.parking.can_Move_backwards(newState.parking.cars.get(i))) {
                newState.parking.move_backwards(newState.parking.cars.get(i));
            }
            state state1 = new state(state.g + 1, new huristic().get_h(newState.parking), newState.parking);
            if (!is_duplicate(state1)) {
                if (state1.isGoal()) {
                    return true;
                }
                priorityQueue.add(state1);

            }
        }
        return false;
    }

    public boolean check_up(state state, int i) {
        state newState = new state(state);
        if (newState.parking.can_Move_up(newState.parking.cars.get(i))) {
            while (newState.parking.can_Move_up(newState.parking.cars.get(i))) {
                newState.parking.move_up(newState.parking.cars.get(i));
            }
            state state1 = new state(state.g + 1, new huristic().get_h(newState.parking), newState.parking);
            if (!is_duplicate(state1)) {
                if (state1.isGoal()) {
                    return true;
                }
                priorityQueue.add(state1);
            }
        }
        return false;
    }

    public boolean check_down(state state, int i) {
        state newState = new state(state);
        if (newState.parking.can_Move_down(newState.parking.cars.get(i))) {
            while (newState.parking.can_Move_down(newState.parking.cars.get(i))) {
                newState.parking.move_down(newState.parking.cars.get(i));
            }
            state state1 = new state(state.g + 1, new huristic().get_h(newState.parking), newState.parking);
            if (!is_duplicate(state1)) {
                if (state1.isGoal()) {
                    return true;
                }
                priorityQueue.add(state1);
            }
        }
        return false;
    }

    public boolean is_duplicate(state s) {
        for (state st : priorityQueue) {
            if (st.is_equal(s))
                return true;
        }
        return false;
    }
}