package designPatterns.factory.custom;

public class Audi implements Car{
    @Override
    public void makeNoise() {
        System.out.println("AUDI IS MAKING A NOISE");
    }
}
