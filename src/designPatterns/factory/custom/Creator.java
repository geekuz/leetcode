package designPatterns.factory.custom;

import java.util.Scanner;

public class Creator {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s = scanner.nextLine();
        CarFactory carFactory=new CarFactory();
        Car car = carFactory.makeCar(s);
        car.makeNoise();
    }
}
