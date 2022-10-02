package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<parking> parkings = new ArrayList<>();

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Enter the Inputs Respectively : " + "\nLine 1: number of parkings\nLine 2: V= no. rows      M= no. columns " +
                "     N= no. cars" + "\nLine 3 & so on: properties of each car");
        System.out.println("--------------------------------------------------------------------------");

        int n = Integer.parseInt(input.nextLine());

        for (int j = 1; j <= n; j++) {

            String data = input.nextLine();
            String[] parking_data = data.split(" ");

            ArrayList<car> cars = new ArrayList<car>();
            String[] data2;
            boolean direction;
            for (int i = 2; i < Integer.parseInt(parking_data[2]) + 2; i++) {
                data = input.nextLine();
                data2 = data.split(" ");
                direction = (data2[2].equals("h"));
                cars.add(new car(direction, Integer.parseInt(data2[3]), Integer.parseInt(data2[0]), Integer.parseInt(data2[1]), i));
            }
            parking p = new parking(Integer.parseInt(parking_data[0]), Integer.parseInt(parking_data[1]), cars);
            parkings.add(p);
        }
        for (int i = 0; i < parkings.size(); i++) {
            A_star a_star = new A_star(parkings.get(i), i + 1);
        }
    }
}
