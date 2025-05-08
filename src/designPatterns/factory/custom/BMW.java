package designPatterns.factory.custom;

public class BMW implements Car{
    @Override
    public void makeNoise() {
        System.out.println("BMW IS MAKING A NOISE");
    }
}
