package designPatterns.factory;

public class FactoryDemo {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        
        // Get Circle object
        Shape circle = factory.createShape("CIRCLE");
        circle.draw();
        
        // Get Rectangle object
        Shape rectangle = factory.createShape("RECTANGLE");
        rectangle.draw();
    }
}